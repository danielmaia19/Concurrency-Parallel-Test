import java.util.ArrayList;
import java.util.Collections;


public class ParallelTest {

	public static void main(String[] args) {
		
		//System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","1"); //i.e. 1 ForkJoinPool thread + main() calling thread	
		
		ArrayList<Integer> nums = new ArrayList<>();
		for (int i = 10000000; i >= 0; i--) {
			nums.add(i);
		}
		
		long startTime, count, endTime, seqAvg=0, parallelAvg=0;
		
		//first runs...
		Collections.shuffle(nums);
		
		startTime = System.currentTimeMillis();
		
		count = nums.stream().filter(x -> x < 5000000).count();
		
		endTime = System.currentTimeMillis();

	    
	    Collections.shuffle(nums);  
	    
	    startTime = System.currentTimeMillis();
		
		count = nums.parallelStream().filter(x -> x < 5000000).count();
		
		endTime = System.currentTimeMillis();

		//...
		
		for (int i = 0; i < 5; i++) {
				
			Collections.shuffle(nums);
			
			startTime = System.currentTimeMillis();
			
			count = nums.stream().filter(x -> x < 5000000).count();
			
			endTime = System.currentTimeMillis();
			
		    System.out.println("sequential : " + (endTime - startTime)/1000.0);
		    
		    seqAvg+= (endTime - startTime);
		    
		    
		    Collections.shuffle(nums);  
		    
		    startTime = System.currentTimeMillis();
			
			count = nums.parallelStream().filter(x -> x < 5000000).count();
			
			endTime = System.currentTimeMillis();

		    System.out.println("parallel   : " + (endTime - startTime)/1000.0);
		    
		    parallelAvg+= (endTime - startTime);
			
		}
		
		System.out.println("Seq Avg secs: " + (seqAvg/5)/1000.0);
		System.out.println("Parallel Avg secs: " + (parallelAvg/5)/1000.0);
		
		
	    
	    /* output from run at uni (first omitted) 10000000 numbers in list; 4-core
	       
	        count = nums.stream().filter(x -> x < 800000).count();
	        
	        sequential : 0.773
			parallel   : 0.424
			sequential : 0.776
			parallel   : 0.441
			sequential : 0.775
			parallel   : 0.427
			sequential : 0.774
			parallel   : 0.422
			sequential : 0.778
			parallel   : 0.417
			Seq Avg secs: 0.775
			Parallel Avg secs: 0.426
	     */
		
		
		/* output from run at uni (first omitted) 10000000 numbers in list; 2-core
		 
		  	count = nums.stream().filter(x -> x < 5000000).count();
		 
	      	sequential : 1.096
			parallel   : 0.607
			sequential : 1.095
			parallel   : 0.577
			sequential : 1.087
			parallel   : 0.576
			sequential : 1.145
			parallel   : 0.597
			sequential : 1.098
			parallel   : 0.785
			Seq Avg secs: 1.104
			Parallel Avg secs: 0.628
		 */
	
		
		/* output from run at home (first omitted) 10000000 numbers in list; 8-core
		 
		 	count = nums.stream().filter(x -> x < 800000).count();
		 
		 	sequential : 0.673
			parallel   : 0.171
			sequential : 0.667
			parallel   : 0.172
			sequential : 0.67
			parallel   : 0.172
			sequential : 0.673
			parallel   : 0.171
			sequential : 0.674
			parallel   : 0.173
			Seq Avg secs: 0.671
			Parallel Avg secs: 0.171
		 */
		
		
		/* output from run at home (first omitted) 10000000 numbers in list; 8-core
		 
		 	count = nums.stream().filter(x -> x < 5000000).count();
		 
		 	sequential : 0.915
			parallel   : 0.21
			sequential : 0.924
			parallel   : 0.223
			sequential : 0.912
			parallel   : 0.216
			sequential : 0.91
			parallel   : 0.219
			sequential : 0.914
			parallel   : 0.204
			Seq Avg secs: 0.915
			Parallel Avg secs: 0.214
		 */
		
		
		/* output from run at uni lab machine (first omitted) 10000000 numbers in list; 4-core
		 
		 	count = nums.stream().filter(x -> x < 5000000).count();
		 
		 	sequential : 0.375
			parallel   : 0.125
			sequential : 0.405
			parallel   : 0.125
			sequential : 0.421
			parallel   : 0.125
			sequential : 0.422
			parallel   : 0.124
			sequential : 0.421
			parallel   : 0.125
			Seq Avg secs: 0.408
			Parallel Avg secs: 0.124
		 */
		
		
		/* Three good links: 
		 * http://rdafbn.blogspot.co.uk/2014/09/friday-benchmarking-functional-java.html
		 * http://www.slideshare.net/InfoQ/parallellazy-performance-java-8-vs-scala-vs-gs-collections
		 * http://www.infoq.com/presentations/java-streams-scala-parallel-collections?utm_source=infoq&utm_medium=slideshare&utm_campaign=slidesharenewyork
		 */
	    
	    

	}

}
