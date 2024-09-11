package com.rpc;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x=in.nextInt(),y=in.nextInt();
        x++;y++;
        int a=Math.max(x,y);
        int b=Math.min(x,y);
        double xl=(double) a/b;
        double count=0;
        count=xl*b;
        String s=""+count;
        String[] split = s.split(".");
        int res=Integer.parseInt(split[0]);
        System.out.println(res);
    }
}