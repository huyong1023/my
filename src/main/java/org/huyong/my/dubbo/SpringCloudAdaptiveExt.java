package org.huyong.my.dubbo;

import com.alibaba.dubbo.common.URL;

/**
 * Created by yonghu on 2020/5/29.
 */
public class SpringCloudAdaptiveExt implements AdaptiveExt {
    @Override
    public String echo(String msg, URL url) {
        return "spring cloud";
    }
}
