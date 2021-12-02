package lib.functionsets;

import java.awt.*;

public class ThirdPreset extends Functionset {

	public ThirdPreset() {

		privateDef = new double[][] {
			{0.05,	     0.00,	 	 0.00,	    0.06,	     0.00,	 0.00,	   0.028},
			{0.05,	     0.00, 	 	 0.00,	    -0.5,	     0.00,	 1.00,	0.023256},
			{0.459627,	-0.321394,	 0.385673,	0.383022,	 0.00,	  0.6,	 0.27907},
			{0.469846,	 0.153909,	 0.171010,	0.422862,	 0.00,	  1.1,	0.209302},
			{0.433013,	 0.275,	     -0.25,	    0.476314,	 0.00,	  1.0,	0.255814},
			{0.421325,	 0.257115,	 -0.353533,	0.306418,	 0.00,	  0.7,	0.204651}
		};

		colors = RandomFunction.randmColors(privateDef.length);

		tempInput = new double[privateDef.length];

		for (int i = 0; i < privateDef.length; i++) {
			tempInput[i] = privateDef[i][6];

		}
	}


	
}
