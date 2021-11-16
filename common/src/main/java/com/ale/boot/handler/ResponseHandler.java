package com.ale.boot.handler;

import com.ale.boot.response.ErrorResult;
import com.ale.boot.response.MvcResult;
import com.ale.boot.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice(basePackages = "com.ale.boot")
@Slf4j
public class ResponseHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof ErrorResult) {
            ErrorResult errorResult = (ErrorResult) body;
            return MvcResult.fail(errorResult.getErrorCode(), errorResult.getErrorMsg());
        } else if (body instanceof String) {
            return JsonUtil.object2Json(MvcResult.suc(body));
        }
        return MvcResult.suc(body);
    }
}
