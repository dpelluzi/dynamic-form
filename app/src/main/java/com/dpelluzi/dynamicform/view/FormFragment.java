package com.dpelluzi.dynamicform.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.dpelluzi.dynamicform.R;
import com.dpelluzi.dynamicform.interfaces.FormContract;
import com.dpelluzi.dynamicform.models.Cell;
import com.dpelluzi.dynamicform.presenters.FormPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FormFragment extends Fragment implements FormContract.View, View.OnClickListener {

    private FormContract.Presenter mPresenter;

    @BindView(R.id.view_container)
    LinearLayout mViewContainer;

    public static FormFragment newInstance() {
        return new FormFragment();
    }

    public FormFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new FormPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_form, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mPresenter.onViewCreated();
    }

    @Override
    public void insertCells(List<Cell> cells) {
        CellViewConverter converter = new CellViewConverter(getContext());
        for (Cell cell: cells) {
            View view = converter.convert(cell);
            if (view != null) {
                view.setOnClickListener(this);
                mViewContainer.addView(view);
                ((LinearLayout.LayoutParams) view.getLayoutParams()).topMargin = (int) cell
                        .getTopSpacing();
            }
        }
    }

    @Override
    public void onClick(View view) {
        mPresenter.onCellClicked((Cell)view.getTag());
    }

    @Override
    public void showCell(int cellId) {
        mViewContainer.findViewById(cellId).setVisibility(View.VISIBLE);
    }

    @Override
    public boolean isCellSelected(int cellId) {
        View view = mViewContainer.findViewById(cellId);

        return view instanceof CheckBox && ((CheckBox) view).isChecked();
    }

    @Override
    public boolean isCellVisible(int cellId) {
        return mViewContainer.findViewById(cellId).getVisibility() == View.VISIBLE;
    }

    @Override
    public void hideCell(int cellId) {
        mViewContainer.findViewById(cellId).setVisibility(View.GONE);
    }

    @Override
    public String getInputText(int cellId) {
        View view = mViewContainer.findViewById(cellId);
        if (view instanceof TextInputLayout) {
            TextInputLayout inputLayout = (TextInputLayout) view;
            return inputLayout.getEditText().getText().toString();
        }

        return "";
    }

    @Override
    public void setInputTextError(int cellId) {
        View view = mViewContainer.findViewById(cellId);
        if (view instanceof TextInputLayout) {
            TextInputLayout inputLayout = (TextInputLayout) view;
            inputLayout.setError(getString(R.string.invalid_field));
            inputLayout.requestFocus();
        }
    }

    @Override
    public void clearError(int cellId) {
        View view = mViewContainer.findViewById(cellId);
        if (view instanceof TextInputLayout) {
            ((TextInputLayout) view).setError(null);
        }
    }

    @Override
    public void startSuccessScreen() {
        Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show(); // TODO replace with fragment
    }

}
