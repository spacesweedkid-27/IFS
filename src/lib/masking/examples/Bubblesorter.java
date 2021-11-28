package lib.masking.examples;

public class Bubblesorter {
	public static double[] bubblesort(double[] zusortieren) {
		double temp;
		for(int i=1; i<zusortieren.length; i++) {
			for(int j=0; j<zusortieren.length-i; j++) {
				if(zusortieren[j]>zusortieren[j+1]) {
					temp=zusortieren[j];
					zusortieren[j]=zusortieren[j+1];
					zusortieren[j+1]=temp;
				}
				
			}
		}
		return zusortieren;
	}
}
