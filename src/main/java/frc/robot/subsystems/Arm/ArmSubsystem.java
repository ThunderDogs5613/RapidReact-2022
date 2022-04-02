// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Arm;

import frc.robot.Constants.Constants;
import frc.robot.Constants.RobotMap;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;

public class ArmSubsystem extends PIDSubsystem {
  
  private static ArmSubsystem instance;

  private CANSparkMax armPivot;
  //private DutyCycleEncoder armEncoder;
  private RelativeEncoder NeoEncoder;
  private double feedForward;
  private double adjustedOutput;
  private double limitedOutput;
  private SlewRateLimiter armLimiter;

  private ArmSubsystem() {



    super(new PIDController(Constants.ArmConstants.kP, Constants.ArmConstants.kI, Constants.ArmConstants.kD));

    armPivot = new CANSparkMax(RobotMap.ARM_MOTOR_ID, MotorType.kBrushless);
    //armEncoder = new DutyCycleEncoder(RobotMap.ARM_ENCODER_ID);
    NeoEncoder = armPivot.getEncoder();


    feedForward = Constants.ArmConstants.DefaultFeedForward;

    armLimiter = new SlewRateLimiter(1.8);
  }

  public static ArmSubsystem getInstance() {
    if (instance == null){
      instance = new ArmSubsystem();
    }
    return instance;
  }

  public void setPower(double power) {
  armPivot.set(power);
  }

  public void setFeedForward(double newFeedForward) {
    feedForward = newFeedForward;
  }

  @Override
  protected void useOutput(double output, double setpoint) {
    adjustedOutput = output + feedForward;
    //limitedOutput = armLimiter.calculate(adjustedOutput);
    setPower(output);
  }

  @Override
  protected double getMeasurement() {
    return getArmPosition();
  } 
  
  public double getArmPosition() {
    //return armEncoder.get();
    return NeoEncoder.getPosition();
  }
}