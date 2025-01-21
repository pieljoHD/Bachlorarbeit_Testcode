package utils;

import org.testng.TestNG;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestNGRunner {

    public void runAllTests() {
        int numberOfExecutions = 20;

        String suiteFileAndroid = "/Users/johannespielmeier/Bachlorarbeit/Test_code/TestCodeBachlorarbeit/src/test/resources/android/allAndroidTests.xml";

        TestNG testngAndroid = new TestNG();

        for (int i = 0; i < numberOfExecutions; i++) {
            testngAndroid.setTestSuites(Collections.singletonList(suiteFileAndroid));
            testngAndroid.run();
        }

        String suiteFileIOS = "/Users/johannespielmeier/Bachlorarbeit/Test_code/TestCodeBachlorarbeit/src/test/resources/ios/allIOSTests.xml";

        TestNG testngIOS = new TestNG();

        for (int i = 0; i < numberOfExecutions; i++) {
            testngIOS.setTestSuites(Collections.singletonList(suiteFileIOS));
            testngIOS.run();
        }
    }

    public void calculateAverageTestRuntime() {
        String filePath = "/Users/johannespielmeier/Bachlorarbeit/Test_code/TestCodeBachlorarbeit/src/main/java/org/example/TestResults.txt";
        long iosDurationSum = 0;
        int iosTestCount = 0;
        double iosVariance = 0;
        double iosStandardabweichung = 0;

        long androidDurationSum = 0;
        int androidTestCount = 0;
        double androidVariance = 0;
        double androidStandardabweichung = 0;

        List<Double> androidRunTimes = new ArrayList<>(List.of());
        List<Double> iosRunTimes = new ArrayList<>(List.of());

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Finished test class:")) {
                    String[] parts = line.split(",");
                    String testClassName = parts[0].split(":")[1];
                    double duration = Double.parseDouble(parts[1].split(":")[1].replace("ms", ""));

                    if (testClassName.equals("IOS Tests")) {
                        iosRunTimes.add(duration);
                        iosDurationSum += duration;
                        iosTestCount++;
                    } else if (testClassName.equals("Android Tests")) {
                        androidRunTimes.add(duration);
                        androidDurationSum += duration;
                        androidTestCount++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        float averageIOSRuntime = (float) iosDurationSum / iosTestCount;
        float averageAndroidRuntime = (float) androidDurationSum / androidTestCount;

        for (double value : androidRunTimes) {
            double tmp = value - averageAndroidRuntime;
            tmp = Math.pow(tmp, 2);
            androidVariance += (float) (tmp / androidRunTimes.size());
        }

        for (double value : iosRunTimes) {
            iosVariance += (float) (Math.pow(value - averageIOSRuntime, 2) / iosRunTimes.size());
        }

        androidStandardabweichung = Math.sqrt(androidVariance);
        iosStandardabweichung = Math.sqrt(iosVariance);

        FileWriter myWriter;
        try {
            myWriter = new FileWriter(
                    "/Users/johannespielmeier/Bachlorarbeit/Test_code/TestCodeBachlorarbeit/src/main/java/org/example/TestResults.txt",
                    true
            );
            myWriter.write("\n---------------------------------END OF ALL TESTS---------------------------------\n");
            myWriter.write("Durchschnnittliche IOS Testzeit: " + averageIOSRuntime + " ms\n");
            myWriter.write("Varianz IOS: " + iosVariance + "\n");
            myWriter.write("Standardabweichung IOS: " + iosStandardabweichung + "\n");
            myWriter.write("Durchschnnittliche Android Testzeit: " + averageAndroidRuntime + " ms\n");
            myWriter.write("Varianz Android: " + androidVariance + "\n");
            myWriter.write("Standardabweichung Android: " + androidStandardabweichung + "\n");
            myWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
