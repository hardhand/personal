package Group_SoLid;

public abstract class SolidMember {
	protected String name;
	protected Positional position;
	protected Specianal special;
	
	
	public void concert() {
		System.out.println(name + "(이)가 공연을 시작합니다.");
		position();
		special();
		System.out.println(name + "(이)가 공연을 마칩니다.");
	}
	
	public void position() {
		position.position();
	}
	
	public void special() {
		special.special();

}
}