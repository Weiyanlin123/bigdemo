package com.city.switchdemo;

/**
 * @author weiyl
 * @date 2021/9/8 20:16
 */
public class TestSwitch {
    public static void main(String[] args) {toNumberCase(2);

    }


    public static void toNumberCase(int n) {
        String str = "";
        switch (n) {
            case 0: {
                System.out.println(str = "我是0");
            }
            case 1: {
                System.out.println(str = "我是1");
                break;
            }
            case 2: {
                System.out.println(str = "我是2");
            }
          default:{
              System.out.println(str = "hello");

          }

        }
    }

}