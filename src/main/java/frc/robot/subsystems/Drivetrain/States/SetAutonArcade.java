// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Drivetrain.States;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain.DrivetrainSubsystem;

public class SetAutonArcade extends CommandBase {

  double inputThrottle, inputRotation;

  public SetAutonArcade(double inputThrottle, double inputRotation) {
    addRequirements(DrivetrainSubsystem.getInstance());
    this.inputThrottle = inputThrottle;
    this.inputRotation = inputRotation;
  }

  @Override
  public void initialize() {
    DrivetrainSubsystem.getInstance().setAutonPower(inputThrottle, inputRotation);;
  }

  @Override
  public void end(boolean interrupted) {
    DrivetrainSubsystem.getInstance().setPower(0 , 0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
