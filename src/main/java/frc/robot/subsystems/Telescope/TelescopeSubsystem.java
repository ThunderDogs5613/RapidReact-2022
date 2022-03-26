// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Telescope;

import com.ctre.phoenix.sensors.CANCoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RobotMap;

public class TelescopeSubsystem extends SubsystemBase {

  private static TelescopeSubsystem instance;

  private CANSparkMax winchMotor1;
  private CANSparkMax winchMotor2;
  private CANCoder winchEncoder;

  public TelescopeSubsystem() {

    winchMotor1 = new CANSparkMax(RobotMap.WINCH_MOTOR_1_ID, MotorType.kBrushless);
    winchMotor2 = new CANSparkMax(RobotMap.WINCH_MOTOR_2_ID, MotorType.kBrushless);
    
  }

  @Override
  public void periodic() {
  }
}
