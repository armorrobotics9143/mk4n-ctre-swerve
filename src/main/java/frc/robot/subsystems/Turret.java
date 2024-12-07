package frc.robot.subsystems;

import frc.robot.Constants.TurretConstants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANEncoder;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Turret extends SubsystemBase {

    private final CANSparkMax m_turretMotor; // Spark MAX motor controller for the turret
    private final CANEncoder m_encoder; // Encoder to get the turret's current position
    private final SparkMaxPIDController m_pidController; // PID controller for the motor

    private double m_targetAngle;  // Target angle for the turret (degrees)

    // PID constants
    private static final double kP = 0.1;
    private static final double kI = 0.0;
    private static final double kD = 0.0;
    private static final double kF = 0.0;

    public Turret() {
      // Initialize the Spark MAX motor with the NEO motor type
      m_turretMotor = new CANSparkMax(TurretConstants.TURRET_MOTOR_ID, MotorType.kBrushless);
      m_turretMotor.setIdleMode(CANSparkMax.IdleMode.kBrake);  // Set the motor to brake mode for better control

      // Initialize the encoder for feedback
      m_encoder = m_turretMotor.getEncoder();

      // Initialize the PID controller
      m_pidController = m_turretMotor.getPIDController();

      // Set PID coefficients
      m_pidController.setP(kP);
      m_pidController.setI(kI);
      m_pidController.setD(kD);
      m_pidController.setFF(kF);

      // Set the target angle to 0 initially
      m_targetAngle = 0.0;
    }

    // Set the target angle for the turret (in degrees)
    public void setTargetAngle(double targetAngle) {
      this.m_targetAngle = targetAngle;

      // Convert the target angle to encoder units (NEO has 42,000 encoder ticks per revolution)
      double targetTicks = angleToTicks(m_targetAngle);
      m_pidController.setReference(targetTicks, CANSparkMax.ControlType.kPosition);  // Set the reference to the target angle
    }

    // Convert an angle in degrees to encoder ticks (NEO encoder has 42,000 ticks per revolution)
    private double angleToTicks(double angle) {
      return angle * (42_000 / 360.0);  // Convert angle to encoder ticks
    }

    // Get the current angle of the turret
    public double getCurrentAngle() {
      // Convert encoder ticks back to degrees
      return ticksToAngle(m_encoder.getPosition());
    }

    // Convert encoder ticks back to degrees
    private double ticksToAngle(double ticks) {
      return ticks * (360.0 / 42_000);  // Convert encoder ticks to degrees
    }

    @Override
    public void periodic() {
      // Update SmartDashboard with the target and current angles
      SmartDashboard.putNumber("Turret/Target Angle", m_targetAngle);
      SmartDashboard.putNumber("Turret/Current Angle", getCurrentAngle());
    }
}
