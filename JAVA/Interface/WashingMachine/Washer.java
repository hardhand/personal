package WashingMachine;

public class Washer {
	protected String name;
	protected Water water;
	protected Detergent detergent;
	protected Function function;
	
	public void washing() {
		System.out.println(name + "을(를) 시작합니다.");
		water();
		detergent();
		function();		
		System.out.println(name + "이(가) 완료되었습니다.");
	}
	public void water() {
		water.water();
		
	}
	public void detergent() {
		detergent.detergent();
	}
	
	public void function() {
		function.function();
	}

}
