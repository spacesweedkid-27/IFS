package lib.masking;

import java.awt.Color;


import lib.informatics4kids.Picture;
import lib.masking.examples.Sobel;


public class Faltung {
	private Picture picture;
	private double[][] mask = {{0,0,0},{0,9,0},{0,0,0}};
	private double[][] input = new double[3][3];
	private int value;
	
	
	
	
	private double greyColor(Color in) {
		return (in.getBlue()+in.getGreen()+in.getRed())/3;
	}
	
	public void setPicture(Picture input) {
		this.picture = input;
	}
	
	public void setMask(double[][] mask) {
		this.mask = mask;
	}
	public void setInput(int i, int j) {
		try {
		this.input[0][0] = greyColor(picture.getColor(i-1, j-1));
		}  catch (ArrayIndexOutOfBoundsException e) {
			this.input[0][0] = 0;
		}
		try {
		this.input[1][0] = greyColor(picture.getColor(i, j-1));
		}  catch (ArrayIndexOutOfBoundsException e) {
			this.input[1][0] = 0;
		}
		try {
		this.input[2][0] = greyColor(picture.getColor(i+1, j-1));
		}  catch (ArrayIndexOutOfBoundsException e) {
			this.input[2][0] = 0;
		}
		try {
		this.input[0][1] = greyColor(picture.getColor(i-1, j));
		}  catch (ArrayIndexOutOfBoundsException e) {
			this.input[0][1] = 0;
		}
		this.input[1][1] = greyColor(picture.getColor(i, j));
		try {
		this.input[2][1] = greyColor(picture.getColor(i+1, j));
		}  catch (ArrayIndexOutOfBoundsException e) {
			this.input[2][1] = 0;
		}
		try {
		this.input[0][2] = greyColor(picture.getColor(i-1, j+1));
		}  catch (ArrayIndexOutOfBoundsException e) {
			this.input[0][2] = 0;
		}
		try {
		this.input[1][2] = greyColor(picture.getColor(i, j+1));
		}  catch (ArrayIndexOutOfBoundsException e) {
			this.input[1][2] = 0;
		}
		try {
		this.input[2][2] = greyColor(picture.getColor(i+1, j+1));
		}  catch (ArrayIndexOutOfBoundsException e) {
			this.input[2][2] = 0;
		}
	
}

	public void calculateValue(Sobel.SobelType sobelType) {

	}
	
	public void calculateValue() {
		double temp = 0;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				temp = temp + mask[i][j]*input[i][j];
			}
		}
		this.value = (int)temp/9;
	}
	
	public Color getValue() {
		return new Color(this.value,this.value,this.value);
	}

	public Picture transform(Sobel.SobelType sobelType) {
		return null;
	}
	
	public Picture transform() {
		Picture temp = new Picture(this.picture.widthX(),this.picture.heightY());
		for(int i = 0; i < this.picture.widthX(); i++) {
			for(int j = 0; j < this.picture.heightY(); j++) {
				this.setInput(i, j);
				this.calculateValue();
				temp.setColor(i, j, this.getValue());
			}
		}
		return temp;
	}
	
	public double[] inputToOneDimArray() {
		
		return new double[] {
			input[0][0],input[1][0],input[2][0],
			input[0][1],input[1][1],input[2][1],
			input[0][2],input[1][2],input[2][2]
		};
	}

	public Picture getPicture() {
		return picture;
	}

	public double[][] getMask() {
		return mask;
	}

	public double[][] getInput() {
		return input;
	}

	public void setValue(int value) {
		this.value = value;
	}

}

