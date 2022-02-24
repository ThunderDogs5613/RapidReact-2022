// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Drivetrain.States;

import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain.DrivetrainSubsystem;

public class PathFollowing extends CommandBase {    
  
  private Trajectory pathToFollow;
  private Timer trajectoryTimer;

  public PathFollowing(Trajectory pathToFollow) {
    addRequirements(DrivetrainSubsystem.getInstance());
    pathToFollow = this.pathToFollow;
    }

  @Override
  public void initialize() {
      trajectoryTimer.start();
  }

  @Override
  public void execute() {
    double currentTime = trajectoryTimer.get();
    Trajectory.State currentState = pathToFollow.sample(currentTime);

    double velocity = currentState.velocityMetersPerSecond;
    double angularVelocity = velocity * currentState.curvatureRadPerMeter;
    double acceleration = currentState.accelerationMetersPerSecondSq;
    double angularAcceleration = acceleration * currentState.curvatureRadPerMeter;

    double leftVelocity = velocity - angularVelocity;
    double rightVelocity = velocity + angularVelocity;

    //use until setSpeed method is added to DrivetrainSubsystem
    DrivetrainSubsystem.getInstance().setPower(leftVelocity, rightVelocity); 
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
