package com.teac.myRecyclerView.adapters;

/**
 * Created by PTyagi on 9/12/16.
 */

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.teac.myRecyclerView.R;

public class MyAdpter extends RecyclerView.Adapter<MyAdpter.MyLinearViewHolder>{
    private static final String TAG = "MyLinearAdapter";

    private String[] mData;

    public MyAdpter(String[] data) {
        mData = data;
    }

    @Override
    public MyLinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Creates new view at the given position
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.liner_row_item, parent, false);
        return new MyLinearViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyLinearViewHolder holder, int position) {
        //Get the view from this position and update data in it.
        //It re-uses the already rendered view rather re-creating it.
        holder.getTextView().setText(mData[position]);
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    public static class MyLinearViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public MyLinearViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Log.d(TAG, "Clicked on item at position: " + getPosition());
                }
            });

            textView = (TextView) itemView.findViewById(R.id.linerRowTextView);
        }

        public TextView getTextView() {
            return textView;
        }
    }



}
