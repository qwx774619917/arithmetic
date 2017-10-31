package com.example.hh.myapplication;

import android.util.Log;

import org.litepal.crud.DataSupport;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class QA_List {

    public static List<String> Qusetion = new ArrayList<String>();
    public static List<String> Answer = new ArrayList<String>();

    public QA_List(int i, int j) {
        if (j == 0)
            for (int a = 0; a < i; a++) {
                boolean x = new Random().nextBoolean();
                Arithmetic hh = new Arithmetic(x);
                String int_str = hh.int_operation();
                String fra_str = hh.fra_operation();
                if (x == true) {
                    Answer.add(int_str);
                    Qusetion.add(hh.toString());
                }

                if (x == false) {
                    Answer.add(fra_str);
                    Qusetion.add(hh.toString());
                }
            }
        if (j == 1) {
            JsonData hh = new JsonData(User_login.getState(),i);
            hh.sendRequestWithOkHttp_Json();
            Log.d("fdsfesfwa",hh.bookslist.get(0).getAnswer());
            for(int k=0;k<hh.bookslist.size();k++){
                Answer.add(hh.bookslist.get(k).getAnswer());
                Qusetion.add(hh.bookslist.get(k).getQuestion());

            }

//            List<Book> books = DataSupport.findAll(Book.class);
//            int[] result = randomCommon(0, DataSupport.count(Book.class) + 1, i);
//            for (int a : result) {
//                Book book = books.get(a - 1);
//                Answer.add(book.getAnswer());
//                Qusetion.add(book.getQuestion());
            }
        }


    }

//    public static int[] randomCommon(int min, int max, int n) {
//        if (n > (max - min + 1) || max < min) {
//            return null;
//        }
//        int[] result = new int[n];
//        int count = 0;
//        while (count < n) {
//            int num = (int) (Math.random() * (max - min)) + min;
//            boolean flag = true;
//            for (int j = 0; j < n; j++) {
//                if (num == result[j]) {
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag) {
//                result[count] = num;
//                count++;
//            }
//        }
//        return result;
//    }
//
//
//}
