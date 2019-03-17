package com.example.tracnghiemkhachquan.data_models;

import java.util.ArrayList;

public abstract class AbstractQuestion {
    protected String questionDescription;
    protected ArrayList<Integer> questionCorrect;
    protected ArrayList<Integer> questionAnswer;
    public abstract int getPoint();

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    public ArrayList<Integer> getQuestionCorrect() {
        return questionCorrect;
    }

    public void setQuestionCorrect(Integer... questionCorrect) {
        for (int a : questionCorrect) {
            this.questionCorrect.add(a);
        }
    }

    public ArrayList<Integer> getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(Integer... questionAnswer) {
        for (int a : questionAnswer) {
            this.questionAnswer.add(a);
        }
    }
}
