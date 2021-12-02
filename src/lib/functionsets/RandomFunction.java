package lib.functionsets;

import lib.RandomMesh;
import lib.core.Core;

import java.awt.*;
import java.util.Random;

public class RandomFunction extends Functionset{

    public static double[][] privateDef = new double[50][7];


    public static Color[] colors;
    public static int wurfel;
    public double[] tempInput;
    
    public static Color[] randmColors(int n) {
    	Color[] temp = new Color[n];
    	
    	for (int i = 0; i < n; i++) {
    		temp[i] = Color.getHSBColor((float) ((((double)i)/((double)n))), 1, 1);

    	}
    	
    	
   
    	return temp;
    }
    

    private double[] devideRandom(int n){
        double[] temp = new double[n];
        temp[0] = Math.random();

        double sumOfThoseBefore = 0;

        for(int i = 1; i < n; i++){
            sumOfThoseBefore = sumOfThoseBefore+temp[i-1];
            temp[i] = (1-sumOfThoseBefore)*Math.random();
        }
        sumOfThoseBefore = sumOfThoseBefore+temp[n-1];

        for(int i = 1; i < n; i++){
            temp[i] = temp[i]+(1-sumOfThoseBefore)/(n-1);
        }

        Random rand = new Random();

        for (int i = 0; i < temp.length; i++) {
            int randomIndexToSwap = rand.nextInt(temp.length);
            double temp2 = temp[randomIndexToSwap];
            temp[randomIndexToSwap] = temp[i];
            temp[i] = temp2;
        }

        return temp;
    }

    public RandomFunction(){
    	
    	colors = new Color[privateDef.length];
    	colors = randmColors(privateDef.length);
    	
    	for (int i = 0; i < privateDef.length; i++){
            for (int j = 0; j < privateDef[0].length-1; j++){
                privateDef[i][j] = 2*(Math.random()-0.5);
            }
        }
        double[] dvr = devideRandom(privateDef.length);
        tempInput = new double[privateDef.length];
        
        for (int i = 0; i < privateDef.length; i++) {
            privateDef[i][6] = dvr[i];
            tempInput[i] = privateDef[i][6];
            
        }


        for (int i = 0; i < privateDef.length; i++){
            for (int j = 0; j < privateDef[0].length; j++){
                System.out.print(privateDef[i][j]+ " ");
            } System.out.println();
        }
    }




    @Override
    public double[] calculate(double[] lastPoints, Graphics2D g) {
        double[] temp = new double[2];

        wurfel = RandomMesh.randmIndex(tempInput);

        temp[0] = privateDef[wurfel][0]*lastPoints[0]+privateDef[wurfel][1]*lastPoints[1]+privateDef[wurfel][4];
        temp[1] = privateDef[wurfel][2]*lastPoints[0]+privateDef[wurfel][3]*lastPoints[1]+privateDef[wurfel][5];

        return temp;
    }
}


