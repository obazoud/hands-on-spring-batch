package handson.springbatch.processor;

import handson.springbatch.model.Employee;

import java.util.Calendar;

import org.springframework.batch.item.ItemProcessor;

public class EmployeeBirthDateItemProcessor implements
		ItemProcessor<Employee, Employee> {

	@Override
	public Employee process(Employee item) throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(item.getBirthDate());
		if (calendar.get(Calendar.YEAR) <= 1952) {
			return null;
		}
		return item;
	}
}
