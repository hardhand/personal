package CatStory01;

public abstract class MomCatAra {
	protected String name;
	protected TroubleMaker trouble;
	protected PlayMaker play;

	
	public void Problem() {
		System.out.println(name + "가 말썽을 시작합니다.");
		trouble();
		play();
		System.out.println(name + "가 말썽을 그만합니다.");

	}

	public void trouble() {
		trouble.trouble();
	}
	
	public void play() {
		play.play();
	}
}
