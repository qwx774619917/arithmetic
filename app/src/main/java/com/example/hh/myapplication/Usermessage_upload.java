package com.example.hh.myapplication;

import android.content.Context;
import android.util.Log;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import okhttp3.Call;

import okhttp3.Callback;
import okhttp3.MediaType;



/**
 * Created by hh on 2017/5/24.
 */

public class Usermessage_upload {
    private Context context;
    private String username;
    private String time;
    private int total;
    private int right;
    private String percent;
    private List<String> question;
    private List<String> answer;
    public static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("application/octet-streasm");
    public Usermessage_upload(Context conext, String username, List<String> qusetion,List<String> answer,String time,int total,int right,String percent){
        this.context = conext;
        this.username = username;
        this.question = qusetion;
        this.answer = answer;
        this.time = time;
        this.total = total;
        this.right = right;
        this.percent = percent;
    }
//    OkHttpClient client = new OkHttpClient();
//    String post(String url, String json) throws IOException {
//        RequestBody body = RequestBody.create(JSON, json);
//        Request request = new Request.Builder()
//                .url(url)
//                .post(body)
//                .build();
//        Response response = client.newCall(request).execute();
//        if (response.isSuccessful()){
//        return response.body().string();
//        } else {
//        throw new IOException("Unexpected code " + response);
//        }
//    }
    public void printXml() {
//        File f = new File(context.getFilesDir(),"server.xml"); // 输入要删除的文件位置
//        if(f.exists())
//        f.delete();
        Element root = new Element(username);
        Document Doc = new Document(root);
        for(int i=0;i<question.size();i++)
        {
            Element elements = new Element("QA");
            elements.addContent(new Element("question").setText(question.get(i)));
            elements.addContent(new Element("answer").setText(answer.get(i)));
            root.addContent(elements);
        }
        Element element = new Element("result");
        element.addContent(new Element("username").setText(username));
        element.addContent(new Element("time").setText(time));
        element.addContent(new Element("total").setText(""+total));
        element.addContent(new Element("right").setText(""+right));
        element.addContent(new Element("percent").setText(percent));
        root.addContent(element);


        XMLOutputter XMLOut = new XMLOutputter();
        try {
            FileOutputStream out = context.openFileOutput("server.xml", Context.MODE_PRIVATE);
            XMLOut.output(Doc, out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void postAsynFile() {
        OkHttpClient mOkHttpClient=new OkHttpClient();
        File file = new File(context.getFilesDir(),"server.xml");
        Request request = new Request.Builder()
                .url("http://10.0.2.2:8080/webtt/servlet/QA_upload")
                .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, file))
                .build();

//        File file = new File(context.getFilesDir(),"server.xml");
//        MultipartBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
//                .addFormDataPart("username","yy")
//                .addFormDataPart("password","zz0114yhbb")
//                .addFormDataPart("mPhoto","server.xml",RequestBody.create(MediaType.parse("application/octet-stream"),file))
//                .build();
//        Request request = new Request.Builder()
//                .url("http://10.0.2.2:8080/webtt/servlet/QA_upload")
//                .post(body)
//                .build();

        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("wangshu",response.body().string());
            }
        });
    }

}
