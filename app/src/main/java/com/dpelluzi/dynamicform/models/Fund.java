package com.dpelluzi.dynamicform.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class Fund {

    @SerializedName("title")
    private String title;

    @SerializedName("fundName")
    private String fundName;

    @SerializedName("whatIs")
    private String whatIs;

    @SerializedName("definition")
    private String definition;

    @SerializedName("graph")
    private Graph graph;

    @SerializedName("riskTitle")
    private String riskTitle;

    @SerializedName("risk")
    private long risk;

    @SerializedName("infoTitle")
    private String infoTitle;

    @SerializedName("moreInfo")
    private Profitability moreInfo;

    @SerializedName("info")
    private List<Info> info = null;

    @SerializedName("downInfo")
    private List<Info> downInfo = null;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getWhatIs() {
        return whatIs;
    }

    public void setWhatIs(String whatIs) {
        this.whatIs = whatIs;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public String getRiskTitle() {
        return riskTitle;
    }

    public void setRiskTitle(String riskTitle) {
        this.riskTitle = riskTitle;
    }

    public long getRisk() {
        return risk;
    }

    public void setRisk(long risk) {
        this.risk = risk;
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }

    public Profitability getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(Profitability moreInfo) {
        this.moreInfo = moreInfo;
    }

    public List<Info> getInfo() {
        return info;
    }

    public void setInfo(List<Info> info) {
        this.info = info;
    }

    public List<Info> getDownInfo() {
        return downInfo;
    }

    public void setDownInfo(List<Info> downInfo) {
        this.downInfo = downInfo;
    }

}
