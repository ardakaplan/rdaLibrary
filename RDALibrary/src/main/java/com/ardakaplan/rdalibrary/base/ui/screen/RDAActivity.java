package com.ardakaplan.rdalibrary.base.ui.screen;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;

import com.ardakaplan.rdalogger.RDALogger;

import java.util.Locale;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

@SuppressWarnings("unused")
public abstract class RDAActivity extends DaggerAppCompatActivity implements ActivityContract {

    protected String className;

    private boolean onScreen = false;

    protected RDAActivity() {

        className = getClass().getSimpleName();
    }

    @Override
    public Context changeLanguage(Context context, Locale locale) {

        return ScreenHelpers.changeLanguage(context, locale);
    }

    @Override
    protected void attachBaseContext(Context context) {

        super.attachBaseContext(ScreenHelpers.attachBaseContext(context, getApplication()));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        RDALogger.logLifeCycle(className);

        setContentView(getLayout());

        ButterKnife.bind(this);

    }

//    protected void onCreate(Bundle savedInstanceState, int layoutId) {
//
//        super.onCreate(savedInstanceState);
//
//        setContentView(layoutId);
//
//        ButterKnife.bind(this);
//
//        RDALogger.logLifeCycle(className);
//    }

    protected void changeStatusBarColor(@ColorRes int colorId) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            getWindow().setStatusBarColor(getActivity().getResources().getColor(colorId));
        }
    }

    @SuppressWarnings("unused")
    public boolean isOnScreen() {
        return onScreen;
    }

    protected RDAActivity getActivity() {
        return this;
    }

    @Override
    protected void onResume() {
        super.onResume();

        onScreen = true;

        RDALogger.logLifeCycle(className);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        RDALogger.logLifeCycle(className);
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        RDALogger.logLifeCycle(className);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        onScreen = false;

        RDALogger.logLifeCycle(className);
    }

    @Override
    protected void onPause() {
        super.onPause();

        onScreen = false;

        RDALogger.logLifeCycle(className);
    }

    @Override
    protected void onStart() {
        super.onStart();

        RDALogger.logLifeCycle(className);
    }

    @Override
    protected void onStop() {
        super.onStop();

        onScreen = false;

        RDALogger.logLifeCycle(className);
    }


}
