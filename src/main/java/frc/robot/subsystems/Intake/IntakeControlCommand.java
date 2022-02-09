package frc.robot.subsystems.Intake;
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.ControllerMap;

public class IntakeControlCommand extends CommandBase {
  /** Creates a new IntakeControlCommand. */
  public IntakeControlCommand() {
    addRequirements(IntakeSubsystem.getInstance());
  }

  @Override
  public void execute() {
    if (ControllerMap.getButtonPad().getRawButton(1)) {
      IntakeSubsystem.getInstance().setState(IntakeSubsystem.intakeStates.LowOut);
    }
    else if (ControllerMap.getButtonPad().getRawButton(2)) {
      IntakeSubsystem.getInstance().setState(IntakeSubsystem.intakeStates.LowIn);
    }
    else if (ControllerMap.getButtonPad().getRawButton(3)) {
      IntakeSubsystem.getInstance().setState(IntakeSubsystem.intakeStates.HighIdle);
    }
    else if (ControllerMap.getButtonPad().getRawButton(4)) {
      IntakeSubsystem.getInstance().setState(IntakeSubsystem.intakeStates.HighOut);
    }
    else if (ControllerMap.getButtonPad().getRawButton(5)) {
      IntakeSubsystem.getInstance().setState(IntakeSubsystem.intakeStates.LowIdle);
    }
  }
}
