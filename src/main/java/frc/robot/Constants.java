// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot;

import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.Pigeon2Configuration;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.mechanisms.swerve.SwerveDrivetrainConstants;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModule.ClosedLoopOutputType;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModuleConstants;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModuleConstants.SteerFeedbackType;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModuleConstantsFactory;

import edu.wpi.first.math.util.Units;
import frc.robot.subsystems.Swerve;

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
  
  public static class SwerveConstants {

    // Theoretical free speed (m/s) at 12v applied output;
    // This needs to be tuned to your individual robot
    public static final double SPEED_AT_12_VOLTS_MPS = 5.95;

    // Every 1 rotation of the azimuth results in kCoupleRatio drive motor turns;
    // This may need to be tuned to your individual robot
    public static final double COUPLE_RATIO = 0;

    public static final double DRIVE_GEAR_RATIO = 5.36;
    public static final double STEER_GEAR_RATIO = 18.75;
    public static final double WHEEL_RADIUS_INCHES = 2;

    public static final boolean INVERT_LEFT_SIDE = false;
    public static final boolean INVERT_RIGHT_SIDE = true;

    public static final int DRIVE_MOTOR_CURRENT_LIMIT = 100;
    public static final int STEER_MOTOR_CURRENT_LIMIT = 80;

    public static final String CANBUS_NAME = "";
    public static final int PIGEON_ID = 2;

    // Configs for the Pigeon 2; leave this null to skip applying Pigeon 2 configs
    public static final Pigeon2Configuration pigeonConfigs = null;

    // These are only used for simulation
    public static final double STEER_INERTIA = 0.00001;
    public static final double DRIVE_INERTIA = 0.001;
    
    // Simulated voltage necessary to overcome friction
    public static final double STEER_FRICTION_VOLTAGE = 0.25;
    public static final double DRIVE_FRICTION_VOLTAGE = 0.25;

    // Both sets of gains need to be tuned to your individual robot.

    // The steer motor uses any SwerveModule.SteerRequestType control request with the
    // output type specified by SwerveModuleConstants.SteerMotorClosedLoopOutput
    public static final Slot0Configs steerGains = new Slot0Configs()
        .withKP(100).withKI(0).withKD(0.2)
        .withKS(0).withKV(1.5).withKA(0);
    
    // When using closed-loop control, the drive motor uses the control
    // output type specified by SwerveModuleConstants.DriveMotorClosedLoopOutput
    public static final Slot0Configs driveGains = new Slot0Configs()
        .withKP(3).withKI(0).withKD(0)
        .withKS(0).withKV(0).withKA(0);

    // The closed-loop output type to use for the steer motors;
    // This affects the PID/FF gains for the steer motors
    public static final ClosedLoopOutputType steerClosedLoopOutput = ClosedLoopOutputType.Voltage;
    
    // The closed-loop output type to use for the drive motors;
    // This affects the PID/FF gains for the drive motors
    public static final ClosedLoopOutputType driveClosedLoopOutput = ClosedLoopOutputType.Voltage;

    // The stator current at which the wheels start to slip;
    // This needs to be tuned to your individual robot
    public static final double SLIP_CURRENT_A = 150.0;

    // Initial configs for the drive and steer motors and the CANcoder; these cannot be null.
    // Some configs will be overwritten; check the `with*InitialConfigs()` API documentation.
    public static final TalonFXConfiguration driveInitialConfigs = new TalonFXConfiguration()
        .withCurrentLimits(
            new CurrentLimitsConfigs()
                // Swerve drive motor requires some torque output, so we can set a medium
                // stator current limit to help avoid brownouts without significantly impacting performance.
                .withStatorCurrentLimit(DRIVE_MOTOR_CURRENT_LIMIT)
                .withStatorCurrentLimitEnable(true)
        );
    
    public static final TalonFXConfiguration steerInitialConfigs = new TalonFXConfiguration()
        .withCurrentLimits(
            new CurrentLimitsConfigs()
                // Swerve azimuth motor does not require much torque output, so we can set a relatively low
                // stator current limit to help avoid brownouts without impacting performance.
                .withStatorCurrentLimit(STEER_MOTOR_CURRENT_LIMIT)
                .withStatorCurrentLimitEnable(true)
        );
    
    public static final CANcoderConfiguration cancoderInitialConfigs = new CANcoderConfiguration();

    public static final SwerveDrivetrainConstants DrivetrainConstants = new SwerveDrivetrainConstants()
        .withCANbusName(CANBUS_NAME)
        .withPigeon2Id(PIGEON_ID)
        .withPigeon2Configs(pigeonConfigs);

    public static final SwerveModuleConstantsFactory ConstantCreator = new SwerveModuleConstantsFactory()
        .withDriveMotorGearRatio(DRIVE_GEAR_RATIO)
        .withSteerMotorGearRatio(STEER_GEAR_RATIO)
        .withWheelRadius(WHEEL_RADIUS_INCHES)
        .withSlipCurrent(SLIP_CURRENT_A)
        .withSteerMotorGains(steerGains)
        .withDriveMotorGains(driveGains)
        .withSteerMotorClosedLoopOutput(steerClosedLoopOutput)
        .withDriveMotorClosedLoopOutput(driveClosedLoopOutput)
        .withSpeedAt12VoltsMps(SPEED_AT_12_VOLTS_MPS)
        .withSteerInertia(STEER_INERTIA)
        .withDriveInertia(DRIVE_INERTIA)
        .withSteerFrictionVoltage(STEER_FRICTION_VOLTAGE)
        .withDriveFrictionVoltage(DRIVE_FRICTION_VOLTAGE)
        .withFeedbackSource(SteerFeedbackType.FusedCANcoder)
        .withCouplingGearRatio(COUPLE_RATIO)
        .withDriveMotorInitialConfigs(driveInitialConfigs)
        .withSteerMotorInitialConfigs(steerInitialConfigs)
        .withCANcoderInitialConfigs(cancoderInitialConfigs);

    // Front Left
    public static final int FRONT_LEFT_DRIVE_MOTOR_ID = 41;
    public static final int FRONT_LEFT_STEER_MOTOR_ID = 42;
    public static final int FRONT_LEFT_ENCODER_ID = 43;
    public static final double FRONT_LEFT_ENCODER_OFFSET = 0.3056640625;
    public static final boolean FRONT_LEFT_STEER_INVERT = true;
    public static final double FRONT_LEFT_X_POS_INCHES = 12.375;
    public static final double FRONT_LEFT_Y_POS_INCHES = 12.375;

    // Front Right
    public static final int FRONT_RIGHT_DRIVE_MOTOR_ID = 11;
    public static final int FRONT_RIGHT_STEER_MOTOR_ID = 12;
    public static final int FRONT_RIGHT_ENCODER_ID = 13;
    public static final double FRONT_RIGHT_ENCODER_OFFSET = 0.270263671875;
    public static final boolean FRONT_RIGHT_STEER_INVERT = true;
    public static final double FRONT_RIGHT_X_POS_INCHES = 12.375;
    public static final double FRONT_RIGHT_Y_POS_INCHES = -12.375;

    // Back Left
    public static final int BACK_LEFT_DRIVE_MOTOR_ID = 31;
    public static final int BACK_LEFT_STEER_MOTOR_ID = 32;
    public static final int BACK_LEFT_ENCODER_ID = 33;
    public static final double BACK_LEFT_ENCODER_OFFSET = 0.0859375;
    public static final boolean BACK_LEFT_STEER_INVERT = true;
    public static final double BACK_LEFT_X_POS_INCHES = -12.375;
    public static final double BACK_LEFT_Y_POS_INCHES = 12.375;

    // Back Right
    public static final int BACK_RIGHT_DRIVE_MOTOR_ID = 21;
    public static final int BACK_RIGHT_STEER_MOTOR_ID = 22;
    public static final int BACK_RIGHT_ENCODER_ID = 23;
    public static final double BACK_RIGHT_ENCODER_OFFSET = -0.082763671875;
    public static final boolean BACK_RIGHT_STEER_INVERT = true;
    public static final double BACK_RIGHT_X_POS_INCHES = -12.375;
    public static final double BACK_RIGHT_Y_POS_INCHES = -12.375;

    public static final SwerveModuleConstants FrontLeft = ConstantCreator.createModuleConstants(
            FRONT_LEFT_STEER_MOTOR_ID, FRONT_LEFT_DRIVE_MOTOR_ID, FRONT_LEFT_ENCODER_ID, FRONT_LEFT_ENCODER_OFFSET, Units.inchesToMeters(FRONT_LEFT_X_POS_INCHES), Units.inchesToMeters(FRONT_LEFT_Y_POS_INCHES), INVERT_LEFT_SIDE)
            .withSteerMotorInverted(FRONT_LEFT_STEER_INVERT);
    
    public static final SwerveModuleConstants FrontRight = ConstantCreator.createModuleConstants(
            FRONT_RIGHT_STEER_MOTOR_ID, FRONT_RIGHT_DRIVE_MOTOR_ID, FRONT_RIGHT_ENCODER_ID, FRONT_RIGHT_ENCODER_OFFSET, Units.inchesToMeters(FRONT_RIGHT_X_POS_INCHES), Units.inchesToMeters(FRONT_RIGHT_Y_POS_INCHES), INVERT_RIGHT_SIDE)
            .withSteerMotorInverted(FRONT_RIGHT_STEER_INVERT);
    
    public static final SwerveModuleConstants BackLeft = ConstantCreator.createModuleConstants(
            BACK_LEFT_STEER_MOTOR_ID, BACK_LEFT_DRIVE_MOTOR_ID, BACK_LEFT_ENCODER_ID, BACK_LEFT_ENCODER_OFFSET, Units.inchesToMeters(BACK_LEFT_X_POS_INCHES), Units.inchesToMeters(BACK_LEFT_Y_POS_INCHES), INVERT_LEFT_SIDE)
            .withSteerMotorInverted(BACK_LEFT_STEER_INVERT);
    
    public static final SwerveModuleConstants BackRight = ConstantCreator.createModuleConstants(
            BACK_RIGHT_STEER_MOTOR_ID, BACK_RIGHT_DRIVE_MOTOR_ID, BACK_RIGHT_ENCODER_ID, BACK_RIGHT_ENCODER_OFFSET, Units.inchesToMeters(BACK_RIGHT_X_POS_INCHES), Units.inchesToMeters(BACK_RIGHT_Y_POS_INCHES), INVERT_RIGHT_SIDE)
            .withSteerMotorInverted(BACK_RIGHT_STEER_INVERT);

    public static final Swerve Drivetrain = new Swerve(DrivetrainConstants, FrontLeft,
            FrontRight, BackLeft, BackRight);
  }
}