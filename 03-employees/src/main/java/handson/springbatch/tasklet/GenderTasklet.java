package handson.springbatch.tasklet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class GenderTasklet implements Tasklet {
	private static final String SQL = "SELECT COUNT(*) FROM EMPLOYEES WHERE GENDER = ?";
	Logger logger = LoggerFactory.getLogger(GenderTasklet.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {
		int count = jdbcTemplate.queryForInt(SQL, "M");
		logger.info("Count M {}", count);
		chunkContext.getStepContext().getStepExecution().getExecutionContext().put("MALE", count);

		count = jdbcTemplate.queryForInt(SQL, "F");
		logger.info("Count F {}", count);
		chunkContext.getStepContext().getStepExecution().getExecutionContext().put("FEMALE", count);

		return RepeatStatus.FINISHED;
	}

}
