package frc.robot.subsystems.CargoManipulator.States;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.Constants;
import frc.robot.subsystems.CargoManipulator.CargoManipulatorSubsystem;


public class IdleState extends CommandBase {
    
    private CargoManipulatorSubsystem intake = CargoManipulatorSubsystem.getInstance();

    public IdleState() {
        addRequirements(intake);
    }

    @Override
    public void initialize() {
        intake.setSpeed(Constants.CargoManipulatorConstants.IdlePower);
    }

}