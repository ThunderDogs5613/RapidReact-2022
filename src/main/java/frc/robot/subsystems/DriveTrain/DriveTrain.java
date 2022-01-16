// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.DifferentialDrive.WheelSpeeds;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.RobotMap;



public class DriveTrain extends SubsystemBase {

  private CANSparkMax motorRF, motorRR, motorLF, motorLR;

  private static DriveTrain instance;

  private DriveTrain() {
    motorRF = new CANSparkMax(RobotMap.RIGHT_FRONT_MOTOR, MotorType.kBrushless);
    motorRR = new CANSparkMax(RobotMap.RIGHT_REAR_MOTOR, MotorType.kBrushless);
    motorLF = new CANSparkMax(RobotMap.LEFT_FRONT_MOTOR, MotorType.kBrushless);
    motorLR = new CANSparkMax(RobotMap.LEFT_REAR_MOTOR, MotorType.kBrushless);
    motorLF.setInverted(true);
    motorLR.setInverted(true);
  }

  public static synchronized DriveTrain getInstance() {
    if(instance == null){
      instance = new DriveTrain();
    }
    return instance;
  }

  public void setArcade(double throttle, double rotation) {
    double leftPower = throttle + rotation;
    double rightPower = throttle - rotation;
    setPower(leftPower, rightPower);
  }
  
  public void setCurvature(double throttle, double rotation, boolean turnInPlace) {
    WheelSpeeds Speeds = DifferentialDrive.curvatureDriveIK(throttle, rotation, turnInPlace);
    double leftPower = Speeds.left;
    double rightPower = Speeds.right;
    setPower(leftPower, rightPower);
  }

  public void setPower(double leftPower, double rightPower) {
    motorRF.set(rightPower);
    motorRR.set(rightPower);
    motorLF.set(leftPower);
    motorLR.set(leftPower);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
