package handson.springbatch.processor;

import handson.springbatch.model.Employee;

import org.junit.Test;
import org.springframework.batch.item.validator.ValidationException;

public class EmployeeGenderValidatorTest {

	@Test(expected = ValidationException.class)
	public void employee_is_null() {
		Employee alien = new Employee();
		EmployeeGenderValidator validator = new EmployeeGenderValidator();
		validator.validate(alien);
	}

	@Test
	public void employee_is_men() {
		Employee men = new Employee();
		men.setGender("M");
		EmployeeGenderValidator validator = new EmployeeGenderValidator();
		validator.validate(men);
	}

	@Test
	public void employee_is_women() {
		Employee women = new Employee();
		women.setGender("F");
		EmployeeGenderValidator validator = new EmployeeGenderValidator();
		validator.validate(women);
	}

}
