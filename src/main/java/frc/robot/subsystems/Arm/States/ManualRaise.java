// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Arm.States;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm.ArmSubsystem;
import frc.robot.Constants;


public class ManualRaise extends CommandBase {
    
    private ArmSubsystem armPivot = ArmSubsystem.getInstance();

    public ManualRaise() {
        addRequirements(armPivot);
    }

    @Override
    public void initialize() {
        armPivot.setPower(Constants.ArmConstants.RaisePower);
    }

    public void end() {
        armPivot.setPower(0);
        System.out.print("manual control should end");
    }
}