package com.ale.boot.response;

import com.ale.boot.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Throwables;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorResult extends MvcResult {
    /**
     * 错误码
     */
    private Integer errorCode;
    /**
     * 错误信息
     */
    private String errorMsg;
    /**
     * 错误名称
     */
    private String exception;
    /**
     * 错误名称
     */
    private String trace;

    public static ErrorResult fail(ResultCode resultCode, Throwable t, String msg) {
        ErrorResult result = ErrorResult.fail(resultCode, t);
        if (StringUtils.isNotBlank(msg)) {
            result.setErrorMsg(msg);
        }
        return result;
    }

    public static ErrorResult fail(ResultCode resultCode, Throwable t) {
        ErrorResult result = new ErrorResult();
        result.setErrorMsg(resultCode.msg());
        result.setErrorCode(resultCode.code());
        result.setException(t.getClass().getName());
        result.setTrace(Throwables.getStackTrace(t));
        return result;
    }
}
