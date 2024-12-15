package org.example.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimulatorManager {
    private static SimulatorManager instance;

    private List<Simulator> availabelAndroidDevices;

    private SimulatorManager(List<Simulator> deviceList) {
        availabelAndroidDevices = deviceList;
    }

    public static synchronized SimulatorManager getInstance() {
        if (instance == null) {
            System.out.println("Create simulator manager");
            List<Simulator> deviceList = new ArrayList<>(
                    Arrays.asList(
                            new Simulator("Android","emulator-5554",8100),
                            new Simulator("Android","emulator-5554",8100),
                            new Simulator("Android","emulator-5554",8100),
                            new Simulator("Android","emulator-5554",8100),

                            new Simulator("Android","emulator-5554",8100),
                            new Simulator("Android","emulator-5554",8100),
                            new Simulator("Android","emulator-5554",8100),
                            new Simulator("Android","emulator-5554",8100)
                    )
            );

            instance = new SimulatorManager(deviceList);
        }
        return instance;
    }

    public synchronized Simulator getAvailableAndroidDevice() {
        Simulator device =  availabelAndroidDevices.getFirst();
        availabelAndroidDevices.removeFirst();
        return device;
    }

    public synchronized void setDeviceAvailable(String device) {
        System.out.println("Free device: " + device);
        availabelAndroidDevices.add(device);
    }
}

