import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		
		    int n = 0; 
	        try (Scanner s=new Scanner(System.in)) {
	        	while (true){
	        		System.out.println("Enter the number of Queens :");
	        		n = s.nextInt();
	        		if ( n == 2 || n ==3) {
	        			System.out.println("No Solution possible for "+ n +" Queens. Please enter another number");
	        		}
	        		else
	        			break;
	        	}
	        }

			int threadCounts = 5;

	        long timestamp1 = System.currentTimeMillis();
	        
	        System.out.println("Solution to "+ n +" queens using hill climbing search:\n");
	        
	        ThreadGroup g = new ThreadGroup("8Queen");

			HillClimbingSearch[] hcs = new HillClimbingSearch[threadCounts];
	        
			for (int i = 0; i < threadCounts; i++){
	        	hcs[i] = new HillClimbingSearch(n);
				new Thread(g, hcs[i]).start();
				
			}
	        while (g.activeCount() == threadCounts);
	        long timestamp2 = System.currentTimeMillis();
			
			long timeDiff = timestamp2 - timestamp1;
			
			int counter = 0;
			
			for (int i = 0; i < threadCounts; i++){
				if (hcs[i].getFinalSolution() !=null) {
					System.out.println("Solution found by Thread " + ( counter + 1) );
					hcs[i].printState(hcs[i].getFinalSolution());
					counter ++;
				}
			}
            g.interrupt();
			
			System.out.println("\n");
			
			System.out.println( counter + " Threads out of the " + threadCounts + " Threads found a solution.");
			
			System.out.println("Execution Time: "+timeDiff+" ms");
	        
	       
	    }
}