package com.surfcourse.nek.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import interfaces.OnCustomViewClickListener;

/**
 * Created by nek on 18.11.16.
 */

public class CounterView extends LinearLayout {
    private ImageButton plusBtn;
    private ImageButton minusBtn;
    private OnCustomViewClickListener clickListener;

    public int getValue() {
        return value;
    }

    private int value;
    private int minValue = 0;
    private int maxValue = 50;

    public CounterView(Context context) {
        this(context, null);
    }

    public CounterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.counter_layout, this);
        applyAttr(context, attrs);
        init();

    }

    private void applyAttr(Context context, AttributeSet attrs) {
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,R.styleable.CounterView,0,0);
        value = a.getInt(R.styleable.CounterView_initValue, 0);
        minValue = a.getInt(R.styleable.CounterView_minValue, -5);
        maxValue = a.getInt(R.styleable.CounterView_maxValue, 25);

    }


    private void init() {
        TextView textView = (TextView) findViewById(R.id.counter_text_view);
        textView.setText(String.valueOf(value));
        this.minusBtn = (ImageButton) findViewById(R.id.min_btn);
        this.plusBtn = (ImageButton) findViewById(R.id.add_btn);
        plusBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.counter_text_view);
                incrementValue();
                textView.setText(String.valueOf(value));
                if(clickListener != null) {
                    clickListener.onClick();
                }

            }
        });
        minusBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.counter_text_view);
                decrementValue();
                textView.setText(String.valueOf(value));
                if(clickListener != null) {
                    clickListener.onClick();
                }
            }
        });
    }

    private void decrementValue()  {
        if (value > minValue){
            value -= 1;
        }
    }

    private void incrementValue() {
        if (value < maxValue){
            value += 1;
        }
    }

    public void setOnClickListener(OnCustomViewClickListener clickListener) {
        this.clickListener = clickListener;
    }
}
