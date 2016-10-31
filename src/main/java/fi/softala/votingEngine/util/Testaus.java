package fi.softala.votingEngine.util;

import java.util.Scanner;

public class Testaus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner input=new Scanner(System.in);
		
		System.out.println("Anna sana:");
		String sana=input.nextLine();
		System.out.println("Merkki jono on "+sana.length()+" merkkiä pitkä");

	}

}
