package lib.functionsets;

import lib.functions.Function;
import lib.RandomMesh;
import lib.functions.DEFAULT1;
import lib.functions.DEFAULT2;
import lib.functions.DEFAULT3;
import lib.functions.DEFAULT4;

import java.awt.*;

public class BetterDefault extends Functionset {
	
	public BetterDefault() {
		privateDef = new double[][] {
			{0.0,0.0,0.0,0.16,0.0,0.0,0.01},
			{0.85,0.04,-0.04,0.85,0.0,1.6,0.85},
			{0.2,-0.26,0.23,0.11,0.0,1.6,0.07},
			{-0.15,0.28,0.26,0.24,0.0,0.44,0.07}
		};
	}

	public static Color[] colors = {Color.BLUE,Color.RED,Color.GREEN,Color.MAGENTA};
	public static int wurfel;
	
	public static double[][] privateDef;


	@Override
	public double[] calculate(double[] lastPoints, Graphics2D g) {
		double[] temp = new double[2];
		wurfel = RandomMesh.randmIndex(new double[] {privateDef[0][6],privateDef[1][6],privateDef[2][6],privateDef[3][6]});
		
		temp[0] = privateDef[wurfel][0]*lastPoints[0]+privateDef[wurfel][1]*lastPoints[1]+privateDef[wurfel][4];
		temp[1] = privateDef[wurfel][2]*lastPoints[0]+privateDef[wurfel][3]*lastPoints[1]+privateDef[wurfel][5];
		
		return temp;
	}
}
