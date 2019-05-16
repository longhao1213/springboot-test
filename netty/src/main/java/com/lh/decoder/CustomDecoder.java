package com.lh.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: CustomDecoder.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2019/05/09 16:17
 */
public class CustomDecoder extends ByteToMessageDecoder{
    private final static Logger logger = LoggerFactory.getLogger(CustomDecoder.class);

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() >= 4) {
            out.add(in.readInt());
        }
    }
}