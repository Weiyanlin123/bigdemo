package com.city.file;

import java.io.File;

/**
 * @author weiyl
 * @date 2021/9/8 17:33
 */
public class TestFile {
    public static void main(String[] args) {
        File aaaaaa = new File("mihao");
        aaaaaa.mkdir();
        System.out.println(aaaaaa.getAbsolutePath());
    }
}
