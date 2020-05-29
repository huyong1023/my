package org.huyong.my.dubbo.spi;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * Created by yonghu on 2020/5/29.
 */

@SPI
public interface Robot {
    void sayHello();
}
