package handson.springbatch;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldWriter implements ItemWriter<String> {
	Logger logger = LoggerFactory.getLogger(HelloWorldWriter.class);

	@Override
	public void write(List<? extends String> items) throws Exception {
		// TODO : afficher les items via slf4j
		for (String item : items) {
			logger.info(item);
		}
	}

}
