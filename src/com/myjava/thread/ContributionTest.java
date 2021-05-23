package com.myjava.thread;

public class ContributionTest {

    public static void main(String[] args) {
        Contributor[] contributors = new Contributor[10];

        for (int loop = 0; loop < 10; loop++) {
            Contribution contribution = new Contribution();
            contributors[loop] = new Contributor(contribution, " Contributor" + loop);
        }

        for (int loop = 0; loop < 10; loop++) {
            contributors[loop].start();
        }
    }
}
