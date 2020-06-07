package com.bs.validation;



import java.lang.annotation.ElementType;  
import java.lang.annotation.Retention;  
import java.lang.annotation.RetentionPolicy;  
import java.lang.annotation.Target;  
  
import javax.validation.Constraint;  
import javax.validation.Payload;  
  
@Constraint(validatedBy = UsernameConstraintValidator.class)  
@Target( { ElementType.METHOD, ElementType.FIELD } )  
@Retention(RetentionPolicy.RUNTIME)  
public @interface Username {  
        public String message() default "Username not available. Try again!";  
        public Class<?>[] groups() default {};  
        public Class<? extends Payload>[] payload() default {};  
}  