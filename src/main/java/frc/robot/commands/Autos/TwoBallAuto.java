// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autos;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants.Constants.ArmConstants.ArmPosition;
import frc.robot.subsystems.Arm.States.PositionState;
import frc.robot.subsystems.CargoManipulator.States.YeetState;
import frc.robot.subsystems.CargoManipulator.States.YoinkState;
import frc.robot.subsystems.Drivetrain.States.SetAutonArcade;
import frc.robot.subsystems.CargoManipulator.States.IdleState;

public class TwoBallAuto extends SequentialCommandGroup {

  public TwoBallAuto() {

    addCommands(
      race(
        new PositionState(ArmPosition.LOW_CARGO),
        new SetAutonArcade(.3, 0).withTimeout(2),
        new YoinkState()
      ),
      race(
        new PositionState(ArmPosition.HIGH_CARGO),
        new SetAutonArcade(0, -.2).withTimeout(1.2),
        new IdleState()
      ),
        new PositionState(ArmPosition.HIGH_CARGO),
        new SetAutonArcade(.3, 0).withTimeout(4),
        new YeetState().withTimeout(2),
        new IdleState()
      
    );
  }
}
