package com.example.hh.myapplication;

import org.litepal.crud.DataSupport;

/**
 * Created by hh on 2017/5/1.
 */

public class Histroy extends DataSupport {
    private String Time;
    private String Right_Num;
    private String Right_Percent;
    private String Total;
    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getRight_Num() {
        return Right_Num;
    }

    public void setRight_Num(String right_Num) {
        Right_Num = right_Num;
    }

    public String getRight_Percent() {
        return Right_Percent;
    }

    public void setRight_Percent(String right_Percent) {
        Right_Percent = right_Percent;
    }


}
