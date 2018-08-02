package futures;

import java.util.concurrent.FutureTask;
import callables.DoNothingCallable;

/**
 * This future executes the contract from the Callable
 * which is to return the thread name along with a timeStamp.
 * @author Gabriel Balderas
 *
 */
public class DoNothingFuture extends FutureTask<String> {
	
	private final String threadInfo;

	/**
	 * DoNothingFuture constructor.
	 * @param doNothingCallable
	 * @throws Exception
	 */
	public DoNothingFuture(DoNothingCallable doNothingCallable) throws Exception {
		super(doNothingCallable);
		this.threadInfo = doNothingCallable.call();
	}
	
	/**
	 * Returns the String from the Callable once it's executed.
	 * @return The String value from the Callable.
	 */
	public String getThreadInfo() {
		return threadInfo;
	}
	
}
