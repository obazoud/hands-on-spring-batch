package handson.springbatch.processor;

import handson.springbatch.model.Employee;

import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;

public class EmployeeGenderValidator implements Validator<Employee> {

	@Override
	public void validate(Employee value) throws ValidationException {
		if (value.getGender() == null) {
			throw new ValidationException("Employee gender is mandatory.");
		}

		if (!"F".equals(value.getGender()) && !"M".equals(value.getGender())) {
			throw new ValidationException("Employee gender must be F or M!");
		}
	}
}
