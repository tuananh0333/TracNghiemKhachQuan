package com.example.tracnghiemkhachquan.flagments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.example.tracnghiemkhachquan.R;
import com.example.tracnghiemkhachquan.data_models.AbstractQuestion;
import com.example.tracnghiemkhachquan.data_models.Questions;
import com.example.tracnghiemkhachquan.data_models.TrueFalseQuestion;

public class TrueFalseQuestin_swichFragment extends AbstractQuestionFragments {
    private Switch swAnswer1,swAnswer2,swAnswer3;
    private TrueFalseQuestion question;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = null;
        view = inflater.inflate(R.layout.truefalsequestion_swich_fragment, container, false);

        TextView lblQuestion = view.findViewById(R.id.lblQuestion);
        swAnswer1 = view.findViewById(R.id.swAnswer1);
        swAnswer2 = view.findViewById(R.id.swAnswer2);
        swAnswer3 = view.findViewById(R.id.swAnswer3);
        TextView lblAnswer1 = view.findViewById(R.id.lblAnswer1);
        TextView lblAnswer2 = view.findViewById(R.id.lblAnswer2);
        TextView lblAnswer3 = view.findViewById(R.id.lblAnswer3);

        lblQuestion.setText(question.getQuestionDescription());
        lblAnswer1.setText(question.getQuestionChoices().get(0));
        lblAnswer2.setText(question.getQuestionChoices().get(1));
        lblAnswer3.setText(question.getQuestionChoices().get(2));

        return view;
    }

    @Override
    public void setQuestion(AbstractQuestion question) {
        this.question = (TrueFalseQuestion) question;
    }

    @Override
    public void updateAnswer(int questionID) {
        Questions.questions.get(questionID).getQuestionAnswer().clear();
        if (swAnswer1.isChecked()) {
            Questions.questions.get(questionID).setQuestionAnswer(1);
        } else {
            Questions.questions.get(questionID).setQuestionAnswer(0);
        }

        if (swAnswer2.isChecked()) {
            Questions.questions.get(questionID).setQuestionAnswer(1);
        } else {
            Questions.questions.get(questionID).setQuestionAnswer(0);
        }

        if (swAnswer3.isChecked()) {
            Questions.questions.get(questionID).setQuestionAnswer(1);
        } else {
            Questions.questions.get(questionID).setQuestionAnswer(0);
        }
    }
}
