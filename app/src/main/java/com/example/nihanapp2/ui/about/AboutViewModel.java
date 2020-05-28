package com.example.nihanapp2.ui.about;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.nihanapp2.R;

public class AboutViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<String> attributionText;

    public AboutViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is about fragment");

    }

    public LiveData<String> getText() {
        return mText;
    }
}