// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.Encoder;

public class IntakeSubsystem extends CommandBase {
  
  private CANSparkMax intakeRoller;
  private TalonSRX intakeArm;
  private Encoder intakeArmEncoder;
  
  private intakeStates currentState;

  public enum intakeStates {
    HighIdle,
    HighOut,
    LowIdle,
    LowIn,
    LowOut,
  }

  public static IntakeSubsystem instance;

  public IntakeSubsystem() {
    intakeRoller = new CANSparkMax(RobotMap.INTAKE_ROLLER, MotorType.kBrushless);
    intakeArm = new TalonSRX(RobotMap.INTAKE_ARM);
    intakeArmEncoder = new Encoder(RobotMap.INTAKE_ENCODER_1, RobotMap.INTAKE_ENCODER_2);
  }

  public static IntakeSubsystem getInstance() {
    if(instance == null){
      instance = new IntakeSubsystem();
    }
    return instance;
  }

  public void setIntakePower(double power){
    intakeRoller.set(power);
  }

  public void setIntakeArmPower(double power){
    intakeArm.set(ControlMode.PercentOutput, power);
  }

  public void checkHeight() {
    intakeArmEncoder.get();
  }

  public void raiseArm() {
    while (intakeArmEncoder.get() < 0) {
      setIntakeArmPower(.50);
    }
    setIntakeArmPower(0);
  }

  public void lowerArm() {
    while (intakeArmEncoder.get() >= 5) {
      setIntakeArmPower(-.25);
    }
    setIntakeArmPower(0);
  }

  public void setState(intakeStates newState) {
    currentState = newState;
    
    switch (currentState) {
      
      case LowIdle:
      setIntakePower(0);
      if (intakeArmEncoder.get() > 0) {
        lowerArm();
      }
      break;

      case LowOut:
      setIntakePower(0);
      if (intakeArmEncoder.get() > 0) {
        lowerArm();
      }
      setIntakePower(0.5);
      break;

      case LowIn:
      setIntakePower(0);
      if (intakeArmEncoder.get() > 0) {
        lowerArm();
      }
      setIntakePower(-0.5);
      break;

      case HighIdle:
      setIntakePower(0);
      if (intakeArmEncoder.get() < 0) {
        raiseArm();
      }
      break;

      case HighOut:
      setIntakePower(0);
      if (intakeArmEncoder.get() < 5) {
        raiseArm();
      }
      setIntakePower(0.5);
      }
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
