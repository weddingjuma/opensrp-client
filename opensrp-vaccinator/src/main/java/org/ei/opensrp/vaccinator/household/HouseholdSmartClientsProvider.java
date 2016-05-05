package org.ei.opensrp.vaccinator.household;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;

import org.ei.opensrp.commonregistry.CommonPersonObjectClient;
import org.ei.opensrp.commonregistry.CommonPersonObjectController;
import org.ei.opensrp.provider.SmartRegisterClientsProvider;
import org.ei.opensrp.service.AlertService;
import org.ei.opensrp.vaccinator.R;
import org.ei.opensrp.view.contract.SmartRegisterClient;
import org.ei.opensrp.view.contract.SmartRegisterClients;
import org.ei.opensrp.view.dialog.FilterOption;
import org.ei.opensrp.view.dialog.ServiceModeOption;
import org.ei.opensrp.view.dialog.SortOption;
import org.ei.opensrp.view.viewHolder.OnClickFormLauncher;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static util.Utils.fillValue;
import static util.Utils.getValue;
import static util.Utils.setProfiePic;

/**
 * Created by Safwan on 4/22/2016.
 */
public class HouseholdSmartClientsProvider implements SmartRegisterClientsProvider {

    private final LayoutInflater inflater;
    private final Context context;
    private final View.OnClickListener onClickListener;
    AlertService alertService;
    private final int txtColorBlack;
    private final AbsListView.LayoutParams clientViewLayoutParams;

    protected CommonPersonObjectController controller;

    public HouseholdSmartClientsProvider(Context context, View.OnClickListener onClickListener,
                                     CommonPersonObjectController controller, AlertService alertService) {
        this.onClickListener = onClickListener;
        this.controller = controller;
        this.context = context;
        this.alertService = alertService;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        clientViewLayoutParams = new AbsListView.LayoutParams(MATCH_PARENT, (int) context.getResources().getDimension(org.ei.opensrp.R.dimen.list_item_height));
        txtColorBlack = context.getResources().getColor(org.ei.opensrp.R.color.text_black);
    }


    @Override
    public View getView(SmartRegisterClient client, View parentView, ViewGroup viewGroup) {
        CommonPersonObjectClient pc = (CommonPersonObjectClient) client;

        parentView = (ViewGroup) inflater().inflate(R.layout.smart_register_household_client, null);
        fillValue((TextView)parentView.findViewById(R.id.household_id), pc, "existing_household_id", false);
        fillValue((TextView) parentView.findViewById(R.id.household_name), getValue(pc, "first_name_hhh", true) + " " + getValue(pc, "last_name_hhh", true));
        fillValue((TextView) parentView.findViewById(R.id.household_member_count), getValue(pc, "num_fam_member", true));
        fillValue((TextView) parentView.findViewById(R.id.household_address), getValue(pc, "address1", true) + ", " + getValue(pc, "union_council", true) + ", " +
                                                                                getValue(pc, "town", true) + ",\n " + getValue(pc, "city_village", true) + ", " +
                                                                                getValue(pc, "province", true) + ", ");

        setProfiePic(parentView.getContext(), (ImageView) parentView.findViewById(R.id.household_profilepic), client.entityId(), false);

        parentView.findViewById(R.id.household_profile_info_layout).setTag(client);
        parentView.findViewById(R.id.household_profile_info_layout).setOnClickListener(onClickListener);

        parentView.setLayoutParams(clientViewLayoutParams);

        return parentView;
    }

    @Override
    public SmartRegisterClients getClients() {
        return controller.getClients();
    }

    @Override
    public SmartRegisterClients updateClients(FilterOption villageFilter, ServiceModeOption serviceModeOption, FilterOption searchFilter, SortOption sortOption) {
        return getClients().applyFilter(villageFilter, serviceModeOption, searchFilter, sortOption);
    }

    @Override
    public void onServiceModeSelected(ServiceModeOption serviceModeOption) {

    }

    @Override
    public OnClickFormLauncher newFormLauncher(String formName, String entityId, String metaData) {
        return null;
    }

    public LayoutInflater inflater() {
        return inflater;
    }
}