package com.ale.boot.handler;

import com.ale.boot.enums.ResultCode;
import com.ale.boot.response.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ErrorResult handleThrowable(Throwable t, HttpServletRequest request) {
        ErrorResult result = ErrorResult.fail(ResultCode.SYS_ERROR, t);
        log.error("URL:{},系统异常", request.getRequestURI(), t);
        return result;
    }

    /**
     * validator 统一异常封装
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        String msgs = this.handle(e.getBindingResult().getFieldErrors());
        ErrorResult error = ErrorResult.fail(ResultCode.PARAM_IS_INVALID, e, msgs);
        log.warn("URL:{} ,参数校验异常:{}", request.getRequestURI(), msgs);
        return error;
    }

    private String handle(List<FieldError> fieldErrors) {
        StringBuilder sb = new StringBuilder();
        for (FieldError obj : fieldErrors) {
            sb.append(obj.getField());
            sb.append("=[");
            sb.append(obj.getDefaultMessage());
            sb.append("]  ");
        }
        return sb.toString();
    }

    /**
     * Assert的异常统一封装
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResult illegalArgumentException(IllegalArgumentException e, HttpServletRequest request) {
        ErrorResult error = ErrorResult.builder().errorCode(4000)
                .errorMsg(e.getMessage())
                .exception(e.getClass().getName())
                .build();
        log.warn("URL:{} ,业务校验异常:{}", request.getRequestURI(), e);
        return error;
    }
}
