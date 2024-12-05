// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.devices;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LimitSwitch {
    private final DigitalInput limitSwitch;

    /**
     * Constructor for the REV Magnetic Limit Switch.
     *
     * @param channel the DIO port the limit switch is connected to.
     */
    public LimitSwitch(int channel) {
        limitSwitch = new DigitalInput(channel);
    }

    /**
     * Checks if the limit switch is triggered.
     *
     * @return false if the limit switch is closed, true otherwise.
     */
    public boolean isTriggered() {
        return limitSwitch.get(); // Assuming normally closed switch (returns true when pressed).
    }

    /**
     * Updates the SmartDashboard with the current state of the limit switch.
     */
    public void updateDashboard() {
        SmartDashboard.putBoolean("Limit Switch Triggered", isTriggered());
    }

    /**
     * Periodic function to be called regularly for updating sensor data.
     */
    public void periodic() {
        updateDashboard();
    }
}