package handson.springbatch;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

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
public class EmployeeJobTest {
	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void test_all_job_but_only_step1_and_step2() throws Exception {
		JobParameters jobParameters = new JobParametersBuilder()
				.addParameter("datafileSalaries", new JobParameter("classpath:/salaries.xml"))
				.addParameter("datafileEmployees", new JobParameter("classpath:/employee.csv"))
				.toJobParameters();
		JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameters);
		Assert.assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());

		Iterator<StepExecution> iterator = jobExecution.getStepExecutions().iterator();

		StepExecution stepExecution = iterator.next();
		assertEquals(40, stepExecution.getReadCount());
		assertEquals(0, stepExecution.getSkipCount());
		assertEquals(3, stepExecution.getFilterCount());
		assertEquals(37, stepExecution.getWriteCount());

		assertEquals(37, jdbcTemplate.queryForInt("SELECT COUNT(*) from Employees"));

		stepExecution = iterator.next();

		assertEquals(392, stepExecution.getReadCount());
		assertEquals(31, stepExecution.getSkipCount());
		assertEquals(0, stepExecution.getFilterCount());
		assertEquals(361, stepExecution.getWriteCount());

		assertEquals(361, jdbcTemplate.queryForInt("SELECT COUNT(*) from Salaries"));
	}

	@Test
	public void test_all_job() throws Exception {
		JobParameters jobParameters = new JobParametersBuilder()
				.addParameter("datafileSalaries", new JobParameter("classpath:/salaries.xml"))
				.addParameter("datafileEmployees", new JobParameter("classpath:/employee.csv"))
				.toJobParameters();
		JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameters);
		Assert.assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());

		assertEquals(25, jobExecution.getExecutionContext().get("MALE"));
		assertEquals(12, jobExecution.getExecutionContext().get("FEMALE"));
	}

}
