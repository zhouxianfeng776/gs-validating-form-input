package hello.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: UserForm
 * Author:   Administrator
 * Date:     2018/11/25 9:34
 * Description: 正常参数校验
 */
@Data
public class UserForm {
    @NotBlank(message = "用户名不能为null,长度必须大于0")
    String name;   //用户名

    @NotNull(message = "年龄不能为空")
    @Min(value = 1, message = "最小年龄为1岁")
    @Max(value = 120, message = "最大年龄为120岁")
    Integer age;  //年龄

    @Email(message = "邮箱格式错误")
    @NotBlank(message = "邮箱格式错误")
    String email;  //邮箱

    @NotBlank(message = "密码不能为空")
    @Length(min = 6, max = 12, message = "密码长度必须在6位到12位之间")
    String pwd;//密码
}