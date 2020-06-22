package org.huyong.my.dubbo;

import com.alibaba.dubbo.common.URL;
import org.huyong.my.dubbo.AdaptiveExt;

/**
 * Created by yonghu on 2020/5/29.
 */
public class AdaptiveExtWrapper implements AdaptiveExt {
    private AdaptiveExt adaptiveExt;

    // 实现一个Wrapper类的关键就是提供一个带类似参数的构造函数,后面代码会分析
    public AdaptiveExtWrapper(AdaptiveExt adaptiveExt) {
        this.adaptiveExt = adaptiveExt;
    }

    @Override
    public String echo(String msg, URL url) {
        // do something,实现了AOP
        System.out.println("before");

        adaptiveExt.echo(msg, url);

        System.out.println("after");
        // do something
        return "wrapper";
    }
}
