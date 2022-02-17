// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Arm;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class ArmSubsystem extends SubsystemBase {
  
  private static ArmSubsystem instance;

  private CANSparkMax armPivot;

  private ArmSubsystem() {
    armPivot = new CANSparkMax(RobotMap.ARM_MOTOR_ID, MotorType.kBrushless);
  }

  public static ArmSubsystem getInstance() {
    if (instance == null){
      instance = new ArmSubsystem();
    }
    return instance;
  }
  public void setSpeed(double speed) {
  armPivot.set(speed);
  }
  
  @Override
  public void periodic() {} 
}