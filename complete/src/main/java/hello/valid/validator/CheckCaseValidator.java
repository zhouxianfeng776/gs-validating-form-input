package hello.valid.validator;

import hello.valid.annotation.CaseMode;
import hello.valid.annotation.CheckCase;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: CheckCaseValidator
 * Author:   Administrator
 * Date:     2018/11/25 11:49
 * Description: 自定义大小写参数验证类
 */
public class CheckCaseValidator implements ConstraintValidator<CheckCase, String> {
    public CaseMode caseMode;
    public void initialize(CheckCase checkCase) {
        this.caseMode = checkCase.value();
    }

    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return true;
        }

        if (caseMode == CaseMode.UPPER) {
            return s.equals(s.toUpperCase());
        } else {
            return s.equals(s.toLowerCase());
        }
    }
}