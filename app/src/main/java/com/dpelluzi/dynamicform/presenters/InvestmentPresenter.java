package com.dpelluzi.dynamicform.presenters;

import com.dpelluzi.dynamicform.interfaces.InvestmentContract;
import com.dpelluzi.dynamicform.models.Fund;
import com.dpelluzi.dynamicform.models.FundData;

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
//        mView.setTitle(mFund.getTitle());
//        mView.setFundName(mFund.getFundName());
//        mView.setWhatIs(mFund.getWhatIs());
//        mView.setDefinition(mFund.getDefinition());
//        mView.setRiskTitle(mFund.getRiskTitle());
//        mView.setInfoTitle(mFund.getInfoTitle());
    }
}
