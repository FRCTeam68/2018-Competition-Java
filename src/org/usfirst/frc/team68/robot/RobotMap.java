package org.usfirst.frc.team68.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
    private static RobotMap robotMap;
        
    public static RobotMap getRobotMap() {
    	if( robotMap == null) {
    		robotMap = new RobotMap();
    	}
    	return robotMap;
    }
    //comment
    public static final int DRIVETRAIN_LEFT_FRONT = 3;
    public static final int DRIVETRAIN_RIGHT_FRONT = 1;
    public static final int DRIVETRAIN_LEFT_REAR = 4;
    public static final int DRIVETRAIN_RIGHT_REAR = 2;
    public static final int DRIVETRAIN_SHIFT_LOW = 1;
    public static final int DRIVETRAIN_SHIFT_HIGH = 0;
    public static final double DRIVETRAIN_AUTON_SPEED = .9;
//    public static final int DRIVETRAIN_GYRO_ID = 3;
    // Drivetrain Left PID Config
    public static final int DRIVETRAIN_LEFT_PID_SLOT = 0;
    public static final double DRIVETRAIN_LEFT_PID_F = 0.498;
    public static final double DRIVETRAIN_LEFT_PID_P = 1;
    public static final double DRIVETRAIN_LEFT_PID_I = 0.0;
    public static final double DRIVETRAIN_LEFT_PID_D = 10.0;
    // Drivetrain Right PID Config
    public static final int DRIVETRAIN_RIGHT_PID_SLOT = 0;
    public static final double DRIVETRAIN_RIGHT_PID_F = 0.507;
    public static final double DRIVETRAIN_RIGHT_PID_P = 1.0;
    public static final double DRIVETRAIN_RIGHT_PID_I = 0.0;
    public static final double DRIVETRAIN_RIGHT_PID_D = 10.0;

    
    public static final int XBOX_DRIVE = 0;
    
    public static final int XBOX_DRIVE_A = 1;
    public static final int XBOX_DRIVE_B = 2;
    public static final int XBOX_DRIVE_X = 3;
    public static final int XBOX_DRIVE_Y = 4;
    public static final int XBOX_DRIVE_LY = 1;			// left joystick
    public static final int XBOX_DRIVE_LT = 2;
    public static final int XBOX_DRIVE_RT = 3;
    public static final int XBOX_DRIVE_RY = 5;			// right joystick
    public static final int XBOX_DRIVE_BS = 8;
    public static final int XBOX_DRIVE_BB = 7;  
    public static final int XBOX_DRIVE_RB = 6;
    public static final int XBOX_DRIVE_LB = 5;
    
	// Pneumatic Control Module CAN Bus ID
    public static final int PCM_MAIN = 9;
    
	public static final int INTAKE_CLAMP = 3; 
	public static final int INTAKE_UNCLAMP = 4;
	
    public static final double INTAKE_SPEED_FORWARD = 1;
    public static final double INTAKE_SPEED_STOP = 0;
    public static final double INTAKE_SPEED_REVERSE = -1;
    public static final int INTAKE_MOTORS = 0;
        //need a commment for something I dont now what it is but its a comment
    public static final int INTAKE_LIMIT_SWITCH = 1;
    //Xbox manipulator buttons
    public static final int XBOX_MANIPULATE = 1;
    
    public static final int XBOX_MANIPULATE_PURPLE = 1;
    public static final int XBOX_MANIPULATE_RED = 2;
    public static final int XBOX_MANIPULATE_LT = 2; // THE BOTTOM LEFT GRAY BUTTON
}