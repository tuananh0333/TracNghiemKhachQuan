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

public class firstActivity extends AppCompatActivity {

    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        setTitle(R.string.a1);

        intent = new Intent();

        TextView lblQuestion = (TextView) findViewById(R.id.lblQuestion);
        final CheckBox chkAnswer1 = (CheckBox) findViewById(R.id.chkAnswer1);
        final CheckBox chkAnswer2 = (CheckBox) findViewById(R.id.chkAnswer2);
        final CheckBox chkAnswer3 = (CheckBox) findViewById(R.id.chkAnswer3);
        final CheckBox chkAnswer4 = (CheckBox) findViewById(R.id.chkAnswer4);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnKetThuc = (Button) findViewById(R.id.btnKetThuc);
        Button btnNext = (Button) findViewById(R.id.btnNext);

        Questions.initialation();
        //Log.d("test",Questions.questions.size()+"");
        MultiQuestionMultiChoices question = (MultiQuestionMultiChoices) Questions.questions.get(0);
        lblQuestion.setText(question.getQuestionDescription());
        chkAnswer1.setText(question.getQuestionChoices().get(0));
        chkAnswer2.setText(question.getQuestionChoices().get(1));
        chkAnswer3.setText(question.getQuestionChoices().get(2));
        chkAnswer4.setText(question.getQuestionChoices().get(3));

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(firstActivity.this, fifthActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

                userProcessActivities(chkAnswer1,chkAnswer2,chkAnswer3,chkAnswer4);
                startActivity(intent);
            }
        });

        btnKetThuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(firstActivity.this, ResultActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

                userProcessActivities(chkAnswer1,chkAnswer2,chkAnswer3,chkAnswer4);
                startActivity(intent);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(firstActivity.this, secondActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

                userProcessActivities(chkAnswer1,chkAnswer2,chkAnswer3,chkAnswer4);
                Log.d("test", Questions.questions.get(0).getPoint() + "");
                startActivity(intent);
            }
        });
    }

    private void userProcessActivities(CheckBox chkA, CheckBox chkB, CheckBox chkC, CheckBox chkD) {
        Questions.questions.get(0).getQuestionAnswer().clear();
        if (chkA.isChecked()) {
            Questions.questions.get(0).setQuestionAnswer(0);
        }
        if (chkB.isChecked()) {
            Questions.questions.get(0).setQuestionAnswer(1);
        }
        if (chkC.isChecked()) {
            Questions.questions.get(0).setQuestionAnswer(2);
        }
        if (chkD.isChecked()) {
            Questions.questions.get(0).setQuestionAnswer(3);
        }
    }
}
