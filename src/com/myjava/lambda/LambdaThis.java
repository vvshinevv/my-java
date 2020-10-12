package com.myjava.lambda;

public class LambdaThis {
    public static void main(String[] args) {
        new LambdaThis().test();
    }

    public void test() {
        Runnable runnableLambda = () -> check(this);
        runnableLambda.run();
    }

    private void check(Object object) {
        System.out.println(object instanceof Runnable);

    }
}
