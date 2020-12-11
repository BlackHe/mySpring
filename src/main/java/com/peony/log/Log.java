package com.peony.log;

import java.time.LocalDate;

public class Log {

    public static void info(String info,String... strings){
        if (strings == null || strings.length == 0){
            System.out.println(info);
            return;
        }
        System.out.printf(info + "\n",strings);
    }

    public static void main(String[] args) {
        Log.info("今年是【%s】年", LocalDate.now().getYear()+"");
    }
}
