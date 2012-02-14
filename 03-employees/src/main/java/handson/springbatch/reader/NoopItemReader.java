package handson.springbatch.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class NoopItemReader implements ItemReader<Object> {
	@Override
	public Object read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		return null;
	}
}
