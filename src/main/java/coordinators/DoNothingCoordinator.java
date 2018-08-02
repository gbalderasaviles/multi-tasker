package coordinators;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import callables.DoNothingCallable;
import coordination.Coordinator;

/**
 * Do Nothing Coordinator
 * An extension from a Coordinator, which can be used to differentiate among the multiple types of tasks defined by the users.
 * This is just an example of how to extend the basic Coordinator functionality.
 * @author Gabriel Balderas.
 *
 */
public class DoNothingCoordinator extends Coordinator {
	
	public static void main (String[] args) {
		
		/*
		 * Every coordinator is in charge of a list of tasks to be executed and
		 * the type of task to be executed.
		 */
		List<Future<String>> futuresList = new ArrayList<Future<String>>();
		DoNothingCallable doNothingCallable = new DoNothingCallable();
		DoNothingCoordinator doNothingCoordinator = new DoNothingCoordinator();
		
		//Tasks are added to the executor service.
		for (int i = 0 ; i < 100 ; i++) {
			Future<String> future = doNothingCoordinator.addStringTask(doNothingCallable);
			futuresList.add(future);
		}
		
		//The values are obtained from the pool.
		for (Future<String> future : futuresList) {
			try {
				System.out.println("Thread Info: " + future.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		doNothingCoordinator.executorService.shutdown();
	}
}