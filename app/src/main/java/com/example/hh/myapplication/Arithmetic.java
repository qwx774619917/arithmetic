package com.example.hh.myapplication;

import java.util.Random;

public class Arithmetic {
    int a = new Random().nextInt(4);
    int b = new Random().nextInt(10) % (10 - 1 + 1) + 1;
    int c = new Random().nextInt(10) % (10 - 2 + 1) + 2;
    int d = new Random().nextInt(10) % (10 - 1 + 1) + 1;
    int e = new Random().nextInt(10) % (10 - 2 + 1) + 2;
    int f = new Random().nextInt(100);
    int g = new Random().nextInt(100);
    String astr = "";
    String qstr = "";
    boolean x;

    public Arithmetic(boolean x) {
        this.x = x;
    }

    public String int_operation() {
        int result = 0;
        if (a == 0)
            result = f + g;
        if (a == 1)
            result = f - g;
        if (a == 2)
            result = f * g;
        astr = String.valueOf(result);
        if (a == 3) {
            if (g == 0) {
                astr = int_operation();
                return astr;
            } else {
                if (g != 0 && g != 1) {
                    int d = common_divisor(f, g);
                    f = f / d;
                    g = g / d;
                    astr = (f + "/" + g);
                }
                if (g == 1)
                    astr = ("" + f);
            }

        }
        return astr;
    }

    public String fra_operation() {
        this.b = new Random().nextInt(10) % (10 - 1 + 1) + 1;
        this.c = new Random().nextInt(10) % (10 - 2 + 1) + 2;
        this.d = new Random().nextInt(10) % (10 - 1 + 1) + 1;
        this.e = new Random().nextInt(10) % (10 - 2 + 1) + 2;
        if (c < b || e < d || c % b == 0 || e % d == 0) {
            astr = fra_operation();
            return astr;
        }

        int fz = 1, fm = c * e;
        if (a == 0)
            fz = b * e + c * d;
        if (a == 1) {
            fz = b * e - c * d;
            if (fz == 0) {
                return astr = ("0");
            }
        }

        if (a == 2)
            fz = b * d;
        if (a == 3) {
            fz = b * e;
            fm = c * d;
        }
        int f = common_divisor(fm, fz);
        if (f > 0) {
            fm = fm / f;
            fz = fz / f;
        }
        if (f < 0) {
            fm = -fm / f;
            fz = -fz / f;
        }
        astr = (fz + "/" + fm);
        return astr;

    }

    public static int common_divisor(int m, int n) {
        while (m % n != 0) {
            int t = m % n;
            m = n;
            n = t;
        }
        return n;
    }

    public String toString() {
        if (x == true) {
            if (a == 0)
                qstr = (f + "+" + g + "=");
            if (a == 1)
                qstr = (f + "-" + g + "=");
            if (a == 2)
                qstr = (f + "×" + g + "=");
            if (a == 3)
                qstr = (f + "÷" + g + "=");
        }
        if (x == false) {
            if (a == 0)
                qstr = (b + "/" + c + "+" + d + "/" + e + "=");
            if (a == 1)
                qstr = (b + "/" + c + "-" + d + "/" + e + "=");
            if (a == 2)
                qstr = (b + "/" + c + "×" + d + "/" + e + "=");
            if (a == 3)
                qstr = (b + "/" + c + "÷" + d + "/" + e + "=");
        }
        return qstr;
    }

}
