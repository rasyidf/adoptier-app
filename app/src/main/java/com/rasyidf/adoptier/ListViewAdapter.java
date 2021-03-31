package com.rasyidf.adoptier;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter
{
    Context mCtx;
    LayoutInflater inflater;
    private KontakItem[] contacts;

    public ListViewAdapter(Context context, KontakItem[] contacts){
        this.mCtx = context;
        this.inflater = (LayoutInflater.from(mCtx));
        this.contacts =contacts;
    }

    @Override
    public int getCount() {
        return contacts.length;
    }

    @Override
    public Object getItem(int position) {
        return this.contacts[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        final ViewHolder holder;

        if (view == null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.lvkontak_item, null, false);
            holder.name = (TextView) view.findViewById(R.id.textView);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.name.setText(this.contacts[position].getNama());
        return view;
    }
}

