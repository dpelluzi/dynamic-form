package com.dpelluzi.dynamicform.interfaces;

import com.dpelluzi.dynamicform.models.Fund;

public interface InvestmentContract {

    interface Presenter {

        void onViewCreated();
    }

    interface View {

        void bindData(Fund fund);
    }
}
