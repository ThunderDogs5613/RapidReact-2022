// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.CargoManipulator;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RobotMap;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class CargoManipulatorSubsystem extends SubsystemBase {
  
  private static CargoManipulatorSubsystem instance;
  private CANSparkMax intakeRoller;

  private CargoManipulatorSubsystem() {
    intakeRoller = new CANSparkMax(RobotMap.INTAKE_ROLLER_MOTOR_ID, MotorType.kBrushless);
  }

  public static CargoManipulatorSubsystem getInstance() {
    if (instance == null){
      instance = new CargoManipulatorSubsystem();
    }
    return instance;
  }
  public void setSpeed(double speed) {
  intakeRoller.set(speed);
  }
  
  @Override
  public void periodic() {} 
}
