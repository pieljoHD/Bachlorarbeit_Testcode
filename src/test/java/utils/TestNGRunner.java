package utils;

import org.testng.TestNG;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

public class TestNGRunner {

    public void runAllTests() {
        int numberOfExecutions = 20;

        String suiteFileIOS = "/Users/johannespielmeier/Bachlorarbeit/Test_code/TestCodeBachlorarbeit/src/test/resources/ios/allIOSTests.xml";

        TestNG testngIOS = new TestNG();

        for (int i = 0; i < numberOfExecutions; i++) {
            testngIOS.setTestSuites(Collections.singletonList(suiteFileIOS));
            testngIOS.run();
        }

        String suiteFileAndroid = "/Users/johannespielmeier/Bachlorarbeit/Test_code/TestCodeBachlorarbeit/src/test/resources/android/allAndroidTests.xml";

        TestNG testngAndroid = new TestNG();

        for (int i = 0; i < numberOfExecutions; i++) {
            testngAndroid.setTestSuites(Collections.singletonList(suiteFileAndroid));
            testngAndroid.run();
        }
    }

    public void calculateAverageTestRuntime() {
        String filePath = "/Users/johannespielmeier/Bachlorarbeit/Test_code/TestCodeBachlorarbeit/src/main/java/org/example/TestResults.txt";
        long iosDurationSum = 0;
        int iosTestCount = 0;
        long androidDurationSum = 0;
        int androidTestCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Finished test class:")) {
                    String[] parts = line.split(",");
                    String testClassName = parts[0].split(":")[1];
                    long duration = Long.parseLong(parts[1].split(":")[1].replace("ms", ""));

                    if (testClassName.equals("IOS Tests")) {
                        iosDurationSum += duration;
                        iosTestCount++;
                    } else if (testClassName.equals("Android Tests")) {
                        androidDurationSum += duration;
                        androidTestCount++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        float averageIOSLength = (float) iosDurationSum / iosTestCount;
        float averageAndroidLength = (float) androidDurationSum / androidTestCount;

        FileWriter myWriter;
        try {
            myWriter = new FileWriter(
                    "/Users/johannespielmeier/Bachlorarbeit/Test_code/TestCodeBachlorarbeit/src/main/java/org/example/TestResults.txt",
                    true
            );
            myWriter.write("\n---------------------------------END OF ALL TESTS---------------------------------\n");
            myWriter.write("Durchschnnittliche IOS Testzeit: " + averageIOSLength + " ms\n");
            myWriter.write("Durchschnnittliche Android Testzeit: " + averageAndroidLength + " ms\n");
            myWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
