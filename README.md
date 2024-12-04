# mk4n-ctre-swerve

## Overview

Welcome to the `mk4n-ctre-swerve` repository! This project contains the codebase for Team 9143's implementation of a swerve drive system using the **MK4n Swerve Modules** from SDS and the **CTRE Phoenix library**. This code is specifically designed for use in the **FIRST Robotics Competition (FRC)**, leveraging the **WPILib** framework to control a robot with precision and agility.

## Features

- **Swerve Drive Implementation**  
  Includes a fully functional swerve drive with independent control of each module's wheel speed and angle.
  
- **MK4n Swerve Module Support**  
  Optimized for SDS MK4n swerve modules in the Kraken X60 configuration.

- **CTRE Phoenix Integration**  
  Utilizes CTRE's library for motor controllers like the **Talon FX** and sensor integration like the **CANCoder**.

- **PID Control**  
  Precise control over module steering and driving using PID loops.

- **Field-Oriented Control (FOC)**  
  Supports field-oriented driving for intuitive control relative to field orientation.

- **Robot Simulation**  
  WPILib simulation support for testing without physical hardware.

## Code Structure

- **`src/main/java/frc/robot`**  
  Contains the main robot code and subsystems.
  
  - `Robot.java` – Entry point for the robot.
  - `RobotContainer.java` – Initializes subsystems and binds commands for robot control.
  - `Telemetry.java` – Collects and displays real-time robot data for monitoring.
  - `TunerConstants.java` – Defines important configuration constants for the swerve drive subsystem.
  - `Constants.java` – Defines important configuration constants for other subsystems and devices.
  - `CommandSwerveDrivetrain.java` – Handles swerve module control and field-oriented driving.
  - `CANdle.java` – Manages the LED system using CTRE’s CANdle.
  - `Limelight.java` – Handles vision processing from the Limelight camera.
  - `Pathplanner/` – Contains files for autonomous path planning and trajectory following.

## Getting Started

### Prerequisites

Ensure you have the following installed:

- [FRC WPILib Development Environment](https://docs.wpilib.org/en/stable/docs/getting-started/getting-started-frc-control-system.html)
- [CTRE Phoenix Library](https://store.ctr-electronics.com/software/)
- Java Development Kit (JDK) 11 or higher
- Gradle (comes with WPILib)

### Cloning the Repository

Clone this repository to your local machine:

```bash
git clone https://github.com/team-9143/mk4n-ctre-swerve.git
cd mk4n-ctre-swerve
