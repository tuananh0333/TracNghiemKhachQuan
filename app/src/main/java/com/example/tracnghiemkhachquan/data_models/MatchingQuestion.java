package com.example.tracnghiemkhachquan.data_models;

import java.util.ArrayList;

public class MatchingQuestion extends AbstractQuestion {

    private ArrayList<String> questionChoicesA;
    private ArrayList<String> questionChoicesB;

    public MatchingQuestion() {
        this.questionChoicesA = new ArrayList<String>();
        this.questionChoicesB = new ArrayList<String>();
        this.questionCorrect = new ArrayList<Integer>();
        this.questionAnswer = new ArrayList<Integer>();
    }

    @Override
    public int getPoint() {
        int point = 0;
        int n = this.questionCorrect.size();
        int i = 0;

        if (this.getQuestionAnswer().size() == this.getQuestionCorrect().size()) {
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

    public ArrayList<String> getQuestionChoicesA() {
        return questionChoicesA;
    }

    public void setQuestionChoicesA(String... questionChoicesA) {
        for (String a : questionChoicesA) {
            this.questionChoicesA.add(a);
        }
    }

    public ArrayList<String> getQuestionChoicesB() {
        return questionChoicesB;
    }

    public void setQuestionChoicesB(String... questionChoicesB) {
        for (String b : questionChoicesB) {
            this.questionChoicesB.add(b);
        }
    }

    @Override
    public String toString() {
        return "MatchingQuestion{" +
                "questionChoicesA=" + questionChoicesA +
                ", questionChoicesB=" + questionChoicesB +
                ", questionDescription='" + questionDescription + '\'' +
                ", questionCorrect=" + questionCorrect +
                ", questionAnswer=" + questionAnswer +
                '}';
    }
}
