package lib.masking.examples;

import lib.masking.Faltung;

public class Gauss extends Faltung {
	public Gauss(){
	    super.setMask(new double[][]{{0.5,1.25,0.5},{1.25,1.5,1.25},{0.5,1.25,0.5}});
    }
}
