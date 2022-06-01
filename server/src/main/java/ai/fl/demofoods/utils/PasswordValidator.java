package ai.fl.demofoods.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * created by Baxromjon
 * 04.02.2022
 **/



public class PasswordValidator implements ConstraintValidator<ValidPassword, Object> {

    private String password;
    private String prePassword;

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
        password = constraintAnnotation.password();
        prePassword=constraintAnnotation.prePassword();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return password!=null&&password.equals(prePassword);
    }
}
