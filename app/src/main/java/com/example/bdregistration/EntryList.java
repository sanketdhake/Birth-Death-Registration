package com.example.bdregistration;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class EntryList extends ArrayAdapter {
    private Activity context;
    private List<userlogin> entrylist;

    public EntryList(Activity context1, List<userlogin> entrylist) {
        super(context1, R.layout.listlayout, entrylist);
        this.context = context1;
        this.entrylist = entrylist;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater in=context.getLayoutInflater();

        View listItemVIEW=in.inflate(R.layout.listlayout,null,true);

        TextView t1=listItemVIEW.findViewById(R.id.textView2);
        userlogin e1=entrylist.get(position);
        t1.setText(e1.getuUsername());
        return listItemVIEW;
    }
}

