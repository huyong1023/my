package org.huyong.my.netty.demo;

import lombok.Data;

@Data
public abstract class Packet {
    //协议版本
    private Byte version = 1;
    //获取数据类型
    public abstract Byte getCommand();
}