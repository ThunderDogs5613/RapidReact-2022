// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Telescope.States;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Telescope.TelescopeSubsystem;

public class Raise extends CommandBase {
  public Raise() {
  }

  @Override
  public void execute() {
    TelescopeSubsystem.getInstance().setSpeed(.5);
  }
}
