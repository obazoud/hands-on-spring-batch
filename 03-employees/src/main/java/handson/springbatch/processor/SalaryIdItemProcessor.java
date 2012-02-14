package handson.springbatch.processor;

import handson.springbatch.model.Salary;

import java.util.Random;
import java.util.UUID;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.InitializingBean;

public class SalaryIdItemProcessor implements ItemProcessor<Salary, Salary> {
	public Salary process(Salary item) throws Exception {
		item.setId(UUID.randomUUID().toString());
		return item;
	}

}