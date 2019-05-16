package com.lh.encoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: CustomEncoder.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2019/05/09 16:57
 */
public class CustomEncoder extends MessageToByteEncoder<Integer>{
    private final static Logger logger = LoggerFactory.getLogger(CustomEncoder.class);

    @Override
    protected void encode(ChannelHandlerContext ctx, Integer msg, ByteBuf out) throws Exception {
        ctx.write(msg);
    }
}