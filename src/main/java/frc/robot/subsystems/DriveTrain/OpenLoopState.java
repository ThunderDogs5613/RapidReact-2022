// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.ControllerMap;

public class OpenLoopState extends CommandBase {
  public OpenLoopState() {
    addRequirements(DriveTrain.getInstance());
  }

    @Override
  public void execute() {
    double throttle = ControllerMap.getDriveStick().getRawAxis(ControllerMap.XBox_Controller.Axis.LEFT_STICK_Y);
    double rotation = ControllerMap.getDriveStick().getRawAxis(ControllerMap.XBox_Controller.Axis.RIGHT_STICK_X);
    DriveTrain.getInstance().setArcade(throttle, rotation);
  }


}
