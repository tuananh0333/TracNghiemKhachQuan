package com.example.tracnghiemkhachquan.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.tracnghiemkhachquan.R;
import com.example.tracnghiemkhachquan.data_models.Questions;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    ArrayList<String> listResult = new ArrayList<String>();
    ArrayAdapter<String> listAdapter;

    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_layout);

        intent = new Intent();

        ListView lstResult = (ListView) findViewById(R.id.lstResult);

        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnThoat = (Button) findViewById(R.id.btnThoat);
        Button btnNext = (Button) findViewById(R.id.btnNext);

//        Log.d("A1", Questions.questions.get(0).toString());
//        Log.d("A2", Questions.questions.get(1).toString());
//        Log.d("A3", Questions.questions.get(2).toString());
//        Log.d("A4", Questions.questions.get(3).toString());
//        Log.d("A5", Questions.questions.get(4).toString());

        this.listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, this.listResult);
        lstResult.setAdapter(this.listAdapter);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(ResultActivity.this, fifthActivity.class);

                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(ResultActivity.this, firstActivity.class);

                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        this.listResult.clear();
        int n = Questions.questions.size();
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            this.listResult.add("Câu " + (i+1) + ": " + Questions.questions.get(i).getPoint());
            sum+= Questions.questions.get(i).getPoint();
        }
        this.listResult.add("Tổng: " + sum + "/" + n);
        this.listAdapter.notifyDataSetChanged();
    }
}
