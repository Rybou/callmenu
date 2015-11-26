package com.example.bourymbodj.callmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by bourymbodj on 15-11-25.
 */
public class CustomBaseAdapter extends BaseAdapter {
    private static ArrayList<phoneContact> contactArrayList;

    private LayoutInflater mInflater;

    public CustomBaseAdapter(Context context, ArrayList <phoneContact> results) {
        contactArrayList = results;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return contactArrayList.size();
    }

    public Object getItem(int position) {
        return contactArrayList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.activity_list_item, null);
            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.text1);
            holder.txtPhone = (TextView) convertView.findViewById(R.id.text2);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtName.setText(contactArrayList.get(position).getName());
        holder.txtPhone.setText(contactArrayList.get(position).getPhone());

        return convertView;
    }

    static class ViewHolder {
        TextView txtName;
        TextView txtPhone;
    }
}
