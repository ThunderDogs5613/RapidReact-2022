// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class DriveTrain extends SubsystemBase {

  private TalonSRX motorRF, motorRR, motorLF, motorLR;

  /** Creates a new DriveTrain. */
  public DriveTrain() {
    motorRF = new TalonSRX(0);
    motorRR = new TalonSRX(1);
    motorLF = new TalonSRX(2);
    motorLR = new TalonSRX(3);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
