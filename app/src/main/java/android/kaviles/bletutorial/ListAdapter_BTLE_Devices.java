package android.kaviles.bletutorial;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.aneeq.mybleapp.R;

import java.util.ArrayList;

/**
 * Created by Kelvin on 5/7/16.
 */
public class ListAdapter_BTLE_Devices extends ArrayAdapter<BTLE_Device> {

    Activity activity;
    int layoutResourceID;
    ArrayList<BTLE_Device> devices;

    public ListAdapter_BTLE_Devices(Activity activity, int resource, ArrayList<BTLE_Device> objects) {
        super(activity.getApplicationContext(), resource, objects);

        this.activity = activity;
        layoutResourceID = resource;
        devices = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater =
                    (LayoutInflater) activity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layoutResourceID, parent, false);
        }

        BTLE_Device device = devices.get(position);
        String name = device.getName(getContext());
        String address = device.getAddress();
        int rssi = device.getRSSI();

        TextView tv = null;

        tv = (TextView) convertView.findViewById(R.id.tv_name);
        if (name != null && !name.isEmpty()) {
            tv.setText(device.getName(getContext()));
        } else {
            tv.setText("No Name");
        }

        tv = (TextView) convertView.findViewById(R.id.tv_rssi);
        tv.setText("RSSI: " + rssi);

        tv = (TextView) convertView.findViewById(R.id.tv_macaddr);
        if (address != null && !address.isEmpty()) {
            tv.setText(device.getAddress());
        } else {
            tv.setText("No Address");
        }

        return convertView;
    }
}
