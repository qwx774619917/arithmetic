package com.example.hh.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.icu.math.BigDecimal;
import android.icu.text.DecimalFormat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.os.Handler;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Histroy_list extends AppCompatActivity {
    RecyclerView mRecyclerView2;
    HistroyAdapter mAdapter2;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_histroy);
//        List<Histroy> histroys = DataSupport.findAll(Histroy.class);
        JsonData hh = new JsonData(User_login.getState());
        hh.sendRequestWithOkHttp_Json();
        mRecyclerView2 = (RecyclerView) findViewById(R.id.histroy_list);
        mAdapter2 = new HistroyAdapter(hh.histroyslist, this);
        mRecyclerView2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView2.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView2.setAdapter(mAdapter2);
        mRecyclerView2.setHasFixedSize(true);
    }
}
