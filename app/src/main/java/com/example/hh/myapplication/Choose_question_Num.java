package com.example.hh.myapplication;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.text.Layout;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import static android.R.attr.name;

/**
 * Created by hh on 2017/4/25.
 */

public class Choose_question_Num extends AppCompatActivity {
    private EditText etNum;
    private LinearLayout llOk;
    private String Choose = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_question_num);
        etNum = (EditText) findViewById(R.id.Num);
        Bundle bundle = getIntent().getExtras();
        Choose = bundle.getString("Choose");
        llOk = (LinearLayout) findViewById(R.id.OK);
        llOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Choose_question_Num.this, QuestionAcitvity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Num_Q", etNum.getText().toString());
                bundle.putString("Choose", Choose);
                intent.putExtras(bundle);
                Choose_question_Num.this.startActivity(intent);
                Choose_question_Num.this.finish();
            }
        });
    }
}
