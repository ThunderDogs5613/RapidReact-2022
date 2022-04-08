package frc.robot.commands.Autos;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.Autos.TwoBallAuto;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.util.ArrayList;
import java.util.Arrays;




public class AutoChooser {

    public static final Command TwoBallAuto = new TwoBallAuto();
    public static final Command PlainOLTaxi = new PlainOLTaxi();
    public static final Command ScoreAndTaxi = new ScoreAndTaxi();

    
    public static SendableChooser<Command> auto_chooser = new SendableChooser<>();

    public static void configureAutoChooser() {
        String[] autoList = {"Score and Taxi", "Plain ol' taxi", "Two Ball Auto"};
        SmartDashboard.putStringArray("Auto List", autoList);
        
        //auto_chooser.setDefaultOption("Score and Taxi", ScoreAndTaxi);
        //auto_chooser.addOption("Plain ol' taxi", PlainOLTaxi);
        //auto_chooser.addOption("Two Ball Auto", TwoBallAuto);

        //SmartDashboard.putData(auto_chooser);
    }

}
