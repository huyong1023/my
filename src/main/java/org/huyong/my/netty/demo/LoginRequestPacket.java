package org.huyong.my.netty.demo;

import lombok.Data;

import static org.huyong.my.netty.demo.Command.LOGIN_REQUEST;

//这个是登录请求数据包的Java对象，所以调用的是上面接口的登录请求指令，其他类型的数据包同理
@Data
public class LoginRequestPacket extends Packet {
    //定义用户信息
    private Integer userId;
    private String username;
    private String password;
    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}