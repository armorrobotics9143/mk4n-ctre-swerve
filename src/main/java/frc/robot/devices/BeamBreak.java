// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.devices;

import edu.wpi.first.wpilibj.DigitalInput;

public class BeamBreak {
    private final DigitalInput beamBreak;

    /**
     * Initializes a BeamBreakSensor connected to the specified DIO port.
     *
     * @param dioPort The Digital Input/Output (DIO) port number.
     */
    public BeamBreak(int dioPort) {
        beamBreak = new DigitalInput(dioPort);
    }

    /**
     * Checks if the beam is broken.
     *
     * @return True if the beam is broken (i.e., an object is interrupting the beam).
     */
    public boolean isBeamBroken() {
        return !beamBreak.get(); // Assumes the sensor outputs LOW when the beam is broken
    }

    /**
     * Checks if the beam is intact (not broken).
     *
     * @return True if the beam is intact (i.e., no object is interrupting the beam).
     */
    public boolean isBeamIntact() {
        return beamBreak.get();
    }

    /**
     * Provides the raw value from the sensor.
     *
     * @return The raw digital input value (true = beam intact, false = beam broken).
     */
    public boolean getRaw() {
        return beamBreak.get();
    }
}