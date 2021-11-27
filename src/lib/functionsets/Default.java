package lib.functionsets;

import lib.functions.Function;
import lib.RandomMesh;
import lib.functions.DEFAULT1;
import lib.functions.DEFAULT2;
import lib.functions.DEFAULT3;
import lib.functions.DEFAULT4;

import java.awt.*;

public final class Default extends Functionset {

	public Color[] colors = {Color.BLUE,Color.RED,Color.GREEN,Color.MAGENTA};
	public int wurfel;

	public Default(){
		privateDef = new Function[]{new DEFAULT1(), new DEFAULT2(), new DEFAULT3(), new DEFAULT4()};
	}

	@Override
	public double[] calculate(double[] lastPoints, Graphics2D g) {
		double[] temp = new double[2];
		wurfel = RandomMesh.randmIndex(new double[] {privateDef[0].prop(),privateDef[1].prop(),privateDef[2].prop(),privateDef[3].prop()});
		
		temp[0] = privateDef[wurfel].var1()*lastPoints[0]+privateDef[wurfel].var2()*lastPoints[1]+privateDef[wurfel].var5();
		temp[1] = privateDef[wurfel].var3()*lastPoints[0]+privateDef[wurfel].var4()*lastPoints[1]+privateDef[wurfel].var6();
		
		return temp;
	}
}
