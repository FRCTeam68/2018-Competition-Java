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
    
    public static final int XBOX_DRIVE = 0;
    
    public static final int XBOX_DRIVE_A = 1;
    public static final int XBOX_DRIVE_B = 2;
    public static final int XBOX_DRIVE_Y = 4;
    public static final int XBOX_DRIVE_X = 3;
    public static final int XBOX_DRIVE_LY = 1;			// left joystick
    public static final int XBOX_DRIVE_LT = 2;
    public static final int XBOX_DRIVE_RT = 3;
    public static final int XBOX_DRIVE_RY = 5;			// right joystick
    public static final int XBOX_DRIVE_BS = 8;
    public static final int XBOX_DRIVE_BB = 7;  
    public static final int XBOX_DRIVE_RB = 6;
    public static final int XBOX_DRIVE_LB = 5;
    
	public static final int XBOX_MANIPULATE = 1;
	public static final int XBOX_MANIPULATE_A = 1;
	public static final int XBOX_MANIPULATE_B = 2;
	public static final int XBOX_MANIPULATE_X = 3;
	public static final int XBOX_MANIPULATE_Y = 4;
	public static final int XBOX_MANIPULATE_LB = 5;
	public static final int XBOX_MANIPULATE_RB = 6;
	public static final int XBOX_MANIPULATE_SHARE = 7;
	public static final int XBOX_MANIPULATE_OPTIONS = 8;
	public static final int XBOX_MANIPULATE_SL = 9;
	public static final int XBOX_MANIPULATE_SR = 10;
	public static final int XBOX_MANIPULATE_LY = 1;
	public static final int XBOX_MANIPULATE_LT = 2;
	public static final int XBOX_MANIPULATE_RT = 3;

    // DRIVETRAIN
    public static final int DRIVETRAIN_LEFT_FRONT = 1;
    public static final int DRIVETRAIN_RIGHT_FRONT = 3;
    public static final int DRIVETRAIN_LEFT_REAR = 2;
    public static final int DRIVETRAIN_RIGHT_REAR = 4;

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
    
    // ENDGAME
    public static final int HOOK_MOTOR_1 = 2;
    public static final int HOOK_MOTOR_2 = 3;
	public static final int WINCH_MOTOR_1 = 6;
	public static final int WINCH_MOTOR_2 = 7;
	
	public static final double HOOK_MOTOR_1_FORWARDS = -1.0;
	public static final double HOOK_MOTOR_1_BACKWARDS = 1.0;
	public static final double HOOK_MOTOR_2_FORWARDS = -1.0;
	public static final double HOOK_MOTOR_2_BACKWARDS = 1.0;
	public static final double HOOK_MOTOR_1_STOP = 0.0;
	public static final double HOOK_MOTOR_1_PITSPEED_FORWARDS = -0.1;
	public static final double HOOK_MOTOR_1_PITSPEED_BACKWARDS = 0.1;
	
	public static final double WINCH_MOTOR_1_FORWARDS = -1.0;
	public static final double WINCH_MOTOR_1_BACKWARDS = 1.0;
	public static final double WINCH_MOTOR_2_FORWARDS = -1.0;
	public static final double WINCH_MOTOR_2_BACKWARDS = 1.0;
	
	public static final double WINCH_MOTOR_STOP = 0.0;
	
	public static final int HOOK_LIMIT_SWITCH_A = 1;
	public static final int HOOK_LIMIT_SWITCH_B = 2;


    
    // LIFT
	public static final int LIFT_MOTORS = 5;
	public static final double LIFT_SPEED_UP = 0.75;
	public static final double  LIFT_SPEED_STOP = 0;
	public static final double LIFT_SPEED_DOWN = -0.75;
	public static final double LIFT_NORMAL_SCALE = -72500.0;
	public static final double LIFT_HIGH_SCALE = -93000.0;
	public static final double LIFT_NORMAL_SWITCH = -29000.0;
	public static final double LIFT_GROUND = -1750.0;
	
	//public static final int LIFT_LIMIT_SWITCH_UP = 2;
	public static final int LIFT_LIMIT_SWITCH_DOWN = 3;
    public static final int LIFT_PID_SLOT = 0;
    
    public static final double LIFT_PID_F = 0.03; //0.025
    public static final double LIFT_PID_P = .4;
    public static final double LIFT_PID_I = 0.0;
    public static final double LIFT_PID_D = 0.0;

	// INTAKE
    public static final int INTAKE_CLAMP = 3;
    public static final int INTAKE_NORMAL = 2;
	public static final int INTAKE_UP = 4; 
	public static final int INTAKE_DOWN = 5;
	
    public static final int INTAKE_MOTOR_A = 0;
    public static final int INTAKE_MOTOR_B = 1;
    public static final double INTAKE_A_SPEED_FORWARD = 1;
    public static final double INTAKE_A_SPEED_REVERSE = -.45;
    public static final double INTAKE_B_SPEED_FORWARD = -.9;
    public static final double INTAKE_B_SPEED_REVERSE = .45;
    public static final double INTAKE_SPEED_STOP = 0;
    public static final int INTAKE_LIMIT_SWITCH = 0;
    
	// Pneumatic Control Module CAN Bus ID
    public static final int PCM_MAIN = 9;
}