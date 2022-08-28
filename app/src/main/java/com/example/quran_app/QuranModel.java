package com.example.quran_app;

public class QuranModel {
    private String Text, FatehTrans,mohsinTrans;

    public QuranModel(String text, String trans1, String trans2) {
        this.Text = text;
        this.FatehTrans = trans1;
        this.mohsinTrans = trans2;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public String getFatehTrans() {
        return FatehTrans;
    }

    public void setFatehTrans(String fatehTrans) {
        FatehTrans = fatehTrans;
    }

    public String getMohsinTrans() {
        return mohsinTrans;
    }

    public void setMohsinTrans(String mohsinTrans) {
        this.mohsinTrans = mohsinTrans;
    }
}

