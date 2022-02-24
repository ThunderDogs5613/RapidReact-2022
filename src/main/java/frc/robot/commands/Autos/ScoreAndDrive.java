// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.CargoManipulator.States.YeetState;
import frc.robot.subsystems.Drivetrain.States.DriveBackwards;

public class ScoreAndDrive extends SequentialCommandGroup {

  public ScoreAndDrive() {
    
    addCommands(
      new YeetState().withTimeout(2),
      new DriveBackwards().withTimeout(2)
    );
  }
}
