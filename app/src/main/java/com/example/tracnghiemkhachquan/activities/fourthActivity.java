package com.example.tracnghiemkhachquan.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.tracnghiemkhachquan.R;
import com.example.tracnghiemkhachquan.data_models.Questions;
import com.example.tracnghiemkhachquan.data_models.TrueFalseQuestion;

public class fourthActivity extends AppCompatActivity {

    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_layout);

        intent = new Intent();

        TextView lblQuestion = (TextView) findViewById(R.id.lblQuestion);
        final ToggleButton tgBAnswer1 = (ToggleButton) findViewById(R.id.tgbAnswer1);
        final ToggleButton tgBAnswer2 = (ToggleButton) findViewById(R.id.tgbAnswer2);
        final ToggleButton tgBAnswer3 = (ToggleButton) findViewById(R.id.tgbAnswer3);
        TextView lblAnswer1 = (TextView) findViewById(R.id.lblAnswer1);
        TextView lblAnswer2 = (TextView) findViewById(R.id.lblAnswer2);
        TextView lblAnswer3 = (TextView) findViewById(R.id.lblAnswer3);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnKetThuc = (Button) findViewById(R.id.btnKetThuc);
        Button btnNext = (Button) findViewById(R.id.btnNext);

        TrueFalseQuestion question = (TrueFalseQuestion) Questions.questions.get(3);
        lblQuestion.setText(question.getQuestionDescription());
        lblAnswer1.setText(question.getQuestionChoices().get(0));
        lblAnswer2.setText(question.getQuestionChoices().get(1));
        lblAnswer3.setText(question.getQuestionChoices().get(2));

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(fourthActivity.this, thirdActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

                userProcessActivities(tgBAnswer1,tgBAnswer2,tgBAnswer3);
                startActivity(intent);
            }
        });

        btnKetThuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(fourthActivity.this, ResultActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

                userProcessActivities(tgBAnswer1,tgBAnswer2,tgBAnswer3);
                startActivity(intent);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(fourthActivity.this, fifthActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

                userProcessActivities(tgBAnswer1,tgBAnswer2,tgBAnswer3);
                Log.d("test", Questions.questions.get(3).getPoint() + "");
                startActivity(intent);
            }
        });
    }

    private void userProcessActivities(ToggleButton tglA, ToggleButton tglB, ToggleButton tglC) {
        Questions.questions.get(3).getQuestionAnswer().clear();
        if (tglA.isChecked()) {
            Questions.questions.get(3).setQuestionAnswer(1);
        } else {
            Questions.questions.get(3).setQuestionAnswer(0);
        }

        if (tglB.isChecked()) {
            Questions.questions.get(3).setQuestionAnswer(1);
        } else {
            Questions.questions.get(3).setQuestionAnswer(0);
        }

        if (tglC.isChecked()) {
            Questions.questions.get(3).setQuestionAnswer(1);
        } else {
            Questions.questions.get(3).setQuestionAnswer(0);
        }
    }
}
