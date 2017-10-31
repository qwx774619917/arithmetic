package com.example.hh.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    int[] image = {
            R.drawable.error_symbol,
            R.drawable.right_symbol
    };
    public static List<Integer> r_w = new ArrayList<Integer>();
    private String[] mDataset;
    private List<String> question;
    private List<String> r_answer;
    private Context mContext;


    public MyAdapter(String[] myDataset, List<String> question, List<String> r_answer, Context mContext) {
        mDataset = myDataset;
        this.question = question;
        this.r_answer = r_answer;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_main_item, parent, false);

        ViewHolder vh = new ViewHolder(v, new MyCustomEditTextListener());

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.myCustomEditTextListener.updatePosition(holder.getAdapterPosition());
        holder.mEditText.setText(mDataset[holder.getAdapterPosition()]);
        holder.mQuestion.setText(question.get(position));

        if (r_w.size() == mDataset.length) {
            holder.R_W.setImageResource(image[r_w.get(position)]);
            holder.mR_answer.setText(r_answer.get(position));
        }

    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public EditText mEditText;
        public MyCustomEditTextListener myCustomEditTextListener;
        public TextView mQuestion;
        public TextView mR_answer;
        public ImageView R_W;

        public ViewHolder(View v, MyCustomEditTextListener myCustomEditTextListener) {
            super(v);
            this.R_W = (ImageView) v.findViewById(R.id.RW);
            this.mQuestion = (TextView) v.findViewById(R.id.rv_main_item_question);
            this.mEditText = (EditText) v.findViewById(R.id.rv_main_item_answer);
            this.mR_answer = (TextView) v.findViewById(R.id.rv_main_item_Right);
            this.myCustomEditTextListener = myCustomEditTextListener;
            this.mEditText.addTextChangedListener(myCustomEditTextListener);
        }
    }


    private class MyCustomEditTextListener implements TextWatcher {
        private int position;

        public void updatePosition(int position) {
            this.position = position;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            // no op
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            mDataset[position] = charSequence.toString();
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }
    }

}