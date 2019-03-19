package com.example.tracnghiemkhachquan.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.tracnghiemkhachquan.R;
import com.example.tracnghiemkhachquan.data_models.MultiQuestionMultiChoices;
import com.example.tracnghiemkhachquan.data_models.Questions;
import com.example.tracnghiemkhachquan.flagments.AbstractQuestionFlagments;

public class firstActivity extends AppCompatActivity {
    private int questionID = 0;
    private AbstractQuestionFlagments fragment;

    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiquestion_multichoice_fragment);

        //setTitle(R.string.a1);

        intent = new Intent();


        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnKetThuc = (Button) findViewById(R.id.btnKetThuc);
        Button btnNext = (Button) findViewById(R.id.btnNext);

        Questions.initialation();

        updateUI();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.updateAnswer(questionID);
                if (questionID == 0) {
                    questionID = Questions.questions.size()-1;
                } else {
                    questionID++;
                }
                updateUI();
            }
        });

        btnKetThuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(firstActivity.this, ResultActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                fragment.updateAnswer();
                startActivity(intent);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.updateAnswer(questionID);
                if (questionID == Questions.questions.size()-1) {
                    questionID = 0;
                } else {
                    questionID--;
                }
                updateUI();
            }
        });
    }

    private void updateUI() {

    }
}
