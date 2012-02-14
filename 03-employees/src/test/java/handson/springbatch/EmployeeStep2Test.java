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
public class EmployeeStep2Test {
	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void read_sample_salaries() throws Exception {
		JobParameters jobParameters = new JobParametersBuilder()
				.addParameter("datafileSalaries", new JobParameter("classpath:/salaries.xml"))
				.toJobParameters();

		JobExecution jobExecution = jobLauncherTestUtils.launchStep("step2", jobParameters);
		Assert.assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());

		StepExecution stepExecution = jobExecution.getStepExecutions().iterator().next();

		assertEquals(392, stepExecution.getReadCount());
		assertEquals(5, stepExecution.getSkipCount());
		assertEquals(0, stepExecution.getFilterCount());
		assertEquals(387, stepExecution.getWriteCount());

		assertEquals(387, jdbcTemplate.queryForInt("SELECT COUNT(*) from Salaries"));
	}

}
