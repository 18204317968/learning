package com.ale.boot.response;

import com.ale.boot.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MvcResult<T> {
    private Boolean success = Boolean.FALSE;
    private String msg;
    private int code;
    private T data;

    public static MvcResult suc() {
        MvcResult result = new MvcResult();
        result.setCode(200);
        result.setMsg("SUCCESS");
        result.setSuccess(Boolean.TRUE);
        return result;
    }

    public static MvcResult suc(Object data) {
        MvcResult result = suc();
        result.setData(data);
        return result;
    }

    public static MvcResult fail(Integer code, String msg) {
        MvcResult result = new MvcResult();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static MvcResult fail(ResultCode resultCode) {
        MvcResult result = new MvcResult();
        result.setResultCode(resultCode);
        return result;
    }

    /**
     * 把ResultCode枚举转换为ResResult
     */
    private void setResultCode(ResultCode resultCode) {
        this.code = resultCode.code();
        this.msg = resultCode.msg();
    }
}
