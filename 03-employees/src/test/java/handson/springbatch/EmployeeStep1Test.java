package handson.springbatch;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class EmployeeStep1Test {
	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void read_sample_employees() throws Exception {
		JobParameters jobParameters = new JobParametersBuilder()
				.addParameter("datafileEmployees", new JobParameter("classpath:/employee.csv"))
				.toJobParameters();
		JobExecution jobExecution = jobLauncherTestUtils.launchStep("step1", jobParameters);
		Assert.assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());

		StepExecution stepExecution = jobExecution.getStepExecutions().iterator().next();

		assertEquals(40, stepExecution.getReadCount());
		assertEquals(0, stepExecution.getSkipCount());
		assertEquals(3, stepExecution.getFilterCount());
		assertEquals(37, stepExecution.getWriteCount());

		assertEquals(37, jdbcTemplate.queryForInt("SELECT COUNT(*) from Employees"));
	}

	@Test
	public void read_skip_employees() throws Exception {
		JobParameters jobParameters = new JobParametersBuilder()
				.addParameter("datafileEmployees", new JobParameter("classpath:/employee-skip.csv"))
				.toJobParameters();
		JobExecution jobExecution = jobLauncherTestUtils.launchStep("step1", jobParameters);
		Assert.assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());

		StepExecution stepExecution = jobExecution.getStepExecutions().iterator().next();

		assertEquals(39, stepExecution.getReadCount());
		assertEquals(3, stepExecution.getSkipCount());
		assertEquals(3, stepExecution.getFilterCount());
		assertEquals(34, stepExecution.getWriteCount());

		assertEquals(34, jdbcTemplate.queryForInt("SELECT COUNT(*) from Employees"));
	}

}
