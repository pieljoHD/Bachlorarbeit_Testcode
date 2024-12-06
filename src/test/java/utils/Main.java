package utils;

public class Main {
    public static void main(String[] args) {
        TestNGRunner runner = new TestNGRunner();
        runner.runAllTests();
        runner.calculateAverageTestRuntime();
    }
}
