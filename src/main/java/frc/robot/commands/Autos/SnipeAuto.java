// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants.Constants.ArmConstants.ArmPosition;
import frc.robot.subsystems.Arm.States.PositionState;
import frc.robot.subsystems.CargoManipulator.States.YeetState;

public class SnipeAuto extends SequentialCommandGroup {

  public SnipeAuto() {
    addCommands(
      new PositionState(ArmPosition.LOW_CARGO).withTimeout(.8),
      new YeetState().withTimeout(2)
    );
  }
}
