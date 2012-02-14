package handson.springbatch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldProcessor implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {
		// TODO : filtrer les items contenant un 'o'
		
		// TODO : returner 'hello ' + item
		
		throw new RuntimeException("TODO: not yet implemented");
	}

}
