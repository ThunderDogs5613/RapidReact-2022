// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeSubsystem extends CommandBase {
  
  private SparkMax IntakeRoller;
  private TalonSRX IntakeArm;
  
  private intakeStates currentState;

  public enum intakeStates() {
    High-Idle,
    High-Out,
    Low-Idle,
    Low-In,
    Low-Out;
  }

  public static IntakeSubsystem instance;

  public static synchronized IntakeSubsystem getInstance() {
    if(instance == null){
      instance = new IntakeSubsystem();
    }
    return instance;
  }

  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  public void setIntakePower(double power){
    intakeRoller.set(power, MotorType.kBrushless);
  }

  public void setIntakeArmPower(double power){
    intakeArm.set(ControlMode.PercentOutput, power);
  }

  public void checkHeight() {

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
