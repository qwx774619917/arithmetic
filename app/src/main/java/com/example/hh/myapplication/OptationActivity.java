package com.example.hh.myapplication;

import android.content.Intent;
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


public class OptationActivity extends AppCompatActivity {
    private LinearLayout Lquestion;
    private LinearLayout Lreview;
    private LinearLayout Lcheck;
    private LinearLayout Lquit;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.optation);

        Lquestion = (LinearLayout) findViewById(R.id.question);
        Lreview = (LinearLayout) findViewById(R.id.review);
        Lcheck = (LinearLayout) findViewById(R.id.check);
        Lquit = (LinearLayout) findViewById(R.id.quit);

        Lquestion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(OptationActivity.this, Choose_question_Num.class);
                Bundle bundle = new Bundle();
                bundle.putString("Choose", "0");
                intent.putExtras(bundle);
                OptationActivity.this.startActivity(intent);
            }
        });
        Lreview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(OptationActivity.this, Choose_question_Num.class);
                Bundle bundle = new Bundle();
                bundle.putString("Choose", "1");
                intent.putExtras(bundle);
                OptationActivity.this.startActivity(intent);
            }
        });
        Lcheck.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(OptationActivity.this, Histroy_list.class);
                OptationActivity.this.startActivity(intent);
            }
        });
        Lquit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(OptationActivity.this, MainActivity.class);
                OptationActivity.this.startActivity(intent);
                OptationActivity.this.finish();
            }
        });
    }
}
