package org.huyong.my.memcached;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.utils.AddrUtil;

import java.io.IOException;

/**
 * Created by yonghu on 2020/6/29.
 */
public class ConnectonHelper {


    public static MemcachedClient getClient() {
        // 连接配置
        MemcachedClientBuilder memcachedClientBuilder =
                new XMemcachedClientBuilder(AddrUtil.getAddresses("192.168.84.128:2222"));
        // 创建与服务端之间的连接[ip地址，端口号，用户名和密码]
        // 获取操作业务对象
        MemcachedClient memcachedClient = null;
        try {
            memcachedClient = memcachedClientBuilder.build();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return memcachedClient;
    }

    public static void main(String[] args) throws Exception {

        // 连接配置
        // 创建与服务端之间的连接[ip地址，端口号，用户名和密码]
        // 获取操作业务对象
        MemcachedClient memcachedClient =
                new XMemcachedClient("192.168.84.128", 2222);

        // 操作业务
        String str = "Hello World!";
        boolean isSuccess = memcachedClient.set("k1", 3600, str);

        String value = memcachedClient.get("k1");

        System.out.println("value=" + value);

        // 关闭与服务端连接
        memcachedClient.shutdown();

    }

}
