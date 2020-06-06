package com.driverco.dyd.model;

import java.util.Random;

public class EnemyVO {
	private String names[] = {"Dracula", "Werewolf","Tiny Bunny","Slime","Old Burguer", "Killer Car"};
	private String name;
	private int hp, power;
	

	public EnemyVO() {
		Random r=new Random();
        int randomNumber=r.nextInt(names.length);
        name = names[randomNumber];
        this.power= r.nextInt(60);
        this.hp= r.nextInt(380) + 20;

	}
	
	public String getName() {
		return this.name;
	}

	public int getHp() {
		return hp;
	}

	public int getPower() {
		return power;
	}

	public void attack(int powerAttack) {
		this.hp -= powerAttack;
		if(this.hp<0 ) {
			this.hp= 0;
		}
	}
}
