package com.example.nihanapp2.ui.dementia;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DementiaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DementiaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Dementia");
    }

    public LiveData<String> getText() {
        return mText;
    }
}