package handson.springbatch.processor;

import handson.springbatch.model.Salary;

import java.util.List;
import java.util.Map;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;

import com.google.common.base.Function;
import com.google.common.collect.Maps;

// Ici 2 solutions possibles
// 1. On fait un SELECT ID à chaque item pour vérifier si l'id existe, cela peut être lent.
// 2. On load tous les ID dans un cache, cela est plus rapide mais plus couteux en mémoire.
public class SalaryEmployeeValidator implements Validator<Salary> {
	private static final String SQL_IDS = "SELECT ID FROM EMPLOYEES ORDER BY ID";
//	private static final String SQL = "SELECT ID FROM EMPLOYEES WHERE ID=?";
	Map<Integer,Integer> idsCaches;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public SalaryEmployeeValidator() {
	}

	@Override
	public void validate(Salary value) throws ValidationException {
//		boolean found = jdbcTemplate.query(SQL, new Object[] { value.getEmployeeId() }, new SingleColumnRowMapper<String>(String.class)).size() == 1;
//		if (!found) {
//			throw new ValidationException("Employee " + value.getEmployeeId()
//					+ " not found");
//		}

		if (!idsCaches.containsKey(value.getEmployeeId())) {
			throw new ValidationException("Employee " + value.getEmployeeId() + " not found");
		}
	}

	@BeforeStep
	public void beforeStep(StepExecution stepExecution) {
		List<Integer> ids = jdbcTemplate.query(SQL_IDS, new Object[] {}, new SingleColumnRowMapper<Integer>(Integer.class));
		idsCaches = Maps.uniqueIndex(ids, new Function<Integer,Integer>() {
		  public Integer apply(Integer input) {
		    return input;
		   }
		 });
	}

	@AfterStep
	public ExitStatus afterStep(StepExecution stepExecution) {
		// clean cache
		idsCaches = null;
		return ExitStatus.COMPLETED;
	}
}
