// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.devices.LimitSwitch;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  private final LimitSwitch limitSwitch = new LimitSwitch(2); // DIO port 2

  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer();

    CameraServer.startAutomaticCapture();

  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();

    limitSwitch.periodic(); // Regularly update the dashboard with switch status.
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
  public void teleopPeriodic() {}

  /*
  float Kp = -0.1f;
  float min_command = 0.05f;

  
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
}
