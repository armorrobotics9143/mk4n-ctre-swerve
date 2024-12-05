// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.devices;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class UltrasonicRangefinder {
    private final Ultrasonic ultrasonic;

    public UltrasonicRangefinder(int pingChannel, int echoChannel) {
        ultrasonic = new Ultrasonic(new DigitalOutput(pingChannel), new DigitalInput(echoChannel));
        ultrasonic.setAutomaticMode(true); // Starts continuous reading in the background.
    }

    /**
     * Returns the current range measured by the ultrasonic sensor in inches.
     *
     * @return the distance in inches
     */
    public double getRangeInches() {
        return ultrasonic.getRangeInches();
    }

    /**
     * Returns the current range measured by the ultrasonic sensor in millimeters.
     *
     * @return the distance in millimeters
     */
    public double getRangeMM() {
        return getRangeInches() * 25.4;
    }

    /**
     * Checks if the current distance measurement is valid.
     *
     * @return true if the range is valid, false otherwise
     */
    public boolean isRangeValid() {
        return ultrasonic.isRangeValid();
    }

    /**
     * Updates the SmartDashboard with the current range and status of the sensor.
     */
    public void updateDashboard() {
        SmartDashboard.putBoolean("Ultrasonic Valid", isRangeValid());
        SmartDashboard.putNumber("Ultrasonic Range (Inches)", getRangeInches());
        SmartDashboard.putNumber("Ultrasonic Range (MM)", getRangeMM());
    }

    /**
     * Periodic function to be called regularly for updating sensor data.
     */
    public void periodic() {
        updateDashboard();
    }
}
