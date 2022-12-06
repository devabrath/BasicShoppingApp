package com.example.onlineshopping.ui.AccountInfo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AccountInfoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AccountInfoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is AccountInfo fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}