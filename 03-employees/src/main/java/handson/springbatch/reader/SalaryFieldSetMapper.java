package handson.springbatch.reader;

import handson.springbatch.model.Salary;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.DataBinder;

public class SalaryFieldSetMapper extends BeanWrapperFieldSetMapper<Salary> {

	@Override
	protected void initBinder(DataBinder binder) {
		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, editor);
	}
}
