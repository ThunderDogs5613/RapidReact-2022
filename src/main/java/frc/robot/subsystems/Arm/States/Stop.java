// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Arm.States;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm.ArmSubsystem;

public class Stop extends CommandBase {

  public Stop() {
    addRequirements(ArmSubsystem.getInstance());
  }

  @Override
  public void initialize() {
    ArmSubsystem.getInstance().setPower(0);
  }

  @Override
  public void execute() {
    ArmSubsystem.getInstance().setPower(0);
  }

  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
