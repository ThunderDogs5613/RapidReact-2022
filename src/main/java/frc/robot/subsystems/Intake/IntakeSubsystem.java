// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Intake;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.Encoder;

public class IntakeSubsystem extends SubsystemBase {
  
  private CANSparkMax intakeRoller;
  private TalonSRX intakeArm;
  private Encoder intakeArmEncoder;
  
  private intakeStates currentState;


  // list of potential states
  public enum intakeStates {
    HighIdle,
    HighOut,
    LowIdle,
    LowIn,
    LowOut,
  }

  public static IntakeSubsystem instance;

  // Define the creation of a new IntakeSubsystem
  public IntakeSubsystem() {
    intakeRoller = new CANSparkMax(RobotMap.INTAKE_ROLLER, MotorType.kBrushless);
    intakeArm = new TalonSRX(RobotMap.INTAKE_ARM);
    intakeArmEncoder = new Encoder(RobotMap.INTAKE_ENCODER_1, RobotMap.INTAKE_ENCODER_2);
  }

  // Create a new IntakeSubsystem instance if there is not one already
  public static synchronized IntakeSubsystem getInstance() {
    if(instance == null){
      instance = new IntakeSubsystem();
    }
    return instance;
  }

  // Set the intake power to a value between -1 and 1.
  public void setIntakePower(double power){
    intakeRoller.set(power);
  }

  // Set the intake arm power to a value between -1 and 1.
  public void setIntakeArmPower(double power){
    intakeArm.set(ControlMode.PercentOutput, power);
  }

  // Raises the arm until it reaches the up position.
  public void raiseArm() {
    while (intakeArmEncoder.get() < 0) {
      setIntakeArmPower(.50);
    }
    setIntakeArmPower(0);
  }

  // Lowers the arm until it reaches the down position.
  public void lowerArm() {
    while (intakeArmEncoder.get() >= 3045) {
      setIntakeArmPower(-.50);
    }
    setIntakeArmPower(0);
  }

  // Handles state changing.
  public void setState(intakeStates newState) {
    currentState = newState;
    
    switch (currentState) {
      
      // If state is low idle, set intake to 0 and lower arm if not already lowered.
      case LowIdle:
      setIntakePower(0);
      if (intakeArmEncoder.get() >= 3045) {
        lowerArm();
      }
      break;

      // If state is low out, set intake to .5 and lower arm if not already lowered.
      case LowOut:
      setIntakePower(0);
      if (intakeArmEncoder.get() >= 3045) {
        lowerArm();
      }
      setIntakePower(0.5);
      break;
      
      // If state is low in, set intake to -0.5 and lower arm if not already lowered.
      case LowIn:
      setIntakePower(0);
      if (intakeArmEncoder.get() >= 3045) {
        lowerArm();
      }
      setIntakePower(-0.5);
      break;

      // If state is high idle, set intake to 0 and raise arm if not already raised.
      case HighIdle:
      setIntakePower(0);
      if (intakeArmEncoder.get() <= 0) {
        raiseArm();
      }
      break;
      
      // If state is high out, set intake to 0.5 and raise arm if not already raised.
      case HighOut:
      setIntakePower(0);
      if (intakeArmEncoder.get() <= 0) {
        raiseArm();
      }
      setIntakePower(0.5);
      }
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  } 
}
