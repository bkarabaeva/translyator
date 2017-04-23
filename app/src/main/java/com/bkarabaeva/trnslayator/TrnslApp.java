package com.bkarabaeva.trnslayator;

import android.app.Application;

import com.bkarabaeva.trnslayator.network.ApiClient;
import com.bkarabaeva.trnslayator.network.YandexTranslateApiEndpointInterface;

public class TrnslApp extends Application {
    private static YandexTranslateApiEndpointInterface api;

    @Override
    public void onCreate() {
        super.onCreate();
        api = new ApiClient().getApi();
    }

    public static YandexTranslateApiEndpointInterface getApi() {
        return api;
    }
}
