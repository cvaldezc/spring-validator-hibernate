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
		int fieldYear = c.get(Calendar.YEAR);
		System.out.println(fieldYear + " "+ annotationYear);
		System.out.println(fieldYear == annotationYear);
		return fieldYear == annotationYear;
	}

}
