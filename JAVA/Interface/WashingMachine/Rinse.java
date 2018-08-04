package WashingMachine;

public class Rinse extends Washer {
	public Rinse(Water water, Detergent detergent, Function function) {
		this.name = "헹굼";
		this.water = water;
		this.detergent = detergent;
		this.function = function;
	}

}
