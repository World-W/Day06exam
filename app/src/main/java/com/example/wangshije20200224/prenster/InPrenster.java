package com.example.wangshije20200224.prenster;

import com.example.wangshije20200224.activity.InContent;
import com.example.wangshije20200224.activity.MainActivity;
import com.example.wangshije20200224.moudle.InMoudle;
/*
 * 王世杰
 * 20200227
 * */

public class InPrenster implements InContent.Iprenster {
    InContent.Iview iview;
    InMoudle moudle;
    public InPrenster(MainActivity view){
        iview= (InContent.Iview) view;
        moudle=new InMoudle();
    }
    @Override
    public void getBanner(String url) {
moudle.getBanner(url, new InContent.Imoudle.Iback() {
    @Override
    public void onSuccess(String url) {
        iview.onSuccess(url);
    }

    @Override
    public void onError(String url) {
        iview.onError(url);
    }
});
    }
}
