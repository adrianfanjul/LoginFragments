package com.tokioschool.loginfragments.login.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tokioschool.loginfragments.domain.User;

public class SharedViewModel extends ViewModel
{
    private final MutableLiveData<User> mutableUser= new MutableLiveData<>();
    private final MutableLiveData<String> mutableFragment= new MutableLiveData<>();

    public void setUser(User user){
        mutableUser.setValue(user);
    }

    public LiveData<User> getUser(){
        return mutableUser;
    }

    public void setFragment(String fragmentName){
        mutableFragment.setValue(fragmentName);
    }

    public LiveData<String> getFragment(){
        return mutableFragment;
    }
}
