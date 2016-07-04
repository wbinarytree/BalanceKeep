package com.phoenix.ingenico.balancekeep;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private GridLayoutManager mGridlayoutManager;
    private RecyclerView.Adapter mAdapter;
    private String myDataset[] = {"APPLE","BANANA","ORANGE","PEAR","STRAWBERRY"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mGridlayoutManager = new GridLayoutManager(this,2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mRecyclerView.setLayoutManager(mGridlayoutManager);
                    }
                });
            }
        });
    }
}
