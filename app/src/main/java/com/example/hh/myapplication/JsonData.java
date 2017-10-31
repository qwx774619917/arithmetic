package com.example.hh.myapplication;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by hh on 2017/6/6.
 */

public class JsonData {
    private String urls;
    private int i;
    public List<Histroy> histroyslist=new ArrayList<Histroy>();
    public List<Book> bookslist = new ArrayList<Book>();
    public JsonData(String username, int num) {
        this.urls = "JsonQA?username=" + username + "&num=" + num;
        i = 0;
    }

    public JsonData(String username) {
        this.urls = "JsonHistroy?username=" + username;
        i = 1;
    }

    public void sendRequestWithOkHttp_Json() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("http://10.0.2.2:8080/webtt/servlet/" + urls)
                            .build();
                    Response response = null;
                    response = client.newCall(request).execute();
                    String responseData = response.body().string();
//                    showResponse(responseData);
//                    parseXMLWithPull(responseData);
                        parseJSONWithJSONObject(responseData);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }).start();

    }

    private void parseJSONWithJSONObject(String jsonData) {
        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray jsonArray = jsonObject.getJSONArray("hh");
            if(i==0){
                for(int j=0;j<jsonArray.length();j++){
                    JSONObject jsonObject1 = jsonArray.getJSONObject(j);
                    Book book = new Book();
                    book.setQuestion(jsonObject1.getString("question"));
                    book.setAnswer(jsonObject1.getString("answer"));
                    this.bookslist.add(book);
//                    Log.d("fwefwafewsfwe",book.getAnswer());
                }
            }
            if(i==1){
                for(int j=0;j<jsonArray.length();j++){
                    JSONObject jsonObject1 = jsonArray.getJSONObject(j);
                    Histroy histroy = new Histroy();
                    histroy.setRight_Num(jsonObject1.getString("right_num"));
                    histroy.setRight_Percent(jsonObject1.getString("percent"));
                    histroy.setTime(jsonObject1.getString("time"));
                    histroy.setTotal(jsonObject1.getString("total"));
                    this.histroyslist.add(histroy);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
