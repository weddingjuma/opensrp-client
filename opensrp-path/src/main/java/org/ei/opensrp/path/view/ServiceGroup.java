package org.ei.opensrp.path.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.ei.opensrp.commonregistry.CommonPersonObjectClient;
import org.ei.opensrp.domain.Alert;
import org.ei.opensrp.domain.ServiceRecord;
import org.ei.opensrp.domain.ServiceType;
import org.ei.opensrp.path.R;
import org.ei.opensrp.path.adapter.ServiceCardAdapter;
import org.ei.opensrp.path.db.VaccineRepo;
import org.ei.opensrp.path.domain.ServiceWrapper;
import org.ei.opensrp.path.repository.VaccineRepository;
import org.joda.time.DateTime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import util.Utils;

import static util.VaccinatorUtils.generateScheduleList;
import static util.VaccinatorUtils.receivedServices;

/**
 * Created by keyman on 15/05/2017.
 */

public class ServiceGroup extends LinearLayout implements View.OnClickListener,
        ServiceCard.OnServiceStateChangeListener {
    private static final String TAG = "ServiceGroup";
    private Context context;
    private TextView nameTV;
    private TextView recordAllTV;
    private ExpandableHeightGridView servicesGV;
    private ServiceCardAdapter serviceCardAdapter;
    private List<ServiceType> serviceTypes;
    private CommonPersonObjectClient childDetails;
    private List<ServiceRecord> serviceRecordList;
    private List<Alert> alertList;
    private State state;
    private OnServiceClickedListener onServiceClickedListener;
    private OnServiceUndoClickListener onServiceUndoClickListener;
    private SimpleDateFormat READABLE_DATE_FORMAT = new SimpleDateFormat("dd MMMM, yyyy", Locale.US);
    private boolean modalOpen;

    private static enum State {
        IN_PAST,
        CURRENT,
        IN_FUTURE
    }

    public ServiceGroup(Context context) {
        super(context);
        init(context);
    }

    public ServiceGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ServiceGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public CommonPersonObjectClient getChildDetails() {
        return this.childDetails;
    }

    public List<ServiceType> getServiceTypes() {
        return serviceTypes;
    }

    public List<ServiceRecord> getServiceRecordList() {
        return this.serviceRecordList;
    }

    public List<Alert> getAlertList() {
        return alertList;
    }

    public void setServiceRecordList(List<ServiceRecord> serviceRecordList) {
        this.serviceRecordList = serviceRecordList;
    }

    public void setAlertList(List<Alert> alertList) {
        this.alertList = alertList;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ServiceGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.view_service_group, this, true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);
        nameTV = (TextView) findViewById(R.id.name_tv);
        servicesGV = (ExpandableHeightGridView) findViewById(R.id.services_gv);
        servicesGV.setExpanded(true);
        recordAllTV = (TextView) findViewById(R.id.record_all_tv);
        recordAllTV.setOnClickListener(this);
    }

    public void setData(CommonPersonObjectClient childDetails, List<ServiceType> serviceTypes, List<ServiceRecord> serviceRecordList, List<Alert> alerts) {
        this.childDetails = childDetails;
        this.serviceTypes = serviceTypes;
        this.serviceRecordList = serviceRecordList;
        this.alertList = alerts;
        updateViews();
    }

    public void setOnServiceUndoClickListener(OnServiceUndoClickListener onServiceUndoClickListener) {
        this.onServiceUndoClickListener = onServiceUndoClickListener;
    }

    /**
     * This method will update all views, including service cards in this group
     */
    public void updateViews() {
        updateViews(null);
    }

    /**
     * This method will update service group views, and the service cards corresponding to the list
     * of {@link ServiceWrapper}s specified
     *
     * @param servicesToUpdate List of services who's views we want updated, or NULL if we want to
     *                         update all service views
     */
    public void updateViews(ArrayList<ServiceWrapper> servicesToUpdate) {
        this.state = State.IN_PAST;
        if (this.serviceTypes != null) {
            String dobString = Utils.getValue(childDetails.getColumnmaps(), "dob", false);
            DateTime dateTime = new DateTime(dobString);
            Date dob = dateTime.toDate();
            Calendar today = Calendar.getInstance();
            today.set(Calendar.HOUR, 0);
            today.set(Calendar.MINUTE, 0);
            today.set(Calendar.SECOND, 0);
            today.set(Calendar.MILLISECOND, 0);

            long timeDiff = today.getTimeInMillis() - dob.getTime();

            if (timeDiff < today.getTimeInMillis()) {
                this.state = State.IN_PAST;
            } else if (timeDiff > (today.getTimeInMillis() + TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS))) {
                this.state = State.IN_FUTURE;
            } else {
                this.state = State.CURRENT;
            }
            updateStatusViews();
            updateServiceCards(servicesToUpdate);
        }
    }

    private void updateStatusViews() {

        String recurringServices = getResources().getString(R.string.recurring_services);
        switch (this.state) {
            case IN_PAST:
                nameTV.setText(recurringServices);
                break;
            case CURRENT:
                nameTV.setText(String.format(context.getString(R.string.due_),
                        recurringServices, context.getString(R.string.today)));
                break;
            case IN_FUTURE:
                String dobString = Utils.getValue(childDetails.getColumnmaps(), "dob", false);
                Calendar dobCalender = Calendar.getInstance();
                DateTime dateTime = new DateTime(dobString);
                dobCalender.setTime(dateTime.toDate());

                //dobCalender.add(Calendar.DATE, serviceData.getInt("days_after_birth_due"));

                nameTV.setText(String.format(context.getString(R.string.due_),
                        recurringServices,
                        READABLE_DATE_FORMAT.format(dobCalender.getTime())));
                break;
        }

    }

    private void updateServiceCards(ArrayList<ServiceWrapper> servicesToUpdate) {
        if (serviceCardAdapter == null) {
            try {
                serviceCardAdapter = new ServiceCardAdapter(context, this);
                servicesGV.setAdapter(serviceCardAdapter);
            } catch (JSONException e) {
                Log.e(TAG, Log.getStackTraceString(e));
            }
        }

    }


    @Override
    public void onClick(View v) {
        if (v instanceof ServiceCard) {
            if (onServiceClickedListener != null) {
                onServiceClickedListener.onClick(this, ((ServiceCard) v).getServiceWrapper());
            }
        } else if (v.getId() == R.id.undo_b) {
            if (v.getParent().getParent() instanceof ServiceCard) {
                ServiceCard serviceCard = (ServiceCard) v.getParent().getParent();
                onUndoClick(serviceCard);
            }
        }
    }

    @Override
    public void onStateChanged(ServiceCard.State newState) {
        updateViews();
    }

    public void onUndoClick(ServiceCard serviceCard) {
        if (this.onServiceUndoClickListener != null) {
            this.onServiceUndoClickListener.onUndoClick(this, serviceCard.getServiceWrapper());
        }
    }

    public void setOnServiceClickedListener(OnServiceClickedListener onServiceClickedListener) {
        this.onServiceClickedListener = onServiceClickedListener;
    }

    public static interface OnServiceClickedListener {
        void onClick(ServiceGroup serviceGroup, ServiceWrapper serviceWrapper);
    }

    public static interface OnServiceUndoClickListener {
        void onUndoClick(ServiceGroup serviceGroup, ServiceWrapper serviceWrapper);
    }

    public ArrayList<ServiceWrapper> getDueServices() {
        if (serviceCardAdapter != null) {
            return serviceCardAdapter.getDueServices();
        }
        return new ArrayList<ServiceWrapper>();
    }

    public boolean isModalOpen() {
        return modalOpen;
    }

    public void setModalOpen(boolean modalOpen) {
        this.modalOpen = modalOpen;
    }

    public void updateWrapperStatus(ServiceWrapper tag) {
        List<ServiceRecord> serviceRecordList = getServiceRecordList();

        List<Alert> alertList = getAlertList();

        Map<String, Date> receivedServices = receivedServices(serviceRecordList);

        String dobString = Utils.getValue(getChildDetails().getColumnmaps(), "dob", false);
        List<Map<String, Object>> sch = generateScheduleList("child", new DateTime(dobString), receivedServices, alertList);

        for (Map<String, Object> m : sch) {
            VaccineRepo.Vaccine vaccine = (VaccineRepo.Vaccine) m.get("vaccine");
            if (tag.getName().toLowerCase().contains(vaccine.display().toLowerCase())) {
                tag.setStatus(m.get("status").toString());
                tag.setAlert((Alert) m.get("alert"));

            }
        }
    }

    public void updateWrapperStatus(ArrayList<ServiceWrapper> tags) {
        if (tags == null) {
            return;
        }

        for (ServiceWrapper tag : tags) {
            updateWrapperStatus(tag);
        }
    }

    public void updateWrapper(ServiceWrapper tag) {
        List<ServiceRecord> serviceRecordList = getServiceRecordList();

        if (!serviceRecordList.isEmpty()) {
            for (ServiceRecord serviceRecord : serviceRecordList) {
                if (tag.getName().toLowerCase().contains(serviceRecord.getName().toLowerCase()) && serviceRecord.getDate() != null) {
                    long diff = serviceRecord.getUpdatedAt() - serviceRecord.getDate().getTime();
                    if (diff > 0 && TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) > 1) {
                        tag.setUpdatedVaccineDate(new DateTime(serviceRecord.getDate()), false);
                    } else {
                        tag.setUpdatedVaccineDate(new DateTime(serviceRecord.getDate()), true);
                    }
                    tag.setDbKey(serviceRecord.getId());
                    tag.setSynced(serviceRecord.getSyncStatus() != null && serviceRecord.getSyncStatus().equals(VaccineRepository.TYPE_Synced));
                    if (tag.getName().contains("/")) {
                        String[] array = tag.getName().split("/");

                        if ((array[0]).toLowerCase().contains(serviceRecord.getName().toLowerCase())) {
                            tag.setName(array[0]);
                        } else if ((array[1]).toLowerCase().contains(serviceRecord.getName().toLowerCase())) {

                            tag.setName(array[1]);
                        }
                    }
                }
            }
        }

    }


}
