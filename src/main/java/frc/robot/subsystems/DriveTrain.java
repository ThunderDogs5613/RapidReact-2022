// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.RobotMap;

public class DriveTrain extends SubsystemBase {

  private TalonSRX motorRF, motorRR, motorLF, motorLR;

  private static DriveTrain instance;

  private DriveTrain() {
    motorRF = new TalonSRX(RobotMap.RIGHT_FRONT_MOTOR);
    motorRR = new TalonSRX(RobotMap.RIGHT_REAR_MOTOR);
    motorLF = new TalonSRX(RobotMap.LEFT_FRONT_MOTOR);
    motorLR = new TalonSRX(RobotMap.LEFT_REAR_MOTOR);
  }

  public static synchronized DriveTrain getInstance() {
    if(instance == null){
      instance = new DriveTrain();
    }
    return instance;
  }

  public void setPower(double leftPower, double rightPower) {
    motorRF.set(ControlMode.PercentOutput, rightPower);
    motorRR.set(ControlMode.PercentOutput, rightPower);
    motorLF.set(ControlMode.PercentOutput, leftPower);
    motorLR.set(ControlMode.PercentOutput, leftPower);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
