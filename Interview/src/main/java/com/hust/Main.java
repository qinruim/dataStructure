package com.hust;

import java.io.File;

public class Main {
    public static void main(String[] args) {
//        System.out.println("hello world!");
        String pyScriptPath = "/home/qrpop/Documents/cky/baquhe/backend20220914/baquhe-backend/src/main/resources/pyScript.submerge";

        String pyParam = "python "+pyScriptPath+"submerge"+ File.separator+"interplolate.py "+pyScriptPath+"submerge"+File.separator+" "+"type";
        System.out.println(pyParam);


    }




}
