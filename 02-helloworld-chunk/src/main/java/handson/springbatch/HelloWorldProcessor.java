package handson.springbatch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldProcessor implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {
		// TODO : filtrer les items contenant un 'o'
		if (item.contains("o")) {
			return null;
		}
		// TODO : returner 'hello ' + item
		return "hello " + item;
	}

}
