package com.mh.obdtest.obdtest;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;

public class MyPopupWindow extends PopupWindow{
    private View mainview;
    public MyPopupWindow(Activity context,OnClickListener itemclick){
        super(context);
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        mainview=inflater.inflate(R.layout.activity_main3, null);

        this.setWidth(LayoutParams.MATCH_PARENT);
        this.setHeight(LayoutParams.MATCH_PARENT);
        this.setContentView(mainview);
        this.setFocusable(true);
        this.setAnimationStyle(R.style.dialog_style);
    }
}