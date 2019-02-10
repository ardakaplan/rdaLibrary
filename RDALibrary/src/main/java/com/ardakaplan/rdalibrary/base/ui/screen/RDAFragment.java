package com.ardakaplan.rdalibrary.base.ui.screen;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ardakaplan.rdalogger.RDALogger;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;

@SuppressWarnings("unused")
public abstract class RDAFragment extends DialogFragment {

    private Unbinder unbinder;

    public String className;

    public RDAFragment() {
        className = getClass().getSimpleName();
    }

    public void onAttach(Context context) {

        AndroidSupportInjection.inject(this);

        super.onAttach(context);
    }

    public int[] getFragmentAnimationList() {

        return new int[]{};
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RDALogger.logLifeCycle(className);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        RDALogger.logLifeCycle(className);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        RDALogger.logLifeCycle(className);

        View view = inflater.inflate(getViewLayout(), container, false);

        unbinder = ButterKnife.bind(this, view);

        initViews(view);

        return view;
    }

    protected void initViews(View parentView) {

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        RDALogger.logLifeCycle(className);
    }

    @Override
    public void onStart() {
        super.onStart();

        RDALogger.logLifeCycle(className);
    }

    @Override
    public void onResume() {
        super.onResume();

        RDALogger.logLifeCycle(className);
    }

    @Override
    public void onPause() {
        super.onPause();

        RDALogger.logLifeCycle(className);
    }

    @Override
    public void onStop() {
        super.onStop();

        RDALogger.logLifeCycle(className);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (unbinder != null) {

            unbinder.unbind();
        }

        RDALogger.logLifeCycle(className);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        RDALogger.logLifeCycle(className);
    }

    @Override
    public void onDetach() {
        super.onDetach();

        RDALogger.logLifeCycle(className);
    }

    public boolean checkFragmentData(String key) {

        return this.getArguments() != null && this.getArguments().containsKey(key);
    }

    protected abstract @LayoutRes
    int getViewLayout();
}