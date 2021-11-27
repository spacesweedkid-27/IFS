package lib.functionsets;

import lib.RandomMesh;
import lib.functions.*;

public class Functionset {

    static Function[] privateDef = new Function[4];

    public double[] calculate(double[] lastPoints) {
        double[] temp = new double[2];
        int wurfel = RandomMesh.randmIndex(new double[] {privateDef[0].prop(),privateDef[1].prop(),privateDef[2].prop(),privateDef[3].prop()});


        temp[0] = privateDef[wurfel].var1()*lastPoints[0]+privateDef[wurfel].var2()*lastPoints[1]+privateDef[wurfel].var5();
        temp[1] = privateDef[wurfel].var3()*lastPoints[0]+privateDef[wurfel].var4()*lastPoints[1]+privateDef[wurfel].var6();

        return temp;
    }

}
