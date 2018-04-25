package com.observer.test;

import com.observer.test.ObjectUtils.Observer;
import com.observer.test.SubjectUtils.Commentary;
import com.observer.test.SubjectUtils.Subject;

import java.util.List;

/**
 * Created by Chaklader on 2/12/17.
 */
public class CommentaryObject implements Subject, Commentary {


    private final List<Observer> observers;
    private String desc;
    private final String subjectDetails;

    public CommentaryObject(List<Observer> observers, String subjectDetails) {
        this.observers = observers;
        this.subjectDetails = subjectDetails;
    }

    @Override
    public void subscribeObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unSubscribeObserver(Observer observer) {
        int index = observers.indexOf(observer);
        observers.remove(index);
    }

    @Override
    public void notifyObservers() {
        System.out.println();
        for (Observer observer : observers) {
            observer.update(desc);
        }
    }

    @Override
    public void setDesc(String desc) {
        this.desc = desc;
        notifyObservers();
    }

    @Override
    public String subjectDetails() {
        return subjectDetails;
    }
}