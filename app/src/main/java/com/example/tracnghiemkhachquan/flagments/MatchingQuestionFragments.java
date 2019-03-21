package com.example.tracnghiemkhachquan.flagments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tracnghiemkhachquan.R;
import com.example.tracnghiemkhachquan.data_models.AbstractQuestion;
import com.example.tracnghiemkhachquan.data_models.MatchingQuestion;
import com.example.tracnghiemkhachquan.data_models.Questions;

public class MachingQuestionFragments extends AbstractQuestionFragments {
    private Spinner spnAnswer1,spnAnswer2,spnAnswer3;
    MatchingQuestion question;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.machingquestion_fragment, container, false);

        TextView lblQuestion = view.findViewById(R.id.lblQuestion);
        spnAnswer1 = view.findViewById(R.id.spnAnswer1);
        spnAnswer2 = view.findViewById(R.id.spnAnswer2);
        spnAnswer3 = view.findViewById(R.id.spnAnswer3);
        TextView lblAnswer1 = view.findViewById(R.id.lblAnswer1);
        TextView lblAnswer2 = view.findViewById(R.id.lblAnswer2);
        TextView lblAnswer3 = view.findViewById(R.id.lblAnswer3);

        lblQuestion.setText(question.getQuestionDescription());
        lblAnswer1.setText(question.getQuestionChoicesA().get(0));
        lblAnswer2.setText(question.getQuestionChoicesA().get(1));
        lblAnswer3.setText(question.getQuestionChoicesA().get(2));

        ArrayAdapter<String> spinnetAdapter = new ArrayAdapter<>(inflater.getContext(), android.R.layout.simple_spinner_dropdown_item, question.getQuestionChoicesB());
        spnAnswer1.setAdapter(spinnetAdapter);
        spnAnswer2.setAdapter(spinnetAdapter);
        spnAnswer3.setAdapter(spinnetAdapter);

        return view;
    }

    @Override
    public void setQuestion(AbstractQuestion question) {
        this.question = (MatchingQuestion) question;
    }

    @Override
    public void updateAnswer(int questionID) {
        Questions.questions.get(questionID).getQuestionAnswer().clear();

        Questions.questions.get(questionID).setQuestionAnswer(spnAnswer1.getSelectedItemPosition());
        Questions.questions.get(questionID).setQuestionAnswer(spnAnswer2.getSelectedItemPosition());
        Questions.questions.get(questionID).setQuestionAnswer(spnAnswer3.getSelectedItemPosition());
    }
}
