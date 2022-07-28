package org.huyong.my.exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: huyong03
 * @Date: 2022/6/29 15:48
 * @Description:
 */
public class Suppressed {
    final static   int MAX_COPY_ATTEMPTS =  3;

    public static void main(String args[])  {
        try {
            safeCopyFile();
        } catch (IOException e){
            Throwable[] ee = e.getSuppressed();
            System.out.println(ee.length);
            e.printStackTrace();
        }
    }



    public static void firstLineOffFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(
                new FileReader("test.txt")
        )){
            System.out.print(br.readLine());
        }
    }


    public static void safeCopyFile() throws IOException {
        IOException ioException = null;
        while (true) {
            try {
                firstLineOffFile("test.txt");
                return;
            } catch (IOException e) {
                if (ioException == null) {
                    ioException = e;
                } else {
                    ioException.addSuppressed(e);
                }
                if (ioException.getSuppressed().length >= MAX_COPY_ATTEMPTS) {
                    System.out.println("Unable to copy {} to {} after " + MAX_COPY_ATTEMPTS + " attempts; skipping file");
                    throw ioException;
                }
            }
        }
    }

}
