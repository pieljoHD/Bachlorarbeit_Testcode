package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExecutionTimeListener implements ITestListener {
    private long startTime;
    private final List<ITestResult> passedTests = new ArrayList<>();
    private final List<ITestResult> failedTests = new ArrayList<>();

    @Override
    public void onTestSuccess(ITestResult result) {
        passedTests.add(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        failedTests.add(result);
    }

    @Override
    public void onStart(ITestContext context) {
        startTime = System.currentTimeMillis();
    }

    @Override
    public void onFinish(ITestContext context) {
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        FileWriter myWriter;
        try {
            myWriter = new FileWriter(
                    "/Users/johannespielmeier/Bachlorarbeit/Test_code/TestCodeBachlorarbeit/src/main/java/org/example/TestResults.txt",
                    true
            );
            myWriter.write("\nFinished test class:" + context.getName() + "," + "Duration:" + duration + "ms");
            myWriter.write("\nPassed tests: " + passedTests.size());
            for (ITestResult result : passedTests) {
                myWriter.write("\nPassed: \" + result.getName()");
            }
            myWriter.write("\nFailed tests: " + failedTests.size());
            for (ITestResult result : failedTests) {
                myWriter.write("\nFailed: " + result.getName() + " - " + result.getThrowable());
            }
            myWriter.write("\n------------------------------------------------------------------------");

            passedTests.clear();
            failedTests.clear();
            myWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


