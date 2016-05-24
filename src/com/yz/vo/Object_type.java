package com.yz.vo;

public enum Object_type {

	NULLO(-1), DUST(1), CRANE(2), LIFT(3), NOISE(4);

	private final int _val;

	private Object_type(int val) {
		_val = val;
	}

	public int getValue() {
		return this._val;
	}

	public static Object_type valueOf(int val) {
		switch (val) {
		case 1:
			return DUST;
		case 2:
			return CRANE;
		case 3:
			return LIFT;
		case 4:
			return NOISE;
		default:
			return NULLO;
		}
	}

}
