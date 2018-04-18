package com.observer.test.SubjectUtils;


import com.observer.test.ObjectUtils.Observer;

/**
 * Created by Chaklader on 2/12/17.
 */
public interface Subject {

    public void subscribeObserver(Observer observer);
    public void unSubscribeObserver(Observer observer);
    public void notifyObservers();
    public String subjectDetails();
}

