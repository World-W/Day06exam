package com.example.wangshije20200224.moudle;

import com.example.wangshije20200224.activity.InContent;
import com.example.wangshije20200224.utiuls.NetUtiuls;
/*
 * 王世杰
 * 20200227
 * */

public class InMoudle implements InContent.Imoudle {
    @Override
    public void getBanner(String url, final Iback iback) {
        NetUtiuls.getInstance().getJson(url, new NetUtiuls.ICallBack() {
            @Override
            public void onSucess(String json) {
                iback.onSuccess(json);
            }

            @Override
            public void onError(String url) {
                iback.onError(url);
            }
        });
    }
}
