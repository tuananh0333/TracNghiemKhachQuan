package com.example.tracnghiemkhachquan.flagments;

import android.app.Fragment;

import com.example.tracnghiemkhachquan.data_models.AbstractQuestion;

public abstract class AbstractQuestionFlagments extends Fragment {
    public abstract void setQuestion(AbstractQuestion question);
    public abstract void updateAnswer(int questionID);
}
