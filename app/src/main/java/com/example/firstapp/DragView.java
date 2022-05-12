package com.example.firstapp;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class DragView extends RelativeLayout implements View.OnTouchListener {



    public DragView(Context context) {
        super(context);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
