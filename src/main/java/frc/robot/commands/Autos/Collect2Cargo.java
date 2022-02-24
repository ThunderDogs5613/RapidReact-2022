// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants.Constants;
import frc.robot.Constants.Constants.ArmConstants.ArmPosition;
import frc.robot.subsystems.Arm.States.PositionState;
import frc.robot.subsystems.CargoManipulator.States.IdleState;
import frc.robot.subsystems.CargoManipulator.States.YeetState;
import frc.robot.subsystems.CargoManipulator.States.YoinkState;
import frc.robot.subsystems.Drivetrain.States.PathFollowing;


public class Collect2Cargo extends SequentialCommandGroup {

  public Collect2Cargo() {
 
    addCommands(
      race(
        new PathFollowing(pathToFollow),  //first cargo to collect
        new PositionState(ArmPosition.LOW),
        new YoinkState()
      ),
      new PathFollowing(pathToFollow),  //second cargo to yoink
      race(
        new PathFollowing(pathToFollow),  //position to score
        new PositionState(ArmPosition.HIGH),
        new IdleState()
      ),
      new YeetState()


    );
  }
}
