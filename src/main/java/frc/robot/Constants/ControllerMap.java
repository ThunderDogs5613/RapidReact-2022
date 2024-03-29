package frc.robot.Constants;

import edu.wpi.first.wpilibj.Joystick;

public class ControllerMap {

    private static Joystick driveStick;
    private static Joystick buttonPad;

    public static Joystick getDriveStick(){
        if (driveStick == null){
            driveStick = new Joystick(RobotMap.DRIVE_STICK_ID);
        }
        return driveStick;
    }
    
    public static Joystick getButtonPad(){
        if (buttonPad == null){
            buttonPad = new Joystick(RobotMap.BUTTON_PAD_ID);
        }
        return buttonPad;
    }

    public static class Logitech_Controller{
        public static class Axis{
            public static final int STICK_X = 0;
            public static final int STICK_Y = 1;
            public static final int STICK_Z = 2;
            public static final int SLIDER = 3;
        }

        public static class Button{
            public static final int TRIGGER = 1;
            public static final int THUMB = 2;
            public static final int B3 = 3;
            public static final int B4 = 4;
            public static final int B5 = 5;
            public static final int B6 = 6;
        }
    }
    
    public static class Generic_Button_Pad{
        public static class Button{
            public static final int B1 = 1;
	        public static final int B2 = 2;
	        public static final int B3 = 3;
	        public static final int B4 = 4;
	        public static final int B5 = 5;
	        public static final int B6 = 6;
	        public static final int B7 = 7;
	        public static final int B8 = 8;
	        public static final int B9 = 9;
	        public static final int B10 = 10;
            public static final int B11 = 11;
            public static final int B12 = 12;
        }
    }
}