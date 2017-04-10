package com.dpelluzi.dynamicform.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dpelluzi.dynamicform.R;
import com.dpelluzi.dynamicform.databinding.FragmentInvestmentBinding;
import com.dpelluzi.dynamicform.interfaces.InvestmentContract;
import com.dpelluzi.dynamicform.models.Fund;
import com.dpelluzi.dynamicform.models.Info;
import com.dpelluzi.dynamicform.presenters.InvestmentPresenter;

import java.util.List;

public class InvestmentFragment extends Fragment implements InvestmentContract.View {

    private InvestmentContract.Presenter mPresenter;
    private FragmentInvestmentBinding mBinding;
    private RecyclerView mRecyclerView;

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
        mRecyclerView = (RecyclerView) view.findViewById(R.id.fund_info_list);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);

        mPresenter.onViewCreated();
    }

    @Override
    public void bindData(Fund fund) {
        mBinding.setFund(fund);
    }

    @Override
    public void setInfoList(List<Info> infoList) {
        FundInfoAdapter adapter = new FundInfoAdapter(infoList);
        mRecyclerView.setAdapter(adapter);
    }
}
