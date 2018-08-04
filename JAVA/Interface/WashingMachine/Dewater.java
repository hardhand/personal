package WashingMachine;

public class Dewater extends Washer {

	public Dewater(Water water, Detergent detergent, Function function) {
		this.name = "탈수";
		this.water = water;
		this.detergent = detergent;
		this.function = function;
	}

}
