package frc.robot.subsystems.Drivetrain.States;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ControllerMap;
import frc.robot.subsystems.Drivetrain.DrivetrainSubsystem;

public class OpenLoopState extends CommandBase {
    
    DrivetrainSubsystem drive = DrivetrainSubsystem.getInstance();

    public OpenLoopState() {
        addRequirements(drive);
    }

    @Override
  public void execute() {
    double throttle = ControllerMap.getDriveStick().getRawAxis(ControllerMap.Logitech_Controller.Axis.STICK_Y);
    double rotation = ControllerMap.getDriveStick().getRawAxis(ControllerMap.Logitech_Controller.Axis.STICK_Z);

    DrivetrainSubsystem.getInstance().setArcade(throttle, rotation);
  }



}
