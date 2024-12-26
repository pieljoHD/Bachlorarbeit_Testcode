package org.example.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimulatorManager {
    private static SimulatorManager instance;

    private final List<Simulator> availableSimulators;

    private SimulatorManager(List<Simulator> deviceList) {
        availableSimulators = deviceList;
    }

    public static synchronized SimulatorManager getInstance() {
        if (instance == null) {
            System.out.println("Create simulator manager");
            List<Simulator> deviceList = new ArrayList<>(
                    Arrays.asList(
                            new Simulator(Constants.Android,"emulator-5554",8100),
                            new Simulator(Constants.Android,"emulator-5556",8100),
                            new Simulator(Constants.Android,"emulator-5558",8100),
                            new Simulator(Constants.Android,"emulator-5560",8100),

                            new Simulator(Constants.IOS,"2FD1A406-EC0D-4C71-A112-33F516F861EA",8101),
                            new Simulator(Constants.IOS,"48DA9BFA-5470-4DE9-800F-EF3B38F9FB0F",8102),
                            new Simulator(Constants.IOS,"A8D37CCA-56FD-4A41-BD50-1B89A107E415",8103),
                            new Simulator(Constants.IOS,"FB64B13E-FE8D-45D7-96D1-28B1341A55BD",8104)
                    )
            );
            instance = new SimulatorManager(deviceList);
        }
        return instance;
    }

    public Simulator getAvailableSimulator(String platform) {
        Simulator simulator = getAvailableSimulatorFromList(platform);
        if(simulator.driver == null) {
            AppiumDriverBuilder appiumDriverBuilder = new AppiumDriverBuilder();
            if(platform.equals(Constants.Android)) {
                simulator.driver = appiumDriverBuilder.installAndroidAppAndGetDriver(simulator);
            } else if(platform.equals(Constants.IOS)) {
                simulator.driver = appiumDriverBuilder.getDriverIOSSession(simulator);
            }
        }
        System.out.println("Start with device: " + simulator.uuid + " and Driver " + simulator.driver);
        return simulator;
    }

    private synchronized Simulator getAvailableSimulatorFromList(String platform) {
        for (Simulator simulator : availableSimulators) {
            if (platform.equals(simulator.platform)) {
                availableSimulators.remove(simulator);
                return simulator;
            }
        }
        throw new RuntimeException("No available simulator for " + platform);
    }

    public synchronized void setDeviceAvailable(Simulator simulator) {
        System.out.println("Free device: " + simulator.uuid);
        availableSimulators.add(simulator);
    }
}

