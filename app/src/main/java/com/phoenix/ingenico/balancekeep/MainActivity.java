package com.phoenix.ingenico.balancekeep;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private GridLayoutManager mGridlayoutManager;
    private RecyclerView.Adapter mAdapter;
    private String myDataset[] = {"APPLE","BANANA","ORANGE","PEAR","STRAWBERRY"};
    List<String> datalist = new ArrayList(Arrays.asList(myDataset));
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mGridlayoutManager = new GridLayoutManager(this,2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyAdapter(datalist);
        mRecyclerView.setAdapter(mAdapter);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        int position = datalist.size();
                        datalist.add(position,"TEST" + i);
                        i++;
                        mAdapter.notifyItemInserted(position);
                        mRecyclerView.scrollToPosition(position);
                    }
                });
            }
        });
    }
}
