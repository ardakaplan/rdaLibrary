package com.ardakaplan.rdalibrarytest.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.ardakaplan.rdalibrary.base.ui.screen.presenters.RDAPresenterContract;
import com.ardakaplan.rdalibrary.managers.ThemeManager;
import com.ardakaplan.rdalibrarytest.R;
import com.ardakaplan.rdalibrarytest.di.ThemeModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Arda Kaplan at 10-Aug-20 - 11:28
 * <p>
 * ardakaplan101@gmail.com
 */
public class ThemeTestActivity extends BaseActivity {

    @BindView(R.id.themeTestActivity_textView_themeName)
    TextView themeNameTextView;

    @Inject
    ThemeManager themeManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setViews();
    }

    private void setViews() {

        themeNameTextView.setText(themeManager.getCurrentTheme().getThemeName());
    }

    @OnClick(R.id.themeTestActivity_button_theme1)
    void clickedTheme1() {

        themeManager.changeTheme(ThemeModule.TEST_1);

        finish();
    }

    @OnClick(R.id.themeTestActivity_button_theme2)
    void clickedTheme2() {

        themeManager.changeTheme(ThemeModule.TEST_2);

        finish();
    }

    @Override
    public int getLayout() {
        return R.layout.theme_test_activity;
    }

    @Override
    public RDAPresenterContract getPresenterContract() {
        return null;
    }
}
