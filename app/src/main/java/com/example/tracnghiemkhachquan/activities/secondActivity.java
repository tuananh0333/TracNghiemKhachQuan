package com.example.tracnghiemkhachquan.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.tracnghiemkhachquan.MyRadioButtonGroup;
import com.example.tracnghiemkhachquan.R;
import com.example.tracnghiemkhachquan.data_models.MultiQuestionOneChoice;
import com.example.tracnghiemkhachquan.data_models.Questions;

public class secondActivity extends AppCompatActivity {

    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        intent = new Intent();

        TextView lblQuestion = (TextView) findViewById(R.id.lblQuestion);
        final RadioButton rboAnswer1 = (RadioButton) findViewById(R.id.rboAnswer1);
        final RadioButton rboAnswer2 = (RadioButton) findViewById(R.id.rboAnswer2);
        final RadioButton rboAnswer3 = (RadioButton) findViewById(R.id.rboAnswer3);
        final RadioButton rboAnswer4 = (RadioButton) findViewById(R.id.rboAnswer4);
        MyRadioButtonGroup radioButtonGroup = new MyRadioButtonGroup(rboAnswer1,rboAnswer2,rboAnswer3,rboAnswer4);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnKetThuc = (Button) findViewById(R.id.btnKetThuc);
        Button btnNext = (Button) findViewById(R.id.btnNext);

        MultiQuestionOneChoice question = (MultiQuestionOneChoice) Questions.questions.get(1);
        lblQuestion.setText(question.getQuestionDescription());
        rboAnswer1.setText(question.getQuestionChoices().get(0));
        rboAnswer2.setText(question.getQuestionChoices().get(1));
        rboAnswer3.setText(question.getQuestionChoices().get(2));
        rboAnswer4.setText(question.getQuestionChoices().get(3));

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(secondActivity.this, firstActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

                userProcessActivities(rboAnswer1,rboAnswer2,rboAnswer3,rboAnswer4);
                startActivity(intent);
            }
        });

        btnKetThuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(secondActivity.this, ResultActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

                userProcessActivities(rboAnswer1,rboAnswer2,rboAnswer3,rboAnswer4);
                startActivity(intent);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(secondActivity.this, thirdActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

                userProcessActivities(rboAnswer1,rboAnswer2,rboAnswer3,rboAnswer4);
                Log.d("test", Questions.questions.get(1).getPoint() + "");
                startActivity(intent);
            }
        });
    }

    private void userProcessActivities(RadioButton rboA, RadioButton rboB, RadioButton rboC, RadioButton rboD) {
        Questions.questions.get(1).getQuestionAnswer().clear();
        if (rboA.isChecked()) {
            Questions.questions.get(1).setQuestionAnswer(0);
        }
        if (rboB.isChecked()) {
            Questions.questions.get(1).setQuestionAnswer(1);
        }
        if (rboC.isChecked()) {
            Questions.questions.get(1).setQuestionAnswer(2);
        }
        if (rboD.isChecked()) {
            Questions.questions.get(1).setQuestionAnswer(3);
        }
    }
}
