package org.huyong.my.netty.codec;

import java.io.Serializable;

public abstract class Message implements Serializable {

    public abstract int getMessageType();

    public static final int LoginRequestMessage = 0;

}