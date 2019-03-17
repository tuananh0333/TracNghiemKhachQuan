package com.example.tracnghiemkhachquan;

import android.view.View;
import android.widget.RadioButton;

import java.util.ArrayList;

public class MyRadioButtonGroup {
    private ArrayList<RadioButton> radioButtons;

    private View.OnClickListener onClickListenerRadioButtons = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            for (RadioButton rad : radioButtons) {
                if (rad.getId() == v.getId()) {
                    rad.setChecked(true);
                }
                else {
                    rad.setChecked(false);
                }
            }
        }
    };

    public MyRadioButtonGroup (RadioButton... radioButtons)
    {
        this.radioButtons = new ArrayList<RadioButton>();
        for (RadioButton rad : radioButtons)
        {
            rad.setOnClickListener(onClickListenerRadioButtons);
            this.radioButtons.add(rad);
        }
    }
}
