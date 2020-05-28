package com.example.nihanapp2.ui.homehealth;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeHealthViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeHealthViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home health fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}