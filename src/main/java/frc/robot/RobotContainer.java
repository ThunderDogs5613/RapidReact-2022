// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Arm.ArmSubsystem;
import frc.robot.subsystems.Arm.States.ManualLower;
import frc.robot.subsystems.Arm.States.ManualRaise;
import frc.robot.subsystems.Arm.States.PositionState;
import frc.robot.subsystems.Arm.States.PrintArmPosition;
import frc.robot.subsystems.CargoManipulator.CargoManipulatorSubsystem;
import frc.robot.subsystems.CargoManipulator.States.IdleState;
import frc.robot.subsystems.CargoManipulator.States.YeetState;
import frc.robot.subsystems.CargoManipulator.States.YoinkState;
import frc.robot.subsystems.Drivetrain.DrivetrainSubsystem;
import frc.robot.subsystems.Drivetrain.States.OpenLoopState;
import frc.robot.Constants.ControllerMap;
import frc.robot.Constants.Constants.ArmConstants.ArmPosition;
import frc.robot.Constants.ControllerMap.Logitech_Controller;
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

  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();  //review this line when making real autonomous mode(s)
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);  //review this line when making real autonomous mode(s)

  public RobotContainer() {
    initalizeSubsystems();
    configureButtonBindings();
    setAllDefaultCommands();
  }

  private void initalizeSubsystems() {
    drive = DrivetrainSubsystem.getInstance();
    cM = CargoManipulatorSubsystem.getInstance();
    arm = ArmSubsystem.getInstance();


  }

  private void setAllDefaultCommands() {
    CommandScheduler.getInstance().setDefaultCommand(drive, new OpenLoopState());
    CommandScheduler.getInstance().setDefaultCommand(cM,new IdleState());
    CommandScheduler.getInstance().setDefaultCommand(arm, new PrintArmPosition());
  }

  private void configureButtonBindings() {
    new JoystickButton(ControllerMap.getDriveStick(), Logitech_Controller.Button.TRIGGER).whileHeld(new YoinkState());
    new JoystickButton(ControllerMap.getDriveStick(), Logitech_Controller.Button.THUMB).whileHeld(new YeetState());
    new JoystickButton(ControllerMap.getDriveStick(), Logitech_Controller.Button.B6).whileHeld(new ManualRaise());
    new JoystickButton(ControllerMap.getDriveStick(), Logitech_Controller.Button.B4).whileHeld(new ManualLower());
    new JoystickButton(ControllerMap.getDriveStick(), Logitech_Controller.Button.B3).whenPressed(new PositionState(ArmPosition.LOW));
    new JoystickButton(ControllerMap.getDriveStick(), Logitech_Controller.Button.B5).whenPressed(new PositionState(ArmPosition.HIGH));
  }

  
  public Command getAutonomousCommand() {
    return m_autoCommand;
  }
}
