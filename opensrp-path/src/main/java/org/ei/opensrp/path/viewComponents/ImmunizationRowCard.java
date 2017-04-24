package org.ei.opensrp.path.viewComponents;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.ei.opensrp.domain.Alert;
import org.ei.opensrp.path.R;
import org.ei.opensrp.path.domain.VaccineWrapper;
import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by raihan on 13/03/2017.
 */

public class ImmunizationRowCard extends LinearLayout {
    private static final String TAG = "VaccineCard";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
    private Context context;
    private Button statusIV;
    private TextView nameTV;
    private TextView StatusTV;
    private Button undoB;
    private State state;
    private OnVaccineStateChangeListener onVaccineStateChangeListener;
    private VaccineWrapper vaccineWrapper;
    public boolean editmode;
    public ImmunizationRowCard(Context context, boolean editmode) {
        super(context);
        this.editmode = editmode;
        init(context);
    }

    public static enum State {
        DONE_CAN_BE_UNDONE,
        DONE_CAN_NOT_BE_UNDONE,
        DUE,
        NOT_DUE,
        OVERDUE,
        EXPIRED
    }

    public ImmunizationRowCard(Context context) {
        super(context);
        init(context);
    }

    public ImmunizationRowCard(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ImmunizationRowCard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ImmunizationRowCard(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.view_immunization_row_card, this, true);
        statusIV = (Button) findViewById(R.id.status_iv);
        StatusTV = (TextView) findViewById(R.id.status_text_tv);
        nameTV = (TextView) findViewById(R.id.name_tv);
        undoB = (Button) findViewById(R.id.undo_b);
     }

    public void setVaccineWrapper(VaccineWrapper vaccineWrapper) {
        this.vaccineWrapper = vaccineWrapper;
        updateState();
    }

    public VaccineWrapper getVaccineWrapper() {
        return this.vaccineWrapper;
    }

    public void updateState() {
        this.state = State.NOT_DUE;
        if (vaccineWrapper != null) {
            Date dateDone = getDateDone();
            boolean isSynced = isSynced();
            String status = getStatus();

            if (dateDone != null) {// Vaccination was done
                if (isSynced) {
                    this.state = State.DONE_CAN_NOT_BE_UNDONE;
                } else {
                    this.state = State.DONE_CAN_BE_UNDONE;
                }
            } else {// Vaccination has not been done
                if (status != null) {
                    if (status.equalsIgnoreCase("due")) {
                        Alert alert = getAlert();
                        if (alert == null) {
                            //state = State.NO_ALERT;
                        } else if (alert.status().value().equalsIgnoreCase("normal")) {
                            state = State.DUE;
                        } else if (alert.status().value().equalsIgnoreCase("upcoming")) {
                            //state = State.UPCOMING;
                        } else if (alert.status().value().equalsIgnoreCase("urgent")) {
                            state = State.OVERDUE;
                        } else if (alert.status().value().equalsIgnoreCase("expired")) {
                            state = State.EXPIRED;
                        }
                    } else if (vaccineWrapper.getStatus().equalsIgnoreCase("expired")) {
                        state = State.EXPIRED;
                    }
                }

//                Calendar today = Calendar.getInstance();
//                today.set(Calendar.HOUR_OF_DAY, 0);
//                today.set(Calendar.MINUTE, 0);
//                today.set(Calendar.SECOND, 0);
//                today.set(Calendar.MILLISECOND, 0);
//                if (getDateDue().getTime() > (today.getTimeInMillis() + TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS))) {
//                    // Vaccination due more than one day from today
//                    this.state = State.NOT_DUE;
//                } else if (getDateDue().getTime() < (today.getTimeInMillis() - TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS))) {
//                    // Vaccination overdue
//                    this.state = State.OVERDUE;
//                } else {
//                    this.state = State.DUE;
//                }
            }
        }

        updateStateUi();
    }

    public void setOnVaccineStateChangeListener(OnVaccineStateChangeListener onVaccineStateChangeListener) {
        this.onVaccineStateChangeListener = onVaccineStateChangeListener;
    }

    public State getState() {
        updateState();
        return this.state;
    }

    private void updateStateUi() {
        switch (state) {
            case NOT_DUE:
                setBackgroundDrawable(getResources().getDrawable(R.drawable.vaccine_card_background_white));
//                statusIV.setBackgroundColor(getResources().getColor(R.color.dark_grey));
                statusIV.setBackgroundDrawable(getResources().getDrawable(R.drawable.vaccine_card_background_white));

//                if(editmode) {
//                    undoB.setVisibility(VISIBLE);
//                }else{
                undoB.setVisibility(INVISIBLE);
//                }
                nameTV.setVisibility(VISIBLE);
                nameTV.setTextColor(context.getResources().getColor(R.color.silver));
                nameTV.setText(getVaccineName());
                StatusTV.setText(DATE_FORMAT.format(getDateDue()));
                setClickable(false);
                break;
            case DUE:
                setBackgroundDrawable(getResources().getDrawable(R.drawable.vaccine_card_background_white));
//                statusIV.setBackgroundColor(getResources().getColor(R.color.alert_in_progress_blue));
                statusIV.setBackgroundDrawable(getResources().getDrawable(R.drawable.vaccine_card_background_blue));

//                if(editmode) {
//                    undoB.setVisibility(VISIBLE);
//                }else{
                    undoB.setVisibility(INVISIBLE);
//                }
                nameTV.setVisibility(VISIBLE);
//                nameTV.setTextColor(context.getResources().getColor(R.color.silver));
                nameTV.setText( getVaccineName());
                StatusTV.setText(DATE_FORMAT.format(getDateDue()));
                setClickable(false);
                break;
            case DONE_CAN_BE_UNDONE:
                setBackgroundDrawable(getResources().getDrawable(R.drawable.vaccine_card_background_white));
                statusIV.setBackgroundDrawable(getResources().getDrawable(R.drawable.vaccine_card_background_green));
//                statusIV.setBackgroundDrawable(getResources().getDrawable(R.drawable.vaccine_card_background_white));
                if(editmode) {
                    undoB.setVisibility(VISIBLE);
                }else{
                    undoB.setVisibility(INVISIBLE);
                }
                nameTV.setVisibility(VISIBLE);
//                nameTV.setTextColor(context.getResources().getColor(R.color.silver));
                nameTV.setText(getVaccineName());
                StatusTV.setText(DATE_FORMAT.format(getDateDone()));
                setClickable(false);
                break;
            case DONE_CAN_NOT_BE_UNDONE:
                setBackgroundDrawable(getResources().getDrawable(R.drawable.vaccine_card_background_white));
                statusIV.setBackgroundDrawable(getResources().getDrawable(R.drawable.vaccine_card_background_green));
//                statusIV.setBackgroundDrawable(getResources().getDrawable(R.drawable.vaccine_card_background_white));
                if(editmode) {
                    undoB.setVisibility(VISIBLE);
                }else{
                    undoB.setVisibility(INVISIBLE);
                }
                nameTV.setVisibility(VISIBLE);
//                nameTV.setTextColor(context.getResources().getColor(R.color.silver));
                nameTV.setText(getVaccineName());
                StatusTV.setText(DATE_FORMAT.format(getDateDone()));
                setClickable(false);
                break;
            case OVERDUE:
                setBackgroundDrawable(getResources().getDrawable(R.drawable.vaccine_card_background_white));
                statusIV.setBackgroundDrawable(getResources().getDrawable(R.drawable.vaccine_card_background_red));

//                statusIV.setBackgroundColor(getResources().getColor(R.color.due_vaccine_red));
//                if(editmode) {
//                    undoB.setVisibility(VISIBLE);
//                }else{
                    undoB.setVisibility(INVISIBLE);
//                }
                nameTV.setVisibility(VISIBLE);
//                nameTV.setTextColor(context.getResources().getColor(R.color.silver));
                nameTV.setText(getVaccineName());
                StatusTV.setText(DATE_FORMAT.format(getDateDue()));
                setClickable(false);
                break;
            case EXPIRED:
                setBackgroundDrawable(getResources().getDrawable(R.drawable.vaccine_card_background_white));
                statusIV.setBackgroundDrawable(getResources().getDrawable(R.drawable.vaccine_card_background_white));
//                statusIV.setVisibility(GONE);
                undoB.setVisibility(INVISIBLE);
                nameTV.setText(getVaccineName());
                StatusTV.setText(DATE_FORMAT.format(getDateDue()));
                setClickable(false);
                break;
        }
    }

    private String getVaccineName() {
        if (vaccineWrapper != null) {
            return vaccineWrapper.getName();
        }
        return null;
    }

    private Date getDateDue() {
        if (vaccineWrapper != null) {
            DateTime vaccineDate = vaccineWrapper.getVaccineDate();
            if (vaccineDate != null) return vaccineDate.toDate();
        }
        return null;
    }

    private Date getDateDone() {
        if (vaccineWrapper != null) {
            DateTime dateDone = vaccineWrapper.getUpdatedVaccineDate();
            if (dateDone != null) return dateDone.toDate();
        }

        return null;
    }
    private boolean isSynced() {
        if (vaccineWrapper != null) {
            return vaccineWrapper.isSynced();
        }
        return false;
    }

    private Alert getAlert() {
        if (vaccineWrapper != null) {
            return vaccineWrapper.getAlert();
        }
        return null;
    }

    private String getStatus() {
        if (vaccineWrapper != null) {
            return vaccineWrapper.getStatus();
        }
        return null;
    }

    public static interface OnVaccineStateChangeListener {
        void onStateChanged(final State newState);
    }

    public Button getUndoB() {
        return undoB;
    }
}