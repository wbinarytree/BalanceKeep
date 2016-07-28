package com.phoenix.ingenico.balancekeep.idle;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.phoenix.ingenico.balancekeep.Activities.AccountRecyclerAdapter;
import com.phoenix.ingenico.balancekeep.R;
import com.phoenix.ingenico.balancekeep.Utils.Account;
import com.phoenix.ingenico.balancekeep.Utils.BaseActivity;

import java.util.List;

public class MainActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private GridLayoutManager mGridlayoutManager;
    private RecyclerView.Adapter mAdapter;
    private String myDataset[] = {"APPLE", "BANANA", "ORANGE", "PEAR", "STRAWBERRY"};
    List<Account> datalist;
    int i = 0;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mGridlayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new AccountRecyclerAdapter(datalist);
        mRecyclerView.setAdapter(mAdapter);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        int position = datalist.size();
                        //datalist.add(position, "TEST" + i);
                        i++;
                        mAdapter.notifyItemInserted(position);
                        mRecyclerView.scrollToPosition(position);
                    }
                });
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            if (mRecyclerView.getLayoutManager() == mGridlayoutManager) {
                mRecyclerView.setLayoutManager(mLayoutManager);
            } else {
                mRecyclerView.setLayoutManager(mGridlayoutManager);
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
