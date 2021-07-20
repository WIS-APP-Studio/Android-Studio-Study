package com.example.post;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PostAdapter extends BaseAdapter {
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<PostData> sample;

    public PostAdapter(Context context, ArrayList<PostData> data) {
        mContext = context;
        sample = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return sample.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public PostData getItem(int position) {
        return sample.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.item_list, null);

        TextView writerText = (TextView)view.findViewById(R.id.textView_list_writer);
        ImageView imageView = (ImageView)view.findViewById(R.id.imageView_image);
        TextView movieName = (TextView)view.findViewById(R.id.textView_list_title);
        TextView grade = (TextView)view.findViewById(R.id.textView_list_description);

        writerText.setText(sample.get(position).getWriter());
        imageView.setImageResource(R.drawable.test);
        movieName.setText(sample.get(position).getTitle());
        grade.setText(sample.get(position).getDescription());

        return view;
    }
}
