package com.example.bdregistration;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SlideAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SlideAdapter(Context context){

        this.context=context;
    }
    public int[] slide_images={
            R.drawable.birth,
            R.drawable.death
    };

    public String[] slide_heading={
            "BIRTH","DEATH"
    };

    public String[] slide_desc={
            "       ... It's a small paper but it actually establishes who you'r and gives an access to the rights and the privileges, and the ob;igations of citizenship.","       ... Document issued by a medical practitioner certifying the deceased state of a person or, popularly, to a document issued by a person such as a register of vital statistics that declares the date, location and cause of a person's death. "
    };


    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(RelativeLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImg=(ImageView)view.findViewById(R.id.img);
        TextView slideHead=(TextView)view.findViewById(R.id.tvh);
        TextView slideDesc=(TextView)view.findViewById(R.id.tvd);

        slideImg.setImageResource(slide_images[position]);
        slideHead.setText(slide_heading[position]);
        slideDesc.setText(slide_desc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
