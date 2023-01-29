package ru.tshadrin.teta.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AuthorAllowedConstraintValidator.class)
public @interface AuthorAllowed {
    String[] authors();

    /**
     * ${validatedValue} = значения указанные при заполнении клиентом
     * {authors} = значение указанные в аннтоции как допустимые
     */
    String message() default "Автор не допустим ${validatedValue}. Можно: {authors}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
