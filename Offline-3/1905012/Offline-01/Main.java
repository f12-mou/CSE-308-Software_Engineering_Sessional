package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Imposter imposter = new Imposter();

        GoodPassenger goodPassenger1 = new CrewMate();
        GoodPassenger goodPassenger2 = new ImposterAdapter(imposter);

        goodPassenger1.study();
        goodPassenger2.study();

        System.out.println();

        goodPassenger1.maintain();
        goodPassenger2.maintain();
    }
}
