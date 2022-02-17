// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.CargoManipulator.CargoManipulatorSubsystem;
import frc.robot.subsystems.CargoManipulator.States.IdleState;
import frc.robot.subsystems.CargoManipulator.States.YoinkState;
import frc.robot.subsystems.Drivetrain.DrivetrainSubsystem;
import frc.robot.subsystems.Drivetrain.States.OpenLoopState;
import frc.robot.ControllerMap.Logitech_Controller;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;



/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final DrivetrainSubsystem drivetrain = DrivetrainSubsystem.getInstance();
  private final CargoManipulatorSubsystem cargoManipulator = CargoManipulatorSubsystem.getInstance();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  public RobotContainer() {
    configureButtonBindings();
    setAllDefaultCommands();
  }

  private void setAllDefaultCommands() {
    CommandScheduler.getInstance().setDefaultCommand(drivetrain, new OpenLoopState());
    CommandScheduler.getInstance().setDefaultCommand(cargoManipulator,new IdleState());
  }

  private void configureButtonBindings() {
    new JoystickButton(ControllerMap.getDriveStick(), Logitech_Controller.Button.TRIGGER).whileActiveOnce(new YoinkState());

  }

  
  public Command getAutonomousCommand() {
    return m_autoCommand;
  }
}
