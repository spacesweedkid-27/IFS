package lib.masking.examples;

import lib.masking.Faltung;

public class Median extends Faltung {
	@Override
	public void calculateValue() {
		setValue((int) Bubblesorter.bubblesort(inputToOneDimArray())[4]);
}
}
