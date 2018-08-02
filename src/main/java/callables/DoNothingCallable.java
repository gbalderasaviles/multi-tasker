package callables;

import java.util.concurrent.Callable;

/**
 * A Callable Example
 * Prints the timestamp of the Callable's execution and the Thread name and number.
 * @author Gabriel Balderas
 *
 */
public class DoNothingCallable implements Callable<String> {

	@Override
	public String call() throws Exception {
		return "Timestamp: " + System.currentTimeMillis() + " Thread: " + Thread.currentThread().getName();
	}

}
