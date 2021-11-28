package lib.masking.examples;

import javax.swing.JOptionPane;

import lib.informatics4kids.Picture;
import lib.masking.Faltung;

public class Sobel extends Faltung {

	public static enum SobelType {
		G, Gx, Gy
	}

	double[][] mask1 = { { 1, 0, -1 }, { 2, 0, -2 }, { 1, 0, -1 } };
	double[][] mask2 = { { 1, 2, 1 }, { 0, 0, 0 }, { -1, -2, -1 } };

	@Override
	public Picture transform() {
		return null;
	}
	
	@Override
	public Picture transform(SobelType type) {
		Picture temp = new Picture(this.getPicture().widthX(), this.getPicture().heightY());
		for (int i = 0; i < this.getPicture().widthX(); i++) {
			for (int j = 0; j < this.getPicture().heightY(); j++) {
				this.setInput(i, j);
				this.calculateValue(type);
				temp.setColor(i, j, this.getValue().brighter());

			}
		}
		return temp;
	}

	double[] value = new double[2];

	@Override
	public void calculateValue() {

	}

	@Override
	public void calculateValue(SobelType type) {
		double temp = 0;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				temp = temp + mask1[i][j] * this.getInput()[i][j];
			}
		}

		value[0] = temp / 9;
		temp = 0;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				temp = temp + mask2[i][j] * this.getInput()[i][j];
			}
		}

		value[1] = temp / 9;

		switch (type) {
		case G: {
			this.setValue((int) (Math.sqrt(value[0] * value[0] + value[1] * value[1])));
			break;
		}
		case Gx: {
			this.setValue(128 + (int) value[0]);
			break;
		}
		case Gy: {
			this.setValue(128 + (int) value[1] / 9);
			break;
		}
		}

	}
}
