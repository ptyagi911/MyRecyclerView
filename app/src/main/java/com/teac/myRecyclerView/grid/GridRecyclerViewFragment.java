package com.teac.myRecyclerView.grid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teac.myRecyclerView.R;
import com.teac.myRecyclerView.adapters.MyAdpter;

/**
 * Created by PTyagi on 9/12/16.
 */

public class GridRecyclerViewFragment extends Fragment {

    private static final String TAG = "GridRecyclerViewFragment";
    private static final int DATA_COUNT = 50;
    private static final int SPAN_COUNT = 2;
    private String[] mData;

    private RecyclerView mRecyclerView;
    private MyAdpter mLinearAdpter;

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        initData();
    }

    private void initData() {
        //Fetch this from local DB or remote DB
        mData = new String[DATA_COUNT];
        for (int i = 0; i < DATA_COUNT; i++) {
            mData[i] = "MyData " + i;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstance) {
        View rootView = inflater.inflate(R.layout.recycler_view_frag, container, false);
        rootView.setTag(TAG);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), SPAN_COUNT));
        if (mRecyclerView.getLayoutManager() != null) {
            mRecyclerView.scrollToPosition(
                    ((LinearLayoutManager) mRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition());
        }

        mLinearAdpter = new MyAdpter(mData);
        mRecyclerView.setAdapter(mLinearAdpter);

        return rootView;
    }
}
