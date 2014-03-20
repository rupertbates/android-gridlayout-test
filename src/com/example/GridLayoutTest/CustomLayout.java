package com.example.GridLayoutTest;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class CustomLayout extends LinearLayout {
    public CustomLayout(Context context) {
        super(context);
        setOrientation(VERTICAL);
        LayoutInflater.from(context).inflate(R.layout.custom_layout, this);
    }
}
