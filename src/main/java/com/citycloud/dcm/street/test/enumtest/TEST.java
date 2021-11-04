package com.citycloud.dcm.street.test.enumtest;

import java.util.ArrayList;
import java.util.List;

public class TEST {

    public static void main(String[] args) {
      //  String post = HttpUtil.post("http://10.10.77.41:7002/oauth2/file/uploadByUrl?fileUrl=http%3A%2F%2F10.12.102.197%3A9333%2F33%2C01077f27b8c2&fileName=jpg", "", 5000);

//       String url="http://jxhglpt.oss-cn-hz-zt-d01-a.zt-ops.com/jxhglpt/7882BC88A439485E9B7FEE3F19B32C45.xlsx";
//        String replace = url.replace("http://jxhglpt.oss-cn-hz-zt-d01-a.zt-ops.com/jxhglpt", "/oauthImg");
//        System.out.println(replace);
//
//        String s = "简介";
//        String tt = gbEncoding(s);  //       String tt1 = "你好，我想给你说一个事情";
//        System.out.println("==============="+decodeUnicode("\\u7b80\\u4ecb"));  //
//        System.out.println(decodeUnicode(tt));

        List<Integer> integers = new ArrayList<>();
        System.out.println(integers.contains(1));
  float f=3.4f;
  short s1=1;
  s1+=s1+1;

    }

    public static String decodeUnicode(final String dataStr) {
        int start = 0;
        int end = 0;
        final StringBuffer buffer = new StringBuffer();
        while (start > -1) {
            end = dataStr.indexOf("\\u", start + 2);
            String charStr = "";
            if (end == -1) {
                charStr = dataStr.substring(start + 2, dataStr.length());
            } else {
                charStr = dataStr.substring(start + 2, end);
            }
            char letter = (char) Integer.parseInt(charStr, 16);
            // 16进制parse整形字符串。
            buffer.append(new Character(letter).toString());
            start = end;
        }
        return buffer.toString();
    }

    public static String gbEncoding(final String gbString) {
        char[] utfBytes = gbString.toCharArray();
        String unicodeBytes = "";
        for (int byteIndex = 0; byteIndex < utfBytes.length; byteIndex++) {
            String hexB = Integer.toHexString(utfBytes[byteIndex]);
            if (hexB.length() <= 2) {
                hexB = "00" + hexB;
            }
            unicodeBytes = unicodeBytes + "\\u" + hexB;
        }
        System.out.println("unicodeBytes is: " + unicodeBytes);
        return unicodeBytes;            }



}




