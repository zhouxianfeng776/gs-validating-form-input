package hello.form;

import hello.valid.SaveGroup;
import hello.valid.UpdateGroup;
import hello.valid.annotation.CaseMode;
import hello.valid.annotation.CheckCase;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.groups.Default;

/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: UserGroupValidForm
 * Author:   Administrator
 * Date:     2018/11/25 11:08
 * Description: 分组校验
 */
@Data
public class UserGroupValidForm {

    @NotNull(groups = {UpdateGroup.class}, message = "用户ID不能为空")
    @Null(groups = {SaveGroup.class}, message = "不需要传入用户ID")
    private Integer id;

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank
    @CheckCase(value = CaseMode.LOWER,message = "不是小写字母")
    private String address;
}