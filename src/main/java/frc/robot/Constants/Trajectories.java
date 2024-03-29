package frc.robot.Constants;

import java.util.ArrayList;
import java.util.List;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.trajectory.TrajectoryConfig;

public class Trajectories {
    private static final List<Pose2d> TwoCargoPointList = List.of(FieldPositions.ORIGIN, 
                                                                    FieldPositions.addRotation(FieldPositions.pointAtIntake(FieldPositions.TARMAC_ALLIANCE_CARGO_1), new Rotation2d(0)));

    private static final List<Pose2d> BasicTestPointList = List.of(FieldPositions.ORIGIN,
                                                                   FieldPositions.POINT_10_FEET_AWAY);

    public static final Trajectory testTraj0 = TrajectoryGenerator.generateTrajectory(TwoCargoPointList, new TrajectoryConfig(10, 23).setReversed(true));

    public static final Trajectory basicTestTraj = TrajectoryGenerator.generateTrajectory(BasicTestPointList, new TrajectoryConfig(2, 1).setReversed(false));

}