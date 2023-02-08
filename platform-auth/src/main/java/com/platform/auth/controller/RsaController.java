package com.platform.auth.controller;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

/**
 * @ClassName RsaController
 * @Description 公钥接口
 * @Author hechunhui
 * @Date 2023/2/8 15:01
 * @Version 1.0
 */
@Api(tags = "公钥接口")
@RestController
@RequestMapping("/rsa")
@RequiredArgsConstructor
public class RsaController {

    private final KeyPair keyPair;

    @ApiOperation(value = "获取公钥")
    @GetMapping("/publicKey")
    public Map<String, Object> getPublicKey() {
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAKey key = new RSAKey.Builder(publicKey).build();
        return new JWKSet(key).toJSONObject();
    }

}
