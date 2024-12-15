package org.example.utils;

import io.appium.java_client.AppiumDriver;

public class Simulator {
    String platform;
    String uuid;
    int wdaLocalPort;
    AppiumDriver driver = null;
    public Simulator(String platform, String uuid, int wdaLocalPort) {
        this.platform = platform;
        this.uuid = uuid;
        this.wdaLocalPort = wdaLocalPort;
    }
}
