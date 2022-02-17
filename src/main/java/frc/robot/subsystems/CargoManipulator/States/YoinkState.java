package frc.robot.subsystems.CargoManipulator.States;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CargoManipulator.CargoManipulatorSubsystem;



public class YoinkState extends CommandBase {
    
    private CargoManipulatorSubsystem intake = CargoManipulatorSubsystem.getInstance();

  
    public YoinkState() {
        addRequirements(intake);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        intake.setSpeed(1);
    }

    @Override
    public void end(boolean interrupted) {
        intake.setSpeed(0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}