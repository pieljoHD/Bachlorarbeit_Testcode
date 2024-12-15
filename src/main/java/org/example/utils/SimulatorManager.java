package org.example.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimulatorManager {
    private static SimulatorManager instance;

    private List<String> availabelDevices;

    private SimulatorManager(List<String> deviceList) {
        availabelDevices = deviceList;
    }

    public static synchronized SimulatorManager getInstance() {
        if (instance == null) {
            System.out.println("Create simulator manager");
            List<String> deviceList = new ArrayList<>(Arrays.asList("emulator-5554", "emulator-5556", "emulator-5558", "emulator-5560"));

            instance = new SimulatorManager(deviceList);
        }
        return instance;
    }

    public synchronized String getAvailableDevice() {
        String device =  availabelDevices.getFirst();
        availabelDevices.removeFirst();
        return device;
    }

    public synchronized void setDeviceAvailable(String device) {
        System.out.println("Free device: " + device);
        availabelDevices.add(device);
    }
}

