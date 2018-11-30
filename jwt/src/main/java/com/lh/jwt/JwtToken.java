package com.lh.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: JwtToken.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2018/08/09 17:18
 */
public class JwtToken {
    private final static Logger logger = LoggerFactory.getLogger(JwtToken.class);

    @Value("${secret}")
    private String secrty;

    public String createToken() throws UnsupportedEncodingException {
        // 签发时间
        Date iatDate = new Date();

        // 过期时间 1分钟
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, 1);
        Date expiresDate = nowTime.getTime();

        Map<String, Object> map = new HashMap();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String token = JWT.create()
                .withHeader(map)
                .withClaim("age", "longhao")
                .withClaim("age", "20")
                .withClaim("org", "日报")
                .withExpiresAt(expiresDate)
                .sign(Algorithm.HMAC256(secrty));
        return token;
    }

    public Map<String, Claim> verifyToken(String token) throws UnsupportedEncodingException {
        JWTVerifier require = JWT.require(Algorithm.HMAC256(secrty))
                .build();
        DecodedJWT jwt = null ;
        try {
            jwt = require.verify(token);
        } catch (Exception e) {
            throw new RuntimeException("登录凭证已过期,请重新登录");
        }
        return jwt.getClaims();
    }

}