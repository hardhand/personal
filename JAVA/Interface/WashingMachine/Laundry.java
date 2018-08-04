package WashingMachine;

public class Laundry {

	public static void main(String[] args) {
		Water fWater = new FilledWater();
		Water dWater = new DrainingWater();		

		Detergent fDetergent = new Filled_Detergent();
		Detergent rDetergent = new Rinse_Detergent();
		Detergent nDetergent = new None_Detergent();
		
		Function wFunction = new WashFunction();
		Function rFunction = new RinseFunction();
		Function dFunction = new DewaterFunction();

		Washer wash = new Wash(fWater, fDetergent, wFunction);
		Washer rinse = new Rinse(fWater, rDetergent, rFunction);
		Washer dewater = new Dewater(dWater, nDetergent, dFunction);

		wash.washing();
		System.out.println("=================================");
		rinse.washing();
		System.out.println("=================================");
		dewater.washing();

	}

}
