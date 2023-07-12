//package com.example.mobileprogramming.adapter;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.mobileprogramming.R;
//import com.example.mobileprogramming.model.Device;
//
//import java.util.List;
//
//public class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.DeviceViewHolder> {
//    private List<Device> deviceList;
//
//    public void setDeviceList(List<Device> deviceList) {
//        this.deviceList = deviceList;
//    }
//
//    public class DeviceViewHolder extends RecyclerView.ViewHolder {
//
//        public DeviceViewHolder(@NonNull View itemView) {
//            super(itemView);
//        }
//    }
//    @NonNull
//    @Override
//    public DeviceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.device_light_item, parent, false);
//        return new DeviceViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull DeviceViewHolder holder, int position) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        if (deviceList == null) {
//            return 0;
//        }
//        return deviceList.size();
//    }
//}
