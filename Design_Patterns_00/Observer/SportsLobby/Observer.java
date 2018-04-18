package com.observer.test.ObjectUtils;

/**
 * Created by Chaklader on 2/12/17.
 */
public interface Observer {

    public void update(String desc);
    public void subscribe();
    public void unSubscribe();
}
