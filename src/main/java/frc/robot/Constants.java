// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/*
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class SmartDashboardConstants {}

  public static class ShuffleboardConstants {}

  // Controller ports for the driver station interface.
  public static class OperatorConstants {
    
    public static final int DRIVER_PORT = 0;
    public static final int OPERATOR_PORT = 1;
  }

  // Information for testing and robot configuration that must be updated consistenly.
  public static class ConfigurationConstants {}
  
  // Properties of non-motor devices.
  public static class DeviceConstants {

    public static final int PIGEON_ID = 2;
    public static final int CANDLE_ID = 3;
  }

  // Physical parts of the robot, such as gearboxes or wheel diameters.
  public static class PhysicalConstants {
    
    // NEO V1.1 nominal voltage.
    public static final int NEO_MAX_VOLTAGE = 12;

    // NEO V1.1 general current limit (40A-60A is advised).
    public static final int NEO_CURRENT_LIMIT = 40;

    // NEO V1.1 empirical free speed (in RPM).
    public static final int NEO_FREE_SPEED = 5676;
  }
}