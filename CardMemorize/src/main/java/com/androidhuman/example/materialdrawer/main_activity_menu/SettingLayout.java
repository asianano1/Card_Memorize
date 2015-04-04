package com.androidhuman.example.materialdrawer.main_activity_menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.androidhuman.example.materialdrawer.R;

/**
 * Created by starnamu on 2015-03-29.
 */
public class SettingLayout extends LinearLayout {

    Context mContext;
    AttributeSet mAttrs;
    Spinner setting_spinner;
    ArrayAdapter<String> setting_spinnerAdapter;

    public SettingLayout(Context context) {
        super(context);
        mContext = context;
        init(context);
    }

    public SettingLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mAttrs = attrs;
        init(context);

    }

    public void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.setting_layout, this, true);
        setting_spinner = (Spinner) view.findViewById(R.id.setting_spinner);

//        String[] choiceNumber = new String[]{"1", "2", "3", "4", "5","6", "7", "8", "9", "10",
//                                                                 "11", "12", "13", "14", "15","16", "17", "18", "19", "20",
//                                                                 "21", "22", "23", "24", "25","26", "27", "28", "29", "30"};
        String[] choiceNumber = new String[30];
        for (int i = 0; i < choiceNumber.length; i++) {
            choiceNumber[i] = Integer.toString(i + 1);
        }
        setting_spinnerAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_dropdown_item, choiceNumber);
        setting_spinner.setAdapter(setting_spinnerAdapter);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }
}