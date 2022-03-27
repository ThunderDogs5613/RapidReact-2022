// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Arm.States;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.Constants;
import frc.robot.Constants.Constants.ArmConstants.ArmPosition;
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
      case LOW_CARGO :
        ArmSubsystem.getInstance().setSetpoint(Constants.ArmConstants.LowCargoPosition);
        ArmSubsystem.getInstance().setFeedForward(0.02);
        break;

      case HIGH_CARGO :
        ArmSubsystem.getInstance().setSetpoint(Constants.ArmConstants.HighCargoPosition);
        ArmSubsystem.getInstance().setFeedForward(0.01);
        break;  

      case CLIMB_BACK :

        break;

      case CLIMB_UP :

        break;

      case HOLD :

        break;
    }
    ArmSubsystem.getInstance().enable();
  }

  public void execute() {
    System.out.println(ArmSubsystem.getInstance().getArmPosition());
  }

  @Override
  public void end(boolean interrupted) {
    ArmSubsystem.getInstance().disable();
  }
}
