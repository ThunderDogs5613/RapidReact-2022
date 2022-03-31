package frc.robot.Constants;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;


public class FieldPositions {
    public static Pose2d ORIGIN = new Pose2d(0, 0, new Rotation2d(0));     //for us, Origin is the center of the field or hub
    public static Pose2d START_1 = new Pose2d(4.12, -1.58, new Rotation2d(-69));

    public static Pose2d TARMAC_ALLIANCE_CARGO_1 = new Pose2d(12.57, -2.16, new Rotation2d());
    public static Pose2d TARMAC_ALLIANCE_CARGO_2 = new Pose2d(7.36, -10.41, new Rotation2d());
    public static Pose2d TARMAC_ALLIANCE_CARGO_3 = new Pose2d(-6.8, -10.78, new Rotation2d());

    public static Pose2d TARMAC_OPPONENT_CARGO_1 = new Pose2d(12.44, 2.81, new Rotation2d());
    public static Pose2d TARMAC_OPPONENT_CARGO_2 = new Pose2d(2.81, -12.44, new Rotation2d());
    public static Pose2d TARMAC_OPPONENT_CARGO_3 = new Pose2d(-10.41, -7.36, new Rotation2d());

    public static Pose2d TERMINAL_CARGO = new Pose2d(9.82, -23.51, new Rotation2d());


    public static Pose2d POINT_10_FEET_AWAY = new Pose2d(.2, 0, new Rotation2d(0));

    public static double INTAKE_OFFSET = 2.34;

    public static Pose2d addRotation (Pose2d pos, Rotation2d rotation) {
        return new Pose2d(pos.getTranslation(), rotation);
    }

    public static Pose2d pointAtIntake(Pose2d pos){
        double x = pos.getTranslation().getX();
        double y = pos.getTranslation().getY();
        double heading = pos.getRotation().getRadians();
        return new Pose2d(x - INTAKE_OFFSET*Math.cos(heading), y - INTAKE_OFFSET*Math.sin(heading), pos.getRotation());
    }
    
}