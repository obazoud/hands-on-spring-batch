package handson.springbatch.processor;

import handson.springbatch.model.Employee;

import java.util.Calendar;

import junit.framework.Assert;

import org.junit.Test;

public class EmployeeBirthDateProcessorTest {

	@Test
	public void employee_is_old() throws Exception {
		Employee old = new Employee();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1940);
		old.setBirthDate(cal.getTime());
		EmployeeBirthDateItemProcessor processor = new EmployeeBirthDateItemProcessor();
		Assert.assertNull(processor.process(old));
	}

	@Test
	public void employee_is_1952() throws Exception {
		Employee old = new Employee();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1952);
		old.setBirthDate(cal.getTime());
		EmployeeBirthDateItemProcessor processor = new EmployeeBirthDateItemProcessor();
		Assert.assertNull(processor.process(old));
	}

	@Test
	public void employee_is_young() throws Exception {
		Employee young = new Employee();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1980);
		young.setBirthDate(cal.getTime());
		EmployeeBirthDateItemProcessor processor = new EmployeeBirthDateItemProcessor();
		Assert.assertNotNull(processor.process(young));
	}

}
