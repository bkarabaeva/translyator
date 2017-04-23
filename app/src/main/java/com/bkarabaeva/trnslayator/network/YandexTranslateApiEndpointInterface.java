package com.bkarabaeva.trnslayator.network;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface YandexTranslateApiEndpointInterface {
    @FormUrlEncoded
    @POST("api/v1.5/tr.json/translate")
    Call<Translation> translate(@Field("key") String key,
                                @Field("text") String text,
                                @Field("lang") String lang);

    @FormUrlEncoded
    @POST("/api/v1.5/tr.json/getLangs")
    Call<Languages> getLangs(@Field("key") String key,
                             @Field("ui") String ui);
}