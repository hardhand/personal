package WashingMachine;

public class Wash extends Washer {
	public Wash(Water water, Detergent detergent, Function function) {
		this.name = "세탁";
		this.water = water;
		this.detergent = detergent;
		this.function = function;
	}

}
