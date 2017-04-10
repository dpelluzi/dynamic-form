package com.dpelluzi.dynamicform.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dpelluzi.dynamicform.R;
import com.dpelluzi.dynamicform.databinding.FragmentInvestmentBinding;
import com.dpelluzi.dynamicform.interfaces.InvestmentContract;
import com.dpelluzi.dynamicform.models.Fund;
import com.dpelluzi.dynamicform.models.Graph;
import com.dpelluzi.dynamicform.models.Info;
import com.dpelluzi.dynamicform.presenters.InvestmentPresenter;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.List;

public class InvestmentFragment extends Fragment implements InvestmentContract.View {

    private InvestmentContract.Presenter mPresenter;
    private FragmentInvestmentBinding mBinding;
    private RecyclerView mRecyclerView;
    private GraphView mGraphView;

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
        mGraphView = (GraphView) view.findViewById(R.id.graph);

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

    @Override
    public void setupGraph(Graph graphData) {
        DataPoint[] points1 = new DataPoint[graphData.getFund().length];
        for (int i = 0; i < points1.length; i++) {
            points1[i] = new DataPoint(i, graphData.getFund()[i]);
        }

        DataPoint[] points2 = new DataPoint[graphData.getCDI().length];
        for (int i = 0; i < points2.length; i++) {
            points2[i] = new DataPoint(i, graphData.getCDI()[i]);
        }

        LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>(points1);
        series1.setColor(ContextCompat.getColor(getContext(), R.color.graph_fund));

        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(points2);
        series2.setColor(ContextCompat.getColor(getContext(), R.color.graph_cdi));

        mGraphView.addSeries(series1);
        mGraphView.addSeries(series2);

        mGraphView.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.HORIZONTAL);
        mGraphView.getGridLabelRenderer().setHorizontalLabelsVisible(false);
        mGraphView.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {

            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX) {
                    return super.formatLabel(value, isValueX);
                } else {
                    return super.formatLabel(value, isValueX) + "%";
                }
            }
        });
    }
}
