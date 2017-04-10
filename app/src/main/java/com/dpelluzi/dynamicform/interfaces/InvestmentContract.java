package com.dpelluzi.dynamicform.interfaces;

import com.dpelluzi.dynamicform.models.Fund;
import com.dpelluzi.dynamicform.models.Info;

import java.util.List;

public interface InvestmentContract {

    interface Presenter {

        void onViewCreated();
    }

    interface View {

        void bindData(Fund fund);

        void setInfoList(List<Info> infoList);
    }
}
