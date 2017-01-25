package com.ajaykv.prac.ib.arrays;

import java.util.ArrayList;

/**
 * Created by ajaykv on 1/6/17.
 */
public class PlusOne {
    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        if (a.size()== 0 || a == null) return a;
        int carry = 0;
        int tmp = a.get(a.size()-1);
        tmp++;
        if(tmp<=9){
            a.set(a.size()-1,tmp);
            carry = 0;
        }else{
            a.set(a.size()-1,tmp-10);
            carry=1;
        }
        for (int i = a.size()-2; i >= 0 ; i--) {
            tmp = a.get(i);
            tmp += carry;
            if(tmp<=9){
                a.set(i,tmp);
                carry = 0;
            }else{
                a.set(i,tmp-10);
                carry=1;
            }
        }
        if (carry == 1){
            a.add(0);
            for (int i = a.size()-2; i >= 0 ; i--) {
                a.set(i+1,a.get(i));
            }
            a.set(0,1);
        }

        int i=0;
        while(i < a.size() && a.get(i) == 0){
            if (a.get(i+1)>0 ){
                a.remove(i);
                break;
            }else {
                a.remove(i);
            }
        }
        return a;
    }
}
