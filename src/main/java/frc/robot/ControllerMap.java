package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class ControllerMap {

    private static Joystick driverController;
    private static Joystick operatorController;

    public static Joystick getDriveStick(){
        if (driverController == null){
            driverController = new Joystick(RobotMap.DRIVE_STICK_ID);
        }
        return driverController;
    }
    
    public static Joystick getButtonPad(){
        if (operatorController == null){
            operatorController = new Joystick(RobotMap.BUTTON_PAD_ID);
        }
        return operatorController;
    }

    public static class PS4_Controller{
        public static class Axis{
            public static final int LEFT_STICK_X = 0;
            public static final int LEFT_STICK_Y = 1;
            public static final int RIGHT_STICK_X = 2;
            public static final int LEFT_TRIGGER = 3;
            public static final int RIGHT_TRIGGER = 4;
            public static final int RIGHT_STICK_Y = 5;
        }

        public static class Button{
            public static final int SQUARE = 1;
            public static final int X = 2;
            public static final int CIRCLE = 3;
            public static final int TRIANGLE = 4;
            public static final int L1 = 5;
            public static final int R1 = 6;
            public static final int L2 = 7;
            public static final int R2 = 8;
            public static final int SHARE = 9;
            public static final int OPTIONS = 10;
            public static final int L3 = 11;
            public static final int R3 = 12;
            public static final int PS = 13;
        }
    }
    
    public static class XBox_Controller{
        public static class Axis{
            public static final int LEFT_STICK_X = 0;
	        public static final int LEFT_STICK_Y = 1;
	        public static final int LEFT_TRIGGER = 2;
	        public static final int RIGHT_TRIGGER = 3;
	        public static final int RIGHT_STICK_X = 4;
	        public static final int RIGHT_STICK_Y = 5;
        }

        public static class Button{
            public static final int A = 1;
	        public static final int B = 2;
	        public static final int X = 3;
	        public static final int Y = 4;
	        public static final int LB = 5;
	        public static final int RB = 6;
	        public static final int LOGO_LEFT = 7;
	        public static final int LOGO_RIGHT = 8;
	        public static final int LEFT_STICK_BUTTON = 9;
	        public static final int RIGHT_STICK_BUTTON = 10;
        }
    }
}