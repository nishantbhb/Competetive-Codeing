package com.nishant.practice;

abstract class Z {
	static final int ab = 2;

	Z() {
		System.out.println("Base");
	}

	Z(int x) {
		System.out.println("Base Param");
	}

	abstract void abc();

	void xyz() {
		System.out.println("XYZ method");
	}
}

class Test extends Z {
	Test(int x) {
		// super(123);
		System.out.println("Derived");
	}

	@Override
	void abc() {
		System.out.println(ab);
	}

}

public class Test2 {

	public static void main(String[] args) {
		Test z = new Test(123);
		z.abc();
		z.xyz();

	}

}
