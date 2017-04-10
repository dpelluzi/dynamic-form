package com.dpelluzi.dynamicform.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dpelluzi.dynamicform.R;
import com.dpelluzi.dynamicform.databinding.FragmentInvestmentBinding;
import com.dpelluzi.dynamicform.interfaces.InvestmentContract;
import com.dpelluzi.dynamicform.models.Fund;
import com.dpelluzi.dynamicform.presenters.InvestmentPresenter;

public class InvestmentFragment extends Fragment implements InvestmentContract.View {

    private InvestmentContract.Presenter mPresenter;
    private FragmentInvestmentBinding mBinding;

    public static InvestmentFragment newInstance() {
        return new InvestmentFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new InvestmentPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_investment, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mPresenter.onViewCreated();
    }


    @Override
    public void bindData(Fund fund) {
        mBinding.setFund(fund);
    }
}
