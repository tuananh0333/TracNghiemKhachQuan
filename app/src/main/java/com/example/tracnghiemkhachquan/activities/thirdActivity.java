package com.example.tracnghiemkhachquan.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tracnghiemkhachquan.R;
import com.example.tracnghiemkhachquan.data_models.MatchingQuestion;
import com.example.tracnghiemkhachquan.data_models.Questions;

public class thirdActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);

        intent = new Intent();

        TextView lblQuestion = (TextView) findViewById(R.id.lblQuestion);
        final Spinner spnAnswer1 = (Spinner) findViewById(R.id.spnAnswer1);
        final Spinner spnAnswer2 = (Spinner) findViewById(R.id.spnAnswer2);
        final Spinner spnAnswer3 = (Spinner) findViewById(R.id.spnAnswer3);
        TextView lblAnswer1 = (TextView) findViewById(R.id.lblAnswer1);
        TextView lblAnswer2 = (TextView) findViewById(R.id.lblAnswer2);
        TextView lblAnswer3 = (TextView) findViewById(R.id.lblAnswer3);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnKetThuc = (Button) findViewById(R.id.btnKetThuc);
        Button btnNext = (Button) findViewById(R.id.btnNext);

        MatchingQuestion question = (MatchingQuestion) Questions.questions.get(2);
        lblQuestion.setText(question.getQuestionDescription());
        lblAnswer1.setText(question.getQuestionChoicesA().get(0));
        lblAnswer2.setText(question.getQuestionChoicesA().get(1));
        lblAnswer3.setText(question.getQuestionChoicesA().get(2));

        ArrayAdapter<String> spinnetAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, question.getQuestionChoicesB());
        spnAnswer1.setAdapter(spinnetAdapter);
        spnAnswer2.setAdapter(spinnetAdapter);
        spnAnswer3.setAdapter(spinnetAdapter);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(thirdActivity.this, secondActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

                userProcessActivities(spnAnswer1,spnAnswer2,spnAnswer3);
                startActivity(intent);
            }
        });

        btnKetThuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(thirdActivity.this, ResultActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

                userProcessActivities(spnAnswer1,spnAnswer2,spnAnswer3);
                startActivity(intent);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(thirdActivity.this, fourthActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

                userProcessActivities(spnAnswer1,spnAnswer2,spnAnswer3);
                Log.d("test", Questions.questions.get(2).getPoint() + "");
                startActivity(intent);
            }
        });
    }

    private void userProcessActivities(Spinner spnA, Spinner spnB, Spinner spnC) {
        Questions.questions.get(2).getQuestionAnswer().clear();

        Questions.questions.get(2).setQuestionAnswer(spnA.getSelectedItemPosition());
        Questions.questions.get(2).setQuestionAnswer(spnB.getSelectedItemPosition());
        Questions.questions.get(2).setQuestionAnswer(spnC.getSelectedItemPosition());
    }
}
