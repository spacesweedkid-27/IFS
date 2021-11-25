package lib;

public class RandomMesh {
	
	public static int randmIndex(double[] probs) {
		double[] addedProbs = new double[probs.length+1];
		addedProbs[0] = 0;
		for (int i = 1; i < probs.length+1; i++) {
			addedProbs[i] = addedProbs[i-1] + probs[i-1];
		}
		
		double randm = Math.random();
		
		for (int i = 0; i < addedProbs.length; i++) {
			if (addedProbs[i]< randm && randm < addedProbs[i+1]) {
				return i;
			}
		}
		return 0;
	}
}
