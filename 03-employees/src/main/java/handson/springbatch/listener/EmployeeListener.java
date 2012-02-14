package handson.springbatch.listener;

import handson.springbatch.model.Employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepListenerSupport;

public class EmployeeListener extends StepListenerSupport<Employee, Employee> {
	Logger logger = LoggerFactory.getLogger(EmployeeListener.class);
	StepExecution stepExecution;

	@Override
	public void onProcessError(Employee item, Exception e) {
		logger.info("OnSkipping {} : {}", item.getId(), e.getMessage());
	}

	@Override
	public void afterProcess(Employee item, Employee result) {
		if (result == null) {
			logger.info("afterProcess {} filtered: {}", item.getId(), item.getBirthDate());
		}
	}
}
