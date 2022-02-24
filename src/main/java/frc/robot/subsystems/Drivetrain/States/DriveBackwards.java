// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Drivetrain.States;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain.DrivetrainSubsystem;

public class DriveBackwards extends CommandBase {


  public DriveBackwards() {
    addRequirements(DrivetrainSubsystem.getInstance());
  }

  @Override
  public void initialize() {
    DrivetrainSubsystem.getInstance().setPower(-.4, -.4);
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {
    DrivetrainSubsystem.getInstance().setPower(0 , 0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
