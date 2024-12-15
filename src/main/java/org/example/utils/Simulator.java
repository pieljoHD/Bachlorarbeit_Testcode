package org.example.utils;

public class Simulator {
    String platform;
    String uuid;
    int wdaLocalPort;
    public Simulator(String platform, String uuid, int wdaLocalPort) {
        this.platform = platform;
        this.uuid = uuid;
        this.wdaLocalPort = wdaLocalPort;
    }
}
