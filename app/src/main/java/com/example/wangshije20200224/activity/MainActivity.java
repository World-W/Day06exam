package com.example.wangshije20200224.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.wangshije20200224.R;
import com.example.wangshije20200224.adapter.MyAdapter;
import com.example.wangshije20200224.base.Bean;
import com.example.wangshije20200224.prenster.InPrenster;
import com.example.wangshije20200224.utiuls.NetUtiuls;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;
/*
 * 王世杰
 * 20200227
 * */

public class MainActivity extends AppCompatActivity implements InContent.Iview {
    private InPrenster prenster;
    private XBanner xb;
    private ListView lv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url ="http://blog.zhaoliang5156.cn/api/news/news_data.json";
        prenster=new InPrenster(this);
        xb=findViewById(R.id.xb);
        lv=findViewById(R.id.list);
    }

    @Override
    public void onSuccess(String url) {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "这是本商品的id", Toast.LENGTH_SHORT).show();
            }
        });
        boolean net= NetUtiuls.getInstance().inNet(this);
        if (net){
            Gson gson = new Gson();
            Bean bean = gson.fromJson(url, Bean.class);
            List<Bean.ResultsBean> results = bean.getResults();
            Bean.ResultsBean resultsBean = results.get(0);
            List<Bean.ResultsBean.NewsistBean> newsist = resultsBean.getNewsist();
            final List<Bean.ResultsBean.BannerBean> banner = resultsBean.getBanner();
            MyAdapter myAdapter = new MyAdapter(this,newsist);
            lv.setAdapter(myAdapter);
        }
    }

    @Override
    public void onError(String url) {

    }
}
