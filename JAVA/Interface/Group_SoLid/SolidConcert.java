package Group_SoLid;

public class SolidConcert {

	public static void main(String[] args) {
		Positional vPosition = new VocalPosition();
		Positional rPosition = new RapPosition();
		Positional sPositional = new SubVocalPosition();

		Specianal bSpecial = new BB_Special();
		Specianal sSpecial = new S_Special();
		Specianal pSpecial = new PD_Special();

		SolidMember kimjohan = new KimJohan(vPosition, bSpecial);
		SolidMember leejun = new LeeJun(rPosition, sSpecial);
		SolidMember jungjaeyoon = new JungJaeYoon(sPositional, pSpecial);

		kimjohan.concert();
		System.out.println("**********************************");
		leejun.concert();
		System.out.println("**********************************");
		jungjaeyoon.concert();

	}

}
