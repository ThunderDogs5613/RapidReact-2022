// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Arm.States;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm.ArmSubsystem;


public class HoldPosition extends CommandBase {

  private ArmSubsystem arm = ArmSubsystem.getInstance();

  private double holdArmPos;
  private double currentArmPos;

  public HoldPosition() {
    addRequirements(arm);
  }

  @Override
  public void initialize() {

    arm.setSpeed(0);                    //delete line after encoder and PID setup

    //holdArmPos = arm.getArmPosition();    //leave commented until Encoder and PID setup
  }

  @Override
  public void execute() {
    currentArmPos = arm.getArmPosition();

   /* if (currentArmPos < holdArmPos) {     //////
      arm.setSpeed(.1);                         //
    }                                           //
    else if (currentArmPos > holdArmPos) {      //
      arm.setSpeed(-.1);                        //////  //leave commented until Encoder and PID setup
    }                                           //
    else {                                      //
      arm.setSpeed(0);                          //
    } */                                    //////
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
