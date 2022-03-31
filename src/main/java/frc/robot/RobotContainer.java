// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//
//import frc.robot.commands.Autos.Collect2Cargo;
import frc.robot.commands.Autos.ScoreAndDrive;
import frc.robot.commands.Autos.TestAuto;
import frc.robot.subsystems.Arm.ArmSubsystem;
import frc.robot.subsystems.Arm.States.PositionState;
import frc.robot.subsystems.CargoManipulator.CargoManipulatorSubsystem;
import frc.robot.subsystems.CargoManipulator.States.IdleState;
import frc.robot.subsystems.CargoManipulator.States.YeetState;
import frc.robot.subsystems.CargoManipulator.States.YoinkState;
import frc.robot.subsystems.Drivetrain.DrivetrainSubsystem;
import frc.robot.subsystems.Drivetrain.States.HangarDrive;
import frc.robot.subsystems.Drivetrain.States.OpenLoopState;
import frc.robot.subsystems.Telescope.TelescopeSubsystem;
import frc.robot.subsystems.Telescope.States.Idle;
import frc.robot.subsystems.Telescope.States.Lower;
import frc.robot.subsystems.Telescope.States.Raise;
import frc.robot.Constants.ControllerMap;
import frc.robot.Constants.Constants.ArmConstants.ArmPosition;
import frc.robot.Constants.ControllerMap.Logitech_Controller;
import frc.robot.Constants.ControllerMap.Generic_Button_Pad;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;



/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  DrivetrainSubsystem drive;
  CargoManipulatorSubsystem cM;
  ArmSubsystem arm;
  TelescopeSubsystem telescope;

  public RobotContainer() {
    initalizeSubsystems();
    configureButtonBindings();
    setAllDefaultCommands();
  }

  private void initalizeSubsystems() {
    drive = DrivetrainSubsystem.getInstance();
    cM = CargoManipulatorSubsystem.getInstance();
    arm = ArmSubsystem.getInstance();
    telescope = TelescopeSubsystem.getInstance();


  }

  private void setAllDefaultCommands() {
    CommandScheduler.getInstance().setDefaultCommand(drive, new OpenLoopState());
    CommandScheduler.getInstance().setDefaultCommand(cM,new IdleState());
    CommandScheduler.getInstance().setDefaultCommand(telescope, new Idle());
    CommandScheduler.getInstance().setDefaultCommand(arm, new PositionState(ArmPosition.HOLD));
  }

  private void configureButtonBindings() {
    new JoystickButton(ControllerMap.getDriveStick(), Logitech_Controller.Button.TRIGGER).whileHeld(new YoinkState());
    new JoystickButton(ControllerMap.getDriveStick(), Logitech_Controller.Button.THUMB).whileHeld(new YeetState());
    new JoystickButton(ControllerMap.getDriveStick(), Logitech_Controller.Button.B3).whenPressed(new PositionState(ArmPosition.LOW_CARGO));
    new JoystickButton(ControllerMap.getDriveStick(), Logitech_Controller.Button.B5).whenPressed(new PositionState(ArmPosition.HIGH_CARGO));
    new JoystickButton(ControllerMap.getButtonPad(), Generic_Button_Pad.Button.B1).whileHeld(new HangarDrive());
    new JoystickButton(ControllerMap.getButtonPad(), Generic_Button_Pad.Button.B9).whileHeld(new Raise());
    new JoystickButton(ControllerMap.getButtonPad(), Generic_Button_Pad.Button.B12).whileHeld(new Lower());
  }

  
  public Command getAutonomousCommand() {
    return new TestAuto();
  }
}
