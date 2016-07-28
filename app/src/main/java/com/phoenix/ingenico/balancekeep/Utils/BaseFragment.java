package com.phoenix.ingenico.balancekeep.Utils;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Base Fragment class
 * Implements Toolbar control method
 */
public class BaseFragment extends Fragment  {

    private Toolbar mtoolbar;
    private FragmentActivity mactivity;

    public Toolbar getSupportToolbar() {
        return mtoolbar;
    }

    public FragmentActivity getMyActivity() {
        return mactivity;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mactivity =  getActivity();
    }

    public static BaseFragment newInstance() {
        
        Bundle args = new Bundle();

        BaseFragment fragment = new BaseFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
