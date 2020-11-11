package com.scxm.tcsf.controller;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;

import java.io.File;

public class test {
    public static void main(String[] args) {
        String sbbh="111";
        File file = FileUtil.file("d:/"+sbbh+".jpg");
        String url="http://localhost:8001/pay/111";
        QrCodeUtil.generate(url, 300, 300, file);
        //String ewm = Base64.encode(file);
        //System.out.println(ewm);
        //QrCodeUtil.generate("http://localhost:8001/pay/12342324", 300, 300, FileUtil.file("d:/qrcode.jpg"));

    }
}
