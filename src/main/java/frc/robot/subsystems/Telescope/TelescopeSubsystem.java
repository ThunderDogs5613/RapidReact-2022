// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Telescope;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RobotMap;

public class TelescopeSubsystem extends SubsystemBase {

  private static TelescopeSubsystem instance;

  private CANSparkMax winchMotor1;
  private CANSparkMax winchMotor2;

  public TelescopeSubsystem() {

    winchMotor1 = new CANSparkMax(RobotMap.WINCH_MOTOR_1_ID, MotorType.kBrushless);
    winchMotor2 = new CANSparkMax(RobotMap.WINCH_MOTOR_2_ID, MotorType.kBrushless);
  }

  public static TelescopeSubsystem getInstance() {
    if (instance == null){
      instance = new TelescopeSubsystem();
    }
    return instance;
  }

  public void setSpeed(double speed) {
    winchMotor1.set(speed);
    winchMotor2.set(speed);
  }

  @Override
  public void periodic() {
  }
}
