package com.phoenix.ingenico.balancekeep.Activities;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.phoenix.ingenico.balancekeep.Utils.Account;
import com.phoenix.ingenico.balancekeep.R;

import java.util.List;

/**
 * Created by yawang on 04/07/2016.
 */
public class AccountRecyclerAdapter extends RecyclerView.Adapter<AccountRecyclerAdapter.ViewHolder> {
    private List<Account> mAccountData;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ImageView mImageView;

        public ViewHolder(View v) {
            super(v);
            this.mTextView = (TextView) v.findViewById(R.id.tv_card);
            this.mImageView = (ImageView) v.findViewById(R.id.image_card);
        }
    }



    // Provide a suitable constructor (depends on the kind of dataset)
    public AccountRecyclerAdapter(List<Account> myDataset) {
        mAccountData = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AccountRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_account, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mAccountData.get(position).getName());
        holder.mImageView.setImageResource(mAccountData.get(position).getImg());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mAccountData.size();
    }
}
