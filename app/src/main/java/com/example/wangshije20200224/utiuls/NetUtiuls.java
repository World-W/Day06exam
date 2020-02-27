package com.example.wangshije20200224.utiuls;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
/*
 * 王世杰
 * 20200227
 * */

public class NetUtiuls {
    Handler handler = new Handler();
    private static final NetUtiuls ourInstance = new NetUtiuls();

    public static NetUtiuls getInstance() {
        return ourInstance;
    }

    private NetUtiuls() {
    }
    public interface ICallBack{
        void onSucess(String url);
        void onError(String url);
    }
    public boolean inNet(Context context){
        ConnectivityManager conn = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = conn.getActiveNetworkInfo();
        if(info!=null){
            return true;
        }
        return false;
    }
    public void getJson(final String path, final ICallBack iCallBack){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(path);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setConnectTimeout(5000);
                    conn.setReadTimeout(5000);
                    int responseCode = conn.getResponseCode();
                    if(responseCode==200){
                        InputStream inputStream = conn.getInputStream();
                        int len=0;
                        byte[] bytes = new byte[1024];
                        StringBuilder sb = new StringBuilder();
                        while ((len=inputStream.read(bytes))!=-1){
                            sb.append(new String(bytes,0,len));
                        }
                        inputStream.close();
                        final String s = sb.toString();
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                iCallBack.onSucess(s);
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
