package com.citycloud.dcm.street.test.enumtest;

public enum Color {
   AAA ("","","");

   private String name;
   private String age;
   private String ad;

   Color(String name, String age, String ad) {
      this.name = name;
      this.age = age;
      this.ad = ad;
   }
}