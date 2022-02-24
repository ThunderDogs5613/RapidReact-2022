// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Constants;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public final class CargoManipulatorConstants{
        public static final double YoinkPower = -1;
        public static final double YeetPower = 1;
        public static final double IdlePower = 0;
    }

    public static final class ArmConstants{
        public static final double RaisePower = .2;
        public static final double LowerPower = -.15;
        public static final double kP = 1.0;
        public static final double kI = 0.2;
        public static final double kD = 0.05;
        public static final double HighPosition = 0.22;
        public static final double LowPosition = 0.48;
        public enum ArmPosition{
            LOW, HIGH
        }
    }
}