package handson.springbatch;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

@Component
public class HelloWorldReader implements ItemReader<String> {
	private List<String> names = Lists.newArrayList("Aaron", "Abel", "Adam", "Alban", "Alberto", "Alexandre", "Alfred");

	@Override
	public String read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		// TODO : returner les elements un par un, une fois fini, renovuer null
		
		throw new RuntimeException("TODO: not yet implemented");
	}

}
