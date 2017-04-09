package com.dpelluzi.dynamicform.util;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class PhoneNumberFormatter implements TextWatcher {

    private static final String mask10 = "(##) ####-####";
    private static final String mask11 = "(##) #####-####";

    private boolean mIsUpdating;
    private String mOld = "";
    private EditText mEditText;

    private static String unmask(String s) {
        return s.replaceAll("[^0-9]*", "");
    }

    public PhoneNumberFormatter(EditText editText) {
        mEditText = editText;
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String str = unmask(s.toString());
        String mask;
        String defaultMask = getDefaultMask(str);
        switch (str.length()) {
            case 11:
                mask = mask11;
                break;
            default:
                mask = defaultMask;
                break;
        }

        String mascara = "";
        if (mIsUpdating) {
            mOld = str;
            mIsUpdating = false;
            return;
        }
        int i = 0;
        for (char m : mask.toCharArray()) {
            if ((m != '#' && str.length() > mOld.length()) ||
                    (m != '#' && str.length() < mOld.length() && str.length() != i)) {
                mascara += m;
                continue;
            }

            try {
                mascara += str.charAt(i);
            } catch (Exception e) {
                break;
            }
            i++;
        }
        mIsUpdating = true;
        mEditText.setText(mascara);
        mEditText.setSelection(mascara.length());
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void afterTextChanged(Editable s) {
    }


    private static String getDefaultMask(String str) {
        String defaultMask = mask10;
        if (str.length() > 11) {
            defaultMask = mask11;
        }
        return defaultMask;
    }

}
