package com.example.nihanapp2.ui.dental;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DentalViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DentalViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("[insert text/other here if necessary...]");
    }

    public LiveData<String> getText() {
        return mText;
    }
}