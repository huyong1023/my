package org.huyong.my.io;

import com.alibaba.dubbo.common.utils.StringUtils;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by yonghu on 2019/11/13.
 */
public class Test {

    public static void main(String args[]) throws IOException {
        InputStreamReader inputStream = new InputStreamReader(new FileInputStream("/Users/yonghu/Downloads/1.txt"));
        BufferedReader bufferedInputStream = new BufferedReader(inputStream) ;
        Map<String, String> initMap = new HashMap<>();

        initMap.put("总部", "199");
        initMap.put("科技产业发展集团", "201");
        initMap.put("营销一区", "202");
        initMap.put("营销七区", "203");
        initMap.put("营销三区", "204");
        initMap.put("营销二区", "205");
        initMap.put("营销五区", "206");
        initMap.put("营销八区", "207");
        initMap.put("营销六区", "208");
        initMap.put("营销四区", "209");




        Map<String, String> map = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        String line = null;
        while ((line = bufferedInputStream.readLine()) != null && StringUtils.isNotEmpty(line)) {

            String strs[] = line.split("\t");
            if (strs.length < 2){
                continue;
            }

            String res = map.get(strs[1]);
            if (StringUtils.isBlank(res)) {
                res = strs[2];

            } else {
                res += ", " + strs[2];
            }

            map2.put(strs[1], strs[0]);
            map.put(strs[1], res);
        }

        Set<String> set = map.keySet();

        for (String str : set){
            System.out.println("{" );
            System.out.println("\"citys\": [],");
            System.out.println("\"label\": \"" +  str + "\",");
            System.out.println("\"loupans\": [" + map.get(str) + "],");
            System.out.println("\"parent\":" + initMap.get(map2.get(str)) + ",");
            System.out.println("\"provinces\": []");
            System.out.println("}");

            System.out.println();
        }

    }
}
