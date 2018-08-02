package coordination;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Base coordinator class that starts an Executor Service and takes tasks which return Strings.
 * @author Gabriel Balderas
 *
 */
public class Coordinator {
	
	public ExecutorService executorService;
	
	/**
	 * The basic coordinator starts instantiates an executor service and can be used for different purposes.
	 * In this basic example, a thread pool with 20 base threads is initiated.
	 */
	public Coordinator() {
		executorService = Executors.newFixedThreadPool(20);
	}
	
	/**
	 * This is a wrapper method for adding tasks that return strings.
	 * Extra functionality could include an element count for example.
	 * @param callable The Callable which returns a String
	 * @return A Future that will return the String once the task is completed.
	 */
	public Future<String> addStringTask(Callable<String> callable) {
		return executorService.submit(callable);
	}
}
