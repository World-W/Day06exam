package com.example.wangshije20200224.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wangshije20200224.R;
import com.example.wangshije20200224.base.Bean;

import java.util.List;

/*
 * 王世杰
 * 20200227
 * */
public class MyAdapter extends BaseAdapter {
    Context context;
    List<Bean.ResultsBean.NewsistBean> list;

    public MyAdapter(Context context, List<Bean.ResultsBean.NewsistBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder=null;
        if(view==null){
            View.inflate(context, R.layout.item,null);
            holder=new ViewHolder();
            holder.iv=view.findViewById(R.id.image);
            holder.t1=view.findViewById(R.id.t1);
            holder.t2=view.findViewById(R.id.t2);
            holder.t3=view.findViewById(R.id.t3);
            holder.t4=view.findViewById(R.id.t4);
            view.setTag(holder);
        }else{
            holder= (ViewHolder) view.getTag();
        }
        Bean.ResultsBean.NewsistBean newsistBean = list.get(i);
        String image = newsistBean.getImage();
        Glide.with(context).load(image).into(holder.iv);
        String title = newsistBean.getTitle();
        holder.t1.setText(title);
        String content = newsistBean.getContent();
        holder.t2.setText(content);
        String author = newsistBean.getAuthor();
        holder.t3.setText(author);
        String time = newsistBean.getTime();
        holder.t4.setText(time);
        return view;
    }

    private class ViewHolder {
        ImageView iv;
        TextView t1;
        TextView t2;
        TextView t3;
        TextView t4;
    }
}
