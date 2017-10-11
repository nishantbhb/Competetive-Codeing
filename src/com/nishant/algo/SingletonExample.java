package com.nishant.algo;

import java.util.Scanner;

class Singleton {
	static Singleton obj;

	public static Singleton getInstance() {
		if (obj == null) {
			synchronized (Singleton.class) {
				if (obj == null)
					obj = new Singleton();
			}
		}
		return obj;
	}

	public void display(int x) {
		System.out.println("Value of passed number: " + x);
	}
}

public class SingletonExample {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter value: ");
		int x = s.nextInt();
		Singleton obj = Singleton.getInstance();
		obj.display(x);
		s.close();
	}
}
