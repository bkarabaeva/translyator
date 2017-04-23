package com.bkarabaeva.trnslayator.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bkarabaeva.trnslayator.BuildConfig;
import com.bkarabaeva.trnslayator.R;
import com.bkarabaeva.trnslayator.TrnslApp;
import com.bkarabaeva.trnslayator.network.Direction;
import com.bkarabaeva.trnslayator.network.Languages;
import com.bkarabaeva.trnslayator.network.Translation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TranslateFragment extends Fragment {

    private static final String DEFAULT_UI = "ru";
    private static final String DEFULT_LANG_DIRC = "en-ru";

    private AppCompatEditText translateEditText;
    private Button translateBtn;
    private AppCompatTextView translatedView;

    private TextView  fromView, toView;

    private List<Direction> directionList = new ArrayList<>();

    public TranslateFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_translate, container, false);
        translateEditText = (AppCompatEditText) view.findViewById(R.id.translateEditText);
        translateBtn = (Button) view.findViewById(R.id.translateBtn);
        translatedView = (AppCompatTextView) view.findViewById(R.id.translatedView);
        fromView = (TextView) view.findViewById(R.id.fromTextView);
        toView = (TextView) view.findViewById(R.id.toLangText);


        TrnslApp.getApi().getLangs(BuildConfig.API_KEY, DEFAULT_UI).enqueue(new Callback<Languages>() {
            @Override
            public void onResponse(Call<Languages> call, Response<Languages> response) {
                directionList.addAll(response.body().getDirs());
                Map<String, String> langs = response.body().getLangs();
                Direction defaultOne = new Direction();
                defaultOne.parseString(DEFULT_LANG_DIRC);
                fromView.setText(langs.get(defaultOne.getFromLang()));
                toView.setText(langs.get(defaultOne.getToLang()));
            }

            @Override
            public void onFailure(Call<Languages> call, Throwable t) {

            }
        });

        translateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TrnslApp.getApi().translate(BuildConfig.API_KEY, translateEditText.getText().toString(), DEFULT_LANG_DIRC).enqueue(new Callback<Translation>() {
                    @Override
                    public void onResponse(Call<Translation> call, Response<Translation> response) {
                        translatedView.setText(response.body().getText().get(0));
                    }

                    @Override
                    public void onFailure(Call<Translation> call, Throwable t) {

                    }
                });
            }
        });
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
