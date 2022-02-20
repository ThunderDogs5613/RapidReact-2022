// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Arm.States;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Constants.ArmConstants.ArmPosition;
import frc.robot.subsystems.Arm.ArmSubsystem;

public class PositionState extends CommandBase {

  private ArmPosition position;

  public PositionState(ArmPosition position) {
    addRequirements(ArmSubsystem.getInstance());  

    this.position = position;
  }

  @Override
  public void initialize() {
    switch(position) {
      case LOW :
        ArmSubsystem.getInstance().setSetpoint(Constants.ArmConstants.LowPosition);
        break;

      case HIGH :
        ArmSubsystem.getInstance().setSetpoint(Constants.ArmConstants.HighPosition);
        break;  
    }
    ArmSubsystem.getInstance().enable();
  }

  @Override
  public void end(boolean interrupted) {
    ArmSubsystem.getInstance().disable();
  }
}
