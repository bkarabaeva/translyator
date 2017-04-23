package com.bkarabaeva.trnslayator.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "https://translate.yandex.net";
    private YandexTranslateApiEndpointInterface endpointInterface;

    public ApiClient()
    {
        Gson gson = new GsonBuilder()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        endpointInterface = retrofit.create(YandexTranslateApiEndpointInterface.class);
    }

    public YandexTranslateApiEndpointInterface getApi() {
        return endpointInterface;
    }

}