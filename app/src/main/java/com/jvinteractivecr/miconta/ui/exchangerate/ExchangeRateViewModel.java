package com.jvinteractivecr.miconta.ui.exchangerate;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jvinteractivecr.miconta.utils.Utils;

public class ExchangeRateViewModel extends ViewModel {

    private final MutableLiveData<String> txtExchangeRateDate;
    private final MutableLiveData<String> txtExchangeRateBuy;
    private final MutableLiveData<String> txtExchangeRateSell;
    private final MutableLiveData<String> txtLastUpdate;

    public ExchangeRateViewModel(){
        txtExchangeRateDate = new MutableLiveData<>();
        txtExchangeRateBuy = new MutableLiveData<>();
        txtExchangeRateSell = new MutableLiveData<>();
        txtLastUpdate = new MutableLiveData<>();

        txtExchangeRateDate.setValue(Utils.getToday());
    }

    public LiveData<String> getTxtExchangeRateDate() {
        return txtExchangeRateDate;
    }

    public LiveData<String> getTxtExchangeRateBuy() {
        return txtExchangeRateBuy;
    }

    public LiveData<String> getTxtExchangeRateSell() {
        return txtExchangeRateSell;
    }

    public LiveData<String> getTxtLastUpdate() { return txtLastUpdate; }
}