package com.dpelluzi.dynamicform.view;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.dpelluzi.dynamicform.R;
import com.dpelluzi.dynamicform.databinding.RowFundInfoBinding;
import com.dpelluzi.dynamicform.models.Info;

import java.util.List;

public class FundInfoAdapter extends RecyclerView.Adapter<FundInfoAdapter.FundInfoViewHolder> {


    private List<Info> mInfoList;

    public FundInfoAdapter(List<Info> infoList) {
        mInfoList = infoList;
    }

    @Override
    public FundInfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RowFundInfoBinding binding = DataBindingUtil.inflate(inflater, R.layout.row_fund_info, parent, false);
        return new FundInfoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(FundInfoViewHolder holder, int position) {
        holder.bind(mInfoList.get(position));
    }

    @Override
    public int getItemCount() {
        return mInfoList.size();
    }

    public class FundInfoViewHolder extends RecyclerView.ViewHolder {

        private RowFundInfoBinding mInfoBinding;

        public FundInfoViewHolder(RowFundInfoBinding infoBinding) {
            super(infoBinding.getRoot());
            mInfoBinding = infoBinding;
        }

        public void bind(Info info) {
            mInfoBinding.setInfo(info);
            mInfoBinding.executePendingBindings();
        }
    }
}
