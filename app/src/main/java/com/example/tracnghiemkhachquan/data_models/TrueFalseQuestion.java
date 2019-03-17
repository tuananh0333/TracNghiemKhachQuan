package com.example.tracnghiemkhachquan.data_models;

import java.util.ArrayList;

public class TrueFalseQuestion extends AbstractQuestion {

    private ArrayList<String> questionChoices;

    public TrueFalseQuestion() {
        this.questionChoices = new ArrayList<String>();
        this.questionAnswer =  new ArrayList<Integer>();
        this.questionCorrect = new ArrayList<Integer>();
    }

    public ArrayList<String> getQuestionChoices() {
        return questionChoices;
    }

    public void setQuestionChoices(String... questionChoices) {
        for (String a : questionChoices) {
            this.questionChoices.add(a);
        }
    }

    @Override
    public int getPoint() {
        int point = 0;
        int n = this.questionCorrect.size();
        int i = 0;

        if (this.questionAnswer.size() == this.questionCorrect.size()) {
            for (i = 0; i < n; ++i) {
                if (this.questionAnswer.get(i) != this.questionCorrect.get(i)) {
                    break;
                }
            }
        }

        if (i == n) {
            point = 1;
        }

        return point;
    }

    @Override
    public String toString() {
        return "TrueFalseQuestion{" +
                "questionChoices=" + questionChoices +
                ", questionDescription='" + questionDescription + '\'' +
                ", questionCorrect=" + questionCorrect +
                ", questionAnswer=" + questionAnswer +
                '}';
    }
}
