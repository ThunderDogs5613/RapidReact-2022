// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Telescope.States;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Telescope.TelescopeSubsystem;

public class Idle extends CommandBase {

  private TelescopeSubsystem telescope = TelescopeSubsystem.getInstance();

  public Idle() {
    addRequirements(telescope);
  }

  @Override
  public void initialize() {
    TelescopeSubsystem.getInstance().setSpeed(0);
  }

}
