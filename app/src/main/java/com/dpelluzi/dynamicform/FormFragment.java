package com.dpelluzi.dynamicform;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FormFragment extends Fragment {


    public FormFragment() {
    }

    public static FormFragment newInstance() {
        return new FormFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_form, container);

        return view;
    }

}
