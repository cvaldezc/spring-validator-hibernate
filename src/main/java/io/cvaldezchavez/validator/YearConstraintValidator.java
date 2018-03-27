package io.cvaldezchavez.validator;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class YearConstraintValidator implements ConstraintValidator<Year, Date> {

	private Integer annotationYear;
	
	@Override
	public void initialize(Year year) {
		this.annotationYear = year.value();
	}

	@Override
	public boolean isValid(Date target, ConstraintValidatorContext ctx) {
		if (target == null) {
			return true;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(target);
		Integer fieldYear = c.get(Calendar.YEAR);
		return fieldYear == annotationYear;
	}

}
