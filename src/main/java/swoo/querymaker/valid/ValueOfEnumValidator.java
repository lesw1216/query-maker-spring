package swoo.querymaker.valid;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValueOfEnumValidator implements ConstraintValidator<EnumValue, String> {
    private EnumValue enumValue;

    @Override
    public void initialize(EnumValue constraintAnnotation) {
        this.enumValue = constraintAnnotation;
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = false;
        Enum<?>[] enumValues = this.enumValue.enumClass().getEnumConstants();
        if (enumValues != null && s != null) {
            for (Object enumValue : enumValues) {
                if (s.equals(enumValue.toString())
                        || this.enumValue.ignoreCase() && s.equalsIgnoreCase(enumValue.toString())) {
                    result = true;
                    break;
                }
            }
        }

        return result;
    }
}
