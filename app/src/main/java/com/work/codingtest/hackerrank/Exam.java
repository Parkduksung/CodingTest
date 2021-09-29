package com.work.codingtest.hackerrank;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Exam {


    public final int game369ToJava(int num) {
        int result = 0;
        int i = 1;

        while (true) {
            result += checkContain369ToJava(i);
            if (i == num) {
                break;
            }
            ++i;
        }
        return result;
    }


    public final int checkContain369ToJava(int num) {
        int containCount = 0;

        String toStringNum = String.valueOf(num);
        ArrayList<Integer> stringArrayList = new ArrayList<>(toStringNum.length());

        for (int i = 0; i < toStringNum.length(); i++) {
            stringArrayList.add(Integer.getInteger(String.valueOf(toStringNum.indexOf(i))));
        }

        for (int item : stringArrayList) {
            if (item == 3 || item == 6 || item == 9) {
                ++containCount;
            }
        }
        return containCount;
    }
}
