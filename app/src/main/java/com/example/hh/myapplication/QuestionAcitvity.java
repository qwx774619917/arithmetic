package com.example.hh.myapplication;

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

import static com.example.hh.myapplication.Timer.handler;

//import static com.example.hh.myapplication.Timer.handler;

public class QuestionAcitvity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    MyAdapter mAdapter;


    public double rightNum = 0;
    public double right_percent;
    public static TextView tvTimer;
    private String Num;
    private String Choose;
    private String User;
    private int iNum = 0;
    private int iChoose;
    private LinearLayout llfinish;


    public static final Timer update_thread = new Timer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_print);

        llfinish = (LinearLayout) findViewById(R.id.fin);



        Bundle bundle = getIntent().getExtras();
        Choose = bundle.getString("Choose");
        Num = bundle.getString("Num_Q");
        User = User_login.getState();
        iNum = Integer.parseInt(Num);
        iChoose = Integer.parseInt(Choose);
        final QA_List List = new QA_List(iNum, iChoose);
        final String[] mDataSet = new String[iNum];
        for (int i = 0; i <= iNum - 1; i++) {
            mDataSet[i] = "";

        }
        llfinish = (LinearLayout) findViewById(R.id.fin);


        tvTimer = (TextView) findViewById(R.id.timer);
        tvTimer.setText("00:00.0");
        handler.post(update_thread);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_main);
        mAdapter = new MyAdapter(mDataSet, List.Qusetion, List.Answer, QuestionAcitvity.this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        llfinish.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                handler.removeCallbacks(update_thread);
                for (int i = 0; i < iNum; i++) {
                    if (mDataSet[i].equals(List.Answer.get(i))) {
                        mAdapter.r_w.add(1);
                        rightNum++;
                    } else {
                        mAdapter.r_w.add(0);
                        Book book = new Book();
                        book.setAnswer(List.Answer.get(i));
                        book.setQuestion(List.Qusetion.get(i));
                        book.save();
                        if (iChoose == 1) {
                            book.delete();
                        }
                    }
                }
                mAdapter.notifyDataSetChanged();
                right_percent = rightNum / iNum * 100;
//                Book book = DataSupport.find(Book.class, 49);
                //DataSupport.deleteAll(Book.class);
                //             tvTimer.setText(List.set.size()+"");
//                DataSupport.delete(Book.class, 118);
//                DataSupport.deleteAll(Book.class);
                String result = String.format("%.2f", right_percent);
                Histroy histroy = new Histroy();
                histroy.setTime(tvTimer.getText().toString());
                histroy.setTotal("" + iNum);
                histroy.setRight_Num("" + (int) rightNum);
                histroy.setRight_Percent(result + "%");
                histroy.save();
                new AlertDialog.Builder(QuestionAcitvity.this)
                        .setTitle("成绩单")
                        .setMessage("耗时：" + tvTimer.getText() + "s" + "\n" + "\n总题数：" + iNum + "\n" + "\n正确题数：" + (int) rightNum + "\n" + "\n正确率：" + result + "%")
                        .setPositiveButton("继续", null)
                        .show();
                Usermessage_upload hh = new Usermessage_upload(QuestionAcitvity.this, User, List.Qusetion, List.Answer, tvTimer.getText().toString(), iNum, (int) rightNum, result);
                //hh.test();
                hh.printXml();
                hh.postAsynFile();
//                try {
//                    hh.testSendXML();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
            }
        });

    }

    public void onBackPressed() {
        handler.removeCallbacks(update_thread);
        tvTimer.setText("00:00.0");
        QuestionAcitvity.this.finish();
        update_thread.Time = 0;
        update_thread.Time_minute = 0;

        return;
    }
}