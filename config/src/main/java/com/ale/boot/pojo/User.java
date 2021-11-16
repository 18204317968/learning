package com.ale.boot.pojo;

import com.ale.boot.validate.Phone;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@ApiModel
public class User {
    @ApiModelProperty("id")
    private long id;

    @ApiModelProperty("姓名")
    @NotNull(message = "姓名不能为空")
    @Length(max = 20, min = 2, message = "姓名长度不符，姓名长度需要大于2位小于20位")
    private String name;

    @ApiModelProperty("用户名")
    @NotNull(message = "用户名不能为空")
    @Length(max = 20, min = 2, message = "用户名长度不符，用户名长度需要大于2位小于20位")
    private String userName;

    @ApiModelProperty("密码")
    @NotNull(message = "密码不能为空")
    @Length(max = 20, min = 6, message = "密码长度不符，密码长度需要大于6位小于20位")
    private String password;

    @ApiModelProperty("注册日期")
    private Date createTime;

    @ApiModelProperty("手机号码")
    @NotNull(message = "手机不能为空")
    @Phone(message = "手机号码不正确，请输入正确的手机号")
    private String phoneNum;
}
