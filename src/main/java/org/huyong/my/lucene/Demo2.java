package org.huyong.my.lucene;

/**
 * 查询索引测试
 * @author Administrator
 *
 */
public class Demo2 {
    public static void main(String[] args) {
        String indexDir = "/Users/yonghu/Downloads/lucene/demo1";
        String q = "系";
        try {
            IndexUse.search(indexDir, q);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}