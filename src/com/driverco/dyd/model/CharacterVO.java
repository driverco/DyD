package com.driverco.dyd.model;

import java.util.Random;


public class CharacterVO {
	private String name;
	private int power, hp, currentHp, defense;
	private static final int maxPoints = 220;
	private static final int maxPointsPerItem = 100;
	private static final int tolerancePercent= 10;
	
	
    private String[] names={"Alexander", "Wilmer", "Pibe", "Solomons", "Grimmer", "Incubus", "Sucubus", "Lilith", "Lucifer", "Luciferina", "Cadence"};

	public CharacterVO() {
		Random r=new Random();
        int randomNumber=r.nextInt(names.length);
        name = names[randomNumber];
        int pointsTotal = maxPoints*(100-tolerancePercent)/100 + r.nextInt(maxPoints*tolerancePercent*2)/100;
        power = pointsTotal; 
        hp = pointsTotal;
        defense = pointsTotal;
        while (power>maxPointsPerItem || hp >maxPointsPerItem || defense >maxPointsPerItem ||defense < 0) {
            power = (pointsTotal*r.nextInt(100))/100; 
            defense = (pointsTotal*r.nextInt(100))/100;
            hp = pointsTotal-power-defense;
        }
        currentHp = hp; 
        
	}
	public String getName() {
		return name;
	}
	public int getPower() {
		return power;
	}
	public int getHp() {
		return hp;
	}
	public int getCurrentHp() {
		return currentHp;
	}
	public int getDefense() {
		return defense;
	}
	public void attack(int powerAttack) {
		currentHp -= (powerAttack * (100 - defense))/100;
		if (currentHp<0){
			currentHp = 0;
		}
	}
	public void heal() {
		currentHp = hp;
	}

	
}
