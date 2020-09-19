package com.androidlearn.aparat.models;

public interface IMessageListener<T> {


    public void onSuccess(T response);

    public void onFailure(T errorResponse);


}
