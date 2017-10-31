package com.example.hh.myapplication;

/**
 * Created by hh on 2017/4/27.
 */

import android.os.Handler;

import java.util.TimerTask;

import static com.example.hh.myapplication.QuestionAcitvity.tvTimer;

public class Timer implements Runnable {

    public static final Handler handler = new Handler();
    public static double Time = 0;
    public static int Time_minute = 0;

    @Override
    public void run() {
        Time++;
        if (Time_minute == 0) {
            if (Time < 100) {
                tvTimer.setText("00:0" + Time / 10);
            } else
                tvTimer.setText("00:" + Time / 10);
            if (Time == 600) {
                Time_minute++;
                Time = 0;
            }
        }
        if (Time_minute > 0 && Time_minute < 10) {
            if (Time < 100) {
                tvTimer.setText("0" + Time_minute + ":0" + Time / 10);
            } else
                tvTimer.setText("0" + Time_minute + ":" + Time / 10);
            if (Time == 600) {
                Time_minute++;
                Time = 0;
            }
        }
        if (Time_minute < 60 && Time_minute >= 10) {
            if (Time < 100) {
                tvTimer.setText(Time_minute + ":0" + Time / 10);
            } else
                tvTimer.setText(Time_minute + ":" + Time / 10);
            if (Time == 600) {
                Time_minute++;
                Time = 0;
            }
        }
        if (Time_minute == 60) {
            tvTimer.setText("别做了，洗洗睡吧");
        }
        handler.postDelayed(QuestionAcitvity.update_thread, 100);
    }

}
