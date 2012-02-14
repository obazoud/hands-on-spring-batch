package handson.springbatch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class NoopItemWriter implements ItemWriter<Object> {

	@Override
	public void write(List<? extends Object> items) throws Exception {
	}

}
