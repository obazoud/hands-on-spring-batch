package handson.springbatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldTasklet implements Tasklet {
	Logger logger = LoggerFactory.getLogger(HelloWorldTasklet.class);

	@Override
	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {
		// TODO : afficher "hello world" with slf4j
		logger.info("hello world");

		// TODO : indiquer que le processus est fini

		return RepeatStatus.FINISHED;
	}

}
