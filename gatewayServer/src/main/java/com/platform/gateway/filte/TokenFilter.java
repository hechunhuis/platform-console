//package com.platform.gateway.filte;
//
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.nacos.common.utils.StringUtils;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.core.io.buffer.DataBuffer;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.security.jwt.Jwt;
//import org.springframework.security.jwt.JwtHelper;
//import org.springframework.security.jwt.crypto.sign.MacSigner;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//import java.io.IOException;
//import java.net.URI;
//import java.nio.charset.StandardCharsets;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
//
//import static org.springframework.web.reactive.socket.CloseStatus.SERVER_ERROR;
//
///**
// * @author : tomato<hechunhui_email@163.com>
// * @date : 2022/11/15 8:06
// * @className : TokenFilter
// * @description: TODO
// */
//@Component
//@Slf4j
//public class TokenFilter implements GlobalFilter, Ordered {
//    private static final String SIGNING_KEY = "auth123456";
//
//    private static final String BEAR_HEADER = "Bearer ";
//
//    List<String> ignoreList = Arrays.asList(
//            "/sso/oauth/token",
//            "/sso/oauth/check_token",
//            "/sso/oauth/refresh_token");
//
//    /**
//     * 该值要和auth-server中配置的签名相同
//     * <p>
//     * com.kdyzm.spring.security.auth.center.config.TokenConfig#SIGNING_KEY
//     */
//    private ObjectMapper objectMapper = new ObjectMapper();
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        ServerHttpRequest serverHttpRequest = exchange.getRequest();
//
//        // 将Payload数据放到header
//        ServerHttpRequest.Builder builder = serverHttpRequest.mutate();
//        // 权限校验
//        URI uri = exchange.getRequest().getURI();
//        // 忽略URI
//        String resUri = uri.getPath();
//        if(!ignoreList.contains(resUri)){
//
//            String token = serverHttpRequest.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
//            // 如果没有token,则直接返回401
//            if (StringUtils.isEmpty(token)) {
//                return unAuthorized(exchange,"未认证的请求；未携带认证token",null);
//            }
//
//            // 验证并获取PayLoad
//            String payLoad;
//            try {
////                Jwt jwt = JwtHelper.decodeAndVerify(token.replace(BEAR_HEADER, ""), new MacSigner(SIGNING_KEY));
////                payLoad = jwt.getClaims();
//            } catch (Exception e) {
//                return unAuthorized(exchange,"未认证的请求；无效的token",null);
//            }
//            try {
//                // 取出exp字段，判断token是否已经过期
//                Map<String, Object> map = objectMapper.readValue(payLoad, new TypeReference<Map<String, Object>>() {});
//                long expiration = ((Integer) map.get("exp")) * 1000L;
//                if (expiration < System.currentTimeMillis()) {
//                    return unAuthorized(exchange,"token已过期",401);
//                }
//
//
//            } catch (IOException e) {
//                return unAuthorized(exchange,"未认证的请求；错误的token",null);
//            }
//
//            builder.header("token-info", Base64.encode(payLoad.getBytes(StandardCharsets.UTF_8))).build();
//        }
//        // 继续执行
//        return chain.filter(exchange.mutate().request(builder.build()).build());
//    }
//    /**
//     * 封装返回数据
//     */
//    private Mono<Void> unAuthorized(ServerWebExchange exchange, String msg,Integer status) {
//        try {
//            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//            //这里需要指定响应头部信息，否则会中文乱码
//            exchange.getResponse().getHeaders().add("Content-Type", "application/json;charset=UTF-8");
//            JSONObject ret=new JSONObject();
//            if(Objects.isNull(status)) {
//                ret.put("status", SERVER_ERROR);
//                ret.put("info", msg);
//            }else{
//                ret.put("status", status);
//                ret.put("info", msg);
//            }
//            String s = objectMapper.writeValueAsString(ret);
//            DataBuffer buffer = exchange
//                    .getResponse()
//                    .bufferFactory()
//                    .wrap(s.getBytes(StandardCharsets.UTF_8));
//            return exchange.getResponse().writeWith(Flux.just(buffer));
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    /**
//     * 将该过滤器的优先级设置为最高，因为只要认证不通过，就不能做任何事情
//     *
//     * @return
//     */
//    @Override
//    public int getOrder() {
//        return Ordered.HIGHEST_PRECEDENCE;
//    }
//}