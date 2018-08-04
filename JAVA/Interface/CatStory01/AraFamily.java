package CatStory01;

public class AraFamily {
	
	public static void main(String[] args) {
		TroubleMaker wtouble = new WallPaperTrouble();
		TroubleMaker ftrouble = new FretTrouble();
		
		PlayMaker bPlay = new BallPlay();
		PlayMaker wPlay = new WrestlingPlay();
		
		MomCatAra jjangee = new Jjangee(wtouble, wPlay);
		MomCatAra latte = new Latte(ftrouble, wPlay);
		MomCatAra moca = new Moca(ftrouble, bPlay);
		
		jjangee.Problem();
		System.out.println("****************************");
		latte.Problem();
		System.out.println("****************************");
		moca.Problem();		
		
	}

}
