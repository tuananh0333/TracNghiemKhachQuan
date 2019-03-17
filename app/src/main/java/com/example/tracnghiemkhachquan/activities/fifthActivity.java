package com.example.tracnghiemkhachquan.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.example.tracnghiemkhachquan.R;
import com.example.tracnghiemkhachquan.data_models.Questions;
import com.example.tracnghiemkhachquan.data_models.TrueFalseQuestion;

public class fifthActivity extends AppCompatActivity {

    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fifth_layout);

        intent = new Intent();

        TextView lblQuestion = (TextView) findViewById(R.id.lblQuestion);
        final Switch swAnswer1 = (Switch) findViewById(R.id.swAnswer1);
        final Switch swAnswer2 = (Switch) findViewById(R.id.swAnswer2);
        final Switch swAnswer3 = (Switch) findViewById(R.id.swAnswer3);
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
                intent.setClass(fifthActivity.this, fourthActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

                userProcessActivities(swAnswer1,swAnswer2,swAnswer3);
                startActivity(intent);
            }
        });

        btnKetThuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(fifthActivity.this, ResultActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

                userProcessActivities(swAnswer1,swAnswer2,swAnswer3);
                startActivity(intent);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(fifthActivity.this, firstActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

                userProcessActivities(swAnswer1,swAnswer2,swAnswer3);
                Log.d("test", Questions.questions.get(4).getPoint() + "");
                startActivity(intent);
            }
        });
    }

    private void userProcessActivities(Switch swA, Switch swB, Switch swC) {
        Questions.questions.get(4).getQuestionAnswer().clear();
        if (swA.isChecked()) {
            Questions.questions.get(4).setQuestionAnswer(1);
        } else {
            Questions.questions.get(4).setQuestionAnswer(0);
        }

        if (swB.isChecked()) {
            Questions.questions.get(4).setQuestionAnswer(1);
        } else {
            Questions.questions.get(4).setQuestionAnswer(0);
        }

        if (swC.isChecked()) {
            Questions.questions.get(4).setQuestionAnswer(1);
        } else {
            Questions.questions.get(4).setQuestionAnswer(0);
        }
    }
}
