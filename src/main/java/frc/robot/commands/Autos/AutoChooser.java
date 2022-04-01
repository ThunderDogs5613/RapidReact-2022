package frc.robot.commands.Autos;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.Autos.TwoBallAuto;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class AutoChooser {

    private static final Command TwoBallAuto = new TwoBallAuto();
    private static final Command PlainOLTaxi = new PlainOLTaxi();
    private static final Command ScoreAndTaxi = new ScoreAndTaxi();

    public static SendableChooser<Command> auto_chooser = new SendableChooser<>();
    
    public static void configureAutoChooser() {
        auto_chooser.setDefaultOption("Score and Taxi", ScoreAndTaxi);
        auto_chooser.addOption("Plain ol' taxi", PlainOLTaxi);
        auto_chooser.addOption("Two Ball Auto", TwoBallAuto);

        SmartDashboard.putData(auto_chooser);
    }

}
