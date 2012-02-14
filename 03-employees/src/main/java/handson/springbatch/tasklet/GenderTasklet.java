package handson.springbatch.tasklet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class GenderTasklet implements Tasklet {
	Logger logger = LoggerFactory.getLogger(GenderTasklet.class);

	@Override
	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {

		// TODO : afficher le nombre d’employée masculins et féminins à l'aide Slf4j
		return RepeatStatus.FINISHED;
	}

}
