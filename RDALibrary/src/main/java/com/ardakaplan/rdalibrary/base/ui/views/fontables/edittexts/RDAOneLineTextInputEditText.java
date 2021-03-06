package com.ardakaplan.rdalibrary.base.ui.views.fontables.edittexts;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;

import com.google.android.material.textfield.TextInputEditText;

/**
 * Created by ardakaplan on 08/12/15.
 * <p/>
 * www.ardakaplan.com
 * <p/>
 * arda.kaplan09@gmail.com
 */
public class RDAOneLineTextInputEditText extends TextInputEditText {

    TextWatcher onlyOneLineTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            for (int i = s.length(); i > 0; i--) {
                if (s.subSequence(i - 1, i).toString().equals("\n"))
                    s.replace(i - 1, i, "");
            }
        }
    };

    public RDAOneLineTextInputEditText(Context context) {
        super(context);

        setMaxLines(1);

        this.addTextChangedListener(onlyOneLineTextWatcher);
    }

    public RDAOneLineTextInputEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        setMaxLines(1);

        this.addTextChangedListener(onlyOneLineTextWatcher);
    }

    public RDAOneLineTextInputEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setMaxLines(1);

        this.addTextChangedListener(onlyOneLineTextWatcher);
    }

    @SuppressWarnings("ConstantConditions")
    public String getPureString() {

        return getText().toString().trim();
    }
}
