// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer();

    m_robotContainer.drivetrain.getDaqThread().setThreadPriority(99);

    /*
    // Initialize the CANdle
    CANdle candle = new CANdle(3); // Set the correct CAN ID for the CANdle

    // Configure CANdle settings if necessary
    CANdleConfiguration config = new CANdleConfiguration();
    config.stripType = LEDStripType.GRB;
    config.brightnessScalar = 0.5;
    candle.configAllSettings(config);

    candle.setLEDs(255, 255, 255);

    // RainbowAnimation rainbowAnim = new RainbowAnimation(1, 0.5, 60);
    // candle.animate(rainbowAnim);

    // Add a toggle button on Shuffleboard
    ledToggleEntry =
        Shuffleboard.getTab("LED Control") // Create a new tab called "LED Control"
            .add("LED Toggle", ledOn) // Add a toggle entry
            .withWidget("Toggle Button") // Use a toggle button widget
            .getEntry();
    */

    CameraServer.startAutomaticCapture();

  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run(); 
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void disabledExit() {}

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void autonomousExit() {}

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    /*
    // Check if the toggle button has been changed in Shuffleboard
    boolean toggle = ledToggleEntry.getBoolean(true);

    // If the button state has changed, update LED state
    if (toggle != ledOn) {
      ledOn = toggle; // Update the LED state

      if (ledOn) {
        // Turn the LEDs on to the specified color
        candle.setLEDs(color[0], color[1], color[2]);
      } else {
        // Turn the LEDs off (black color)
        setLEDColor(0, 0, 0);
      }

      // Update the toggle state in Shuffleboard
      ledToggleEntry.setBoolean(ledOn);
    }
    */
  }

  float Kp = -0.1f;
  float min_command = 0.05f;

  /*
  std::shared_ptr<NetworkTable> table = NetworkTable:: GetTable("limelight");
   float tx = table->GetNumber("tx");

    if (joystick->GetRawButton(9))
  {
  	float heading_error = -tx;
  	float steering_adjust = 0.0f;
  	if (Math.abs(heading_error) > 1.0)
  	{
  		if (heading_error < 0)
  		{
  			steering_adjust = Kp*heading_error + min_command;
  		}
  		else
  		{
  			steering_adjust = Kp*heading_error - min_command;
  		}
  	}

  	left_command += steering_adjust;
  	right_command -= steering_adjust;
  }
  */

  @Override
  public void teleopExit() {}

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  @Override
  public void testExit() {}

  @Override
  public void simulationPeriodic() {}

  /*
  // Helper method to set the LED color
  public void setLEDColor(int g, int r, int b) {
    candle.setLEDs(g, r, b); // Sets LEDs to the specified RGB color
  }
  */
}
