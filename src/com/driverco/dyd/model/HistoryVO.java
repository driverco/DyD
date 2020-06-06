package com.driverco.dyd.model;

public class HistoryVO {
	 public static final int LOC_TOWN = 0;
	 public static final int LOC_FOREST = 1;
	 public static final int LOC_RIVER = 2;
	 public static final int LOC_PLAINS = 3;
	 public static final int LOC_MOUNTAIN = 4;

	 public static final int STAT_OK = 0;
	 public static final int STAT_BATTLE = 1;
	 public static final int STAT_DEAD = 2;

	 private int location;
	 private int status;
	 private EnemyVO enemy;

	 public HistoryVO () {
			this.location = LOC_TOWN;
			this.status = STAT_OK;
	 }

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
		if (status == STAT_BATTLE) {
			enemy = new EnemyVO();
		}
		if (status == STAT_OK) {
			enemy = null;
		}

	}

	public EnemyVO getEnemy() {
		return enemy;
	}

}
