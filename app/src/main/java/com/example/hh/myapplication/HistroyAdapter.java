package com.example.hh.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class HistroyAdapter extends RecyclerView.Adapter<HistroyAdapter.ViewHolder> {

    private List<Histroy> history;
    private Context mContext;


    public HistroyAdapter(List<Histroy> history, Context mContext) {
        this.history = history;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.histroy_item, parent, false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.mNO_.setText("" + (position + 1));
        String str = history.get(position).getRight_Percent();
        str = str.substring(0, str.length() - 1);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(
                dip2px(mContext, Double.valueOf(str.toString())),
                LinearLayout.LayoutParams.FILL_PARENT
        );
        holder.Lbar.setLayoutParams(p);
        holder.mrightnum.setText(history.get(position).getRight_Num());
        holder.mtime.setText(history.get(position).getTime());
        holder.mpercent.setText("      " + history.get(position).getRight_Percent()+"%");
        holder.mtotal_num.setText(history.get(position).getTotal());


    }


    @Override
    public int getItemCount() {
        return history.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        public TextView mNO_;
        public TextView mpercent;
        public TextView mtime;
        public TextView mtotal_num;
        public TextView mrightnum;
        public LinearLayout Lbar;
        public LinearLayout Lmabar;
        public ImageView Ip;

        public ViewHolder(View v) {
            super(v);
            this.mNO_ = (TextView) v.findViewById(R.id.histroy_list_NO_);
            this.mpercent = (TextView) v.findViewById(R.id.histroy_list_percent);
            this.mtime = (TextView) v.findViewById(R.id.histroy_list_time);
            this.mtotal_num = (TextView) v.findViewById(R.id.histroy_list_total_num);
            this.mrightnum = (TextView) v.findViewById(R.id.histroy_list_rightnum);
            this.Lbar = (LinearLayout) v.findViewById(R.id.histroy_list_bar);
            this.Lmabar = (LinearLayout) v.findViewById(R.id.histroy_list_mabar);
        }
    }

    public static int dip2px(Context context, double dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }


}