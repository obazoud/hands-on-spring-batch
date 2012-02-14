package handson.springbatch;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class HelloWorldJobTest {
	@Autowired
	private Job job;

	@Autowired
	private JobLauncher jobLauncher;

	@Test
	public void helloworldTasklet() throws Exception {
		JobExecution jobExecution = jobLauncher.run(job, new JobParameters());
		Assert.assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
		StepExecution stepExecution = jobExecution.getStepExecutions().iterator().next();
		assertEquals(7, stepExecution.getReadCount());
		assertEquals(0, stepExecution.getSkipCount());
		assertEquals(2, stepExecution.getFilterCount());
		assertEquals(5, stepExecution.getWriteCount());
		
	}
}
