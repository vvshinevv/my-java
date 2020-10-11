package com.myjava.lambda;

public class LambdaThis {
    public static void main(String[] args) {
        new LambdaThis().test();
    }

    public void test() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                check(this);
            }
        };
        runnable.run();


        Runnable runnableLambda = () -> check(this);
        runnableLambda.run();
    }

    private void check(Object object) {
        System.out.println(object instanceof Runnable);

    }
}
