import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class HowManyCoresAreUsed {

	public static void main(String[] args) {
		System.out.println(Runtime.getRuntime().availableProcessors());
		
		// System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","3");
		// //or go to run, run configurations, arguments, VM arguments:
		// //-Djava.util.concurrent.ForkJoinPool.common.parallelism=20
		
		// ForkJoinPool commonPool = ForkJoinPool.commonPool(); 
		// System.out.println(commonPool.getParallelism()); //default is 1 less than availableProcessors (as calling thread also counts as 1)

		
		// IntStream.range(0, 10000000).parallel().filter(
		// 		(int x) -> { System.out.println(Thread.currentThread().getName());
		// 		return x < 5000000; }
		// 		).count();
		

	}

}
