package hello.controller;

import hello.form.UserForm;
import hello.form.UserGroupValidForm;
import hello.valid.GroupOrder;
import hello.valid.SaveGroup;
import hello.valid.UpdateGroup;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.groups.Default;
import java.security.acl.Group;

/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ValidParamsController
 * Author:   Administrator
 * Date:     2018/11/25 9:38
 * Description: 校验参数的控制器
 */
@Validated
@RestController
public class ValidParamsController {

    @PostMapping("/login")
    public String login(@Validated @RequestBody UserForm user) {
        return "ok";
    }

    /**
     * 测试get方法的参数校验
     *
     * @param username
     * @return
     */
    @GetMapping("/getParamValid")
    public String getParamValid(
            @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_-]{3,15}$", message = "{username}") String username) {
        return username;
    }

    /**
     * 测试分组的校验
     */
    @PostMapping("/getGroupValid")
    public void getGroupValid(@Validated({SaveGroup.class }) @RequestBody UserGroupValidForm from) {

    }
    /**
     * 测试分组的校验
     * @Validated({UpdateGroup.class, Default.class}) 因为UpdateGroup未继承 Default
     */
    @PostMapping("/getGroupValid1")
    public void getGroupValid1(@Validated({UpdateGroup.class}) @RequestBody  UserGroupValidForm from) {

    }

    /**
     * UpdateGroup 里面的组对于冲突的，谁在前先校验谁
     * 可以更改@GroupSequence({UpdateGroup.class,SaveGroup.class,  Default.class})
     * 里面的组的顺序，
     * @param from
     */
    @PostMapping("/getGroupValid2")
    public void getGroupValid2(@Validated({GroupOrder.class})  @RequestBody UserGroupValidForm from  ){

    }

    @PostMapping("/testCustomerValid")
    public void testCustomerValid(@Valid @RequestBody UserGroupValidForm from  ){

    }

}