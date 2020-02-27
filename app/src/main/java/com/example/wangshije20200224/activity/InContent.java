package com.example.wangshije20200224.activity;
/*
* 王世杰
* 20200226
* */
public interface InContent {
    interface Iview{
        void onSuccess(String url);
        void onError(String url);
    }
    interface Iprenster{
        void getBanner(String url);
    }
    interface Imoudle{
        void getBanner(String url,Iback iback);

        interface Iback {
            void onSuccess(String url);
            void onError(String url);
        }
    }
}
