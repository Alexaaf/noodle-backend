package com.example.noodle.controller;

import java.util.Iterator;
import java.util.List;

public class AnswerIterator implements Iterator<String> {

    List<String> answersList;
    int pos = 0;

    public AnswerIterator(List<String> answersList){
        this.answersList = answersList;
    }

    @Override
    public boolean hasNext() {
        if (pos >= answersList.size() || answersList.get(pos) == null)
            return false;
        else
            return true;
    }

    @Override
    public String next() {
        String studentAnswer = answersList.get(pos);
        pos += 1;
        return studentAnswer;
    }
}
