package validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BeginWithUValidator implements ConstraintValidator<BeginWithU, String> {

	public boolean isValid(String value, ConstraintValidatorContext arg1) {
		if (value.indexOf('U') == 0)
			return true;

		return false;
	}

	public void initialize(BeginWithU anno) {

	}

}
