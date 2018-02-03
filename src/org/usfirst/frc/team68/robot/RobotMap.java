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


    public static final int GEAR_IN = 5;
    public static final int GEAR_OUT = 4;
    public static final int GEAR_INTAKE_MOTOR = 4;
    public static final double GEAR_INTAKE_DEPLOY_SPEED = -.2;
    public static final double GEAR_INTAKE_STOP = 0;
    
    public static final int INTAKE_UP = 7;
    public static final int INTAKE_DOWN = 6;
    public static final double INTAKE_SPEED_FORWARD = 1.0;
    public static final double INTAKE_SPEED_STOP = 0;
    public static final double INTAKE_SPEED_REVERSE = -1.0;
    public static final int INTAKE_MOTORS = 1;  						// Two motors PWM channel 1 with Y cable
    
    public static final int CLIMBER_LOCK = 3;
    public static final int CLIMBER_UNLOCK = 2;
    
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
 
    
    public static final int XBOX_MANIPULATE = 1;
    public static final int XBOX_MANIPULATE_A = 1;
    public static final int XBOX_MANIPULATE_B = 2;
    public static final int XBOX_MANIPULATE_X = 3;
    public static final int XBOX_MANIPULATE_Y = 4;
    public static final int XBOX_MANIPULATE_RB = 6;
    public static final int XBOX_MANIPULATE_LB = 5;
    public static final int XBOX_MANIPULATE_LT = 2;
    public static final int XBOX_MANIPULATE_RT = 3;
    public static final int XBOX_MANIPULATE_BB = 7;    
    public static final int XBOX_MANIPULATE_BS = 8;
    // Public static final int XBOX_MANIPULATE_RY = 5;

    // Shooter Basic Config
    public static final int SHOOTER_PRIMARY_MOTOR = 5;  	
    public static final int SHOOTER_FOLLOWER_MOTOR = 6; 	
    public static final int SHOOTER_FEEDER_MOTOR = 2;
    public static final double SHOOTER_SPEED_STOP = 0;
    public static final int SHOOTER_HOOD_SERVO = 3;
    public static final double SHOOTER_FEEDER_SPEED_STOP = 0;
    public static final double SHOOTER_FEEDER_SPEED_REVERSE = -0.3;
    
    // Shooter PID Config
    public static final int SHOOTER_PID_SLOT = 0;
    public static final double SHOOTER_PID_F = 0.0206;
    public static final double SHOOTER_PID_P = 0.2;
    public static final double SHOOTER_PID_I = 0.0;
    public static final double SHOOTER_PID_D = 4.0;
    // Shooter Short Shot 
    public static final double SHOOTER_FEEDER_SPEED_SHORT = 1.0;
    public static final double SHOOTER_SPEED_SHORT = 7600;
    public static final double SHOOTER_HOOD_SHORT = .5;
    // Shooter Medium Shot
    public static final double SHOOTER_FEEDER_SPEED_MEDIUM = 1.0;
    public static final double SHOOTER_SPEED_MEDIUM = 14000;
    public static final double SHOOTER_HOOD_MEDIUM = .65;
    // Shooter Long Shot
    public static final double SHOOTER_FEEDER_SPEED_LONG = 1.0;
    public static final double SHOOTER_SPEED_LONG = 22870;
    public static final double SHOOTER_HOOD_LONG = .475;
     
	public static final double MATCH_TIME = 150;  
	
	// Pneumatic Control Module CAN Bus ID
    public static final int PCM_MAIN = 9;
    
    
}


