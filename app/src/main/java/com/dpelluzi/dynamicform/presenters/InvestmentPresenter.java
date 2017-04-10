package com.dpelluzi.dynamicform.presenters;

import com.dpelluzi.dynamicform.interfaces.InvestmentContract;
import com.dpelluzi.dynamicform.models.Fund;
import com.dpelluzi.dynamicform.models.FundData;
import com.dpelluzi.dynamicform.models.Info;

import java.util.ArrayList;
import java.util.List;

public class InvestmentPresenter implements InvestmentContract.Presenter {

    private InvestmentContract.View mView;
    private Fund mFund;

    public InvestmentPresenter(InvestmentContract.View view) {
        mView = view;
        mFund = FundData.loadFundData().getFund();
    }

    @Override
    public void onViewCreated() {
        mView.bindData(mFund);

        mView.setupGraph(mFund.getGraph());

        List<Info> infoList = new ArrayList<>();
        infoList.addAll(mFund.getInfo());
        infoList.addAll(mFund.getDownInfo());

        mView.setInfoList(infoList);
    }
}
