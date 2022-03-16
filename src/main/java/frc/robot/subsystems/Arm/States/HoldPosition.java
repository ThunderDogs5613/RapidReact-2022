// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Arm.States;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm.ArmSubsystem;

public class HoldPosition extends CommandBase {

  public HoldPosition() {
    addRequirements(ArmSubsystem.getInstance());
  }
  private double holdPosition;
  private double currentPosition;
 
  @Override

  public void initialize() {
    holdPosition = ArmSubsystem.getInstance().getArmPosition();
}
  public void execute() {
    System.out.println(ArmSubsystem.getInstance().getArmPosition());
    currentPosition = ArmSubsystem.getInstance().getArmPosition();

    if (currentPosition < holdPosition) {
      ArmSubsystem.getInstance().setPower(-.02);
    }
    else if (currentPosition > holdPosition) {
      ArmSubsystem.getInstance().setPower(.02);
    }
    else {
      ArmSubsystem.getInstance().setPower(0);
    }
  }

}
