package com.example.tracnghiemkhachquan.data_models;

import java.util.ArrayList;

public class MultiQuestionOneChoice extends AbstractQuestion {

    private ArrayList<String> questionChoices;

    public MultiQuestionOneChoice() {
        this.questionChoices = new ArrayList<String>();
        this.questionAnswer = new ArrayList<Integer>();
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

        if (this.questionAnswer.size() == this.questionCorrect.size()) {
            if (this.questionAnswer.get(0) == this.questionCorrect.get(0)) {
                point = 1;
            }
        }

        return point;
    }

    @Override
    public String toString() {
        return "MultiQuestionOneChoice{" +
                "questionChoices=" + questionChoices +
                ", questionDescription='" + questionDescription + '\'' +
                ", questionCorrect=" + questionCorrect +
                ", questionAnswer=" + questionAnswer +
                '}';
    }
}
