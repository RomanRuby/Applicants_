package cushing.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<Username, String> {

    public void initialize(Username constraintAnnotation) {
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ("admin".equalsIgnoreCase(value)) {
            return false;
        }
        return true;
    }

}