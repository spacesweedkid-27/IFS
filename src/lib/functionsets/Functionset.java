package lib.functionsets;

import lib.RandomMesh;
import lib.functions.*;

import java.awt.*;

public class Functionset {

    public static Color[] colors;
    public static double[] tempInput;
    public static int wurfel;
    public static double[][] privateDef;

    public double[] calculate(double[] lastPoints, Graphics2D g) {
        double[] temp = new double[2];

        wurfel = RandomMesh.randmIndex(tempInput);

        temp[0] = privateDef[wurfel][0]*lastPoints[0]+privateDef[wurfel][1]*lastPoints[1]+privateDef[wurfel][4];
        temp[1] = privateDef[wurfel][2]*lastPoints[0]+privateDef[wurfel][3]*lastPoints[1]+privateDef[wurfel][5];

        return temp;
    }
}
