// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

/** Add your docs here. */
public class Pneumatics {

    // creates objects for our compressor and our double solenoid  
    private final Compressor m_compressor = new Compressor(PneumaticsModuleType.CTREPCM);
    private final DoubleSolenoid m_doubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.REVPH, 0, 3);

    // Compressor Methods:

    // Enables the compressor
    public void enableComp()
    {
        m_compressor.enableDigital();
    }

    // Disable the compressor
    public void disableComp()
    {
        m_compressor.disable();
    }

    // Gets the current of the compressor as a double
    public double compCurrent()
    {
        return m_compressor.getCurrent();
    }

    // Checks if the compressor is enabled
    public boolean compEnabled()
    {
        return m_compressor.isEnabled();
    }

    // Checks the pressure switch value
    public boolean pressureSwitchValue()
    {
        return m_compressor.getPressureSwitchValue();
    }

    // Double Solenoid Methods

    // Sets the solenoid in forward
    public void DoubleSolenoidForward()
    {
        m_doubleSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    // Sets the solenoid in reverse
    public void DoubleSolenoidReverse()
    {
        m_doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

}  
