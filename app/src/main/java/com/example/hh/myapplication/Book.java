package com.example.hh.myapplication;

import org.litepal.crud.DataSupport;

/**
 * Created by hh on 2017/4/24.
 */

public class Book extends DataSupport {
    private String Question;
    private String Answer;

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }
}
