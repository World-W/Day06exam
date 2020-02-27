package com.example.wangshije20200224.utiuls;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.wangshije20200224.base.App;


import java.util.HashMap;
import java.util.Map;


public class VolleyUtils {

    RequestQueue mQueue;

    private VolleyUtils(){

        mQueue = Volley.newRequestQueue(App.getAppContext());
    }

    private static class SingleInstance{
        private static final VolleyUtils INSTANCE = new VolleyUtils();
    }

    public static VolleyUtils getInstance(){
        return SingleInstance.INSTANCE;
    }


    public void doGet(String url, final CallBack callBack){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>(){
                @Override
                public void onResponse(String response) {
                    callBack.success(response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    callBack.falied(error.getMessage());
                }
            }
        );

        mQueue.add(stringRequest);
    }


    public void doPost(String url, final HashMap<String, String> map, final CallBack callBack){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callBack.success(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callBack.falied(error.getMessage());
                    }
                }) {
                    @Override
                    protected Map getParams() {
                        return map;
                    }

        };
        mQueue.add(stringRequest);
    }

    public interface CallBack{
        //成功
        void success(String json);
        //失败
        void falied(String msg);
    }
}
