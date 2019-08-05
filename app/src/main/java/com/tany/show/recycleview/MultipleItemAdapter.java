package com.tany.show.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tany.show.R;

import java.util.ArrayList;
import java.util.List;

public class MultipleItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private ArrayList<String> mTitles;

    public MultipleItemAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mTitles = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == MultipleItemAdapter.ITEM_TYPE.ITEM_TYPE_IMAGE.ordinal()) {
            return new MultipleItemAdapter.ImageViewHolder(mLayoutInflater.inflate(R.layout.item_image, parent, false));
        } else {
            return new MultipleItemAdapter.TextViewHolder(mLayoutInflater.inflate(R.layout.item_text, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MultipleItemAdapter.TextViewHolder) {
            ((MultipleItemAdapter.TextViewHolder) holder).mTextView.setText(mTitles.get(position));
        } else if (holder instanceof MultipleItemAdapter.ImageViewHolder) {
            ((MultipleItemAdapter.ImageViewHolder) holder).mTextView.setText(mTitles.get(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2 == 0 ? MultipleItemAdapter.ITEM_TYPE.ITEM_TYPE_IMAGE.ordinal() : MultipleItemAdapter.ITEM_TYPE.ITEM_TYPE_TEXT.ordinal();
    }

    @Override
    public int getItemCount() {
        if (mTitles == null) return 0;
        else return mTitles.size();
    }

    public void addAll(List<String> list) {
        if (mTitles != null) {
            mTitles.clear();
        } else {
            mTitles = new ArrayList<>();
        }
        mTitles.addAll(list);
    }

    public enum ITEM_TYPE {
        ITEM_TYPE_IMAGE,
        ITEM_TYPE_TEXT
    }

    public static class TextViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        TextViewHolder(View view) {
            super(view);
        }
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        ImageView mImageView;

        ImageViewHolder(View view) {
            super(view);
        }
    }
}
