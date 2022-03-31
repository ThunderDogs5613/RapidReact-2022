package frc.robot.subsystems.Drivetrain.States;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ControllerMap;
import frc.robot.subsystems.Drivetrain.DrivetrainSubsystem;

public class HangarDrive extends CommandBase {
    
    DrivetrainSubsystem drive = DrivetrainSubsystem.getInstance();

    public HangarDrive() {
        addRequirements(drive);
    }

    @Override
  public void execute() {
    double throttle = ControllerMap.getDriveStick().getRawAxis(ControllerMap.Logitech_Controller.Axis.STICK_Y) * .4;
    double rotation = ControllerMap.getDriveStick().getRawAxis(ControllerMap.Logitech_Controller.Axis.STICK_Z);

    DrivetrainSubsystem.getInstance().setArcade(throttle, rotation);
  }



}
