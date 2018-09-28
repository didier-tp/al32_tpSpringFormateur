package fr.afcepf.al32;

import fr.afcepf.al32.entity.Personne;

public class App {


	public static void main(String[] args) {
		Personne p1 = new Personne();
		p1.setNom("Dupond");
		System.out.println("p1="+ p1.toString());
	}

}
