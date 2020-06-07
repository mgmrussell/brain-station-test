package com.bs.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;  
 

public class UsernameConstraintValidator implements ConstraintValidator<Username,String> {  
  
	
	
	//private UserRepository userData;
	//@TODO: Not for production needs to be implemented for
    public boolean isValid(String s, ConstraintValidatorContext cvc) {
    	return true;
    }

	@Override
	public void initialize(Username constraintAnnotation) {

		
	}
	  
}