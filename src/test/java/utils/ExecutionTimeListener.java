package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;

public class ExecutionTimeListener implements ITestListener {
    private long startTime;
    private long endTime;

    @Override
    public void onStart(ITestContext context) {
        startTime = System.currentTimeMillis();
        System.out.println("Starting test class: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Finished test class: " + context.getName() + ". Duration: " + duration + " ms");
    }
}


