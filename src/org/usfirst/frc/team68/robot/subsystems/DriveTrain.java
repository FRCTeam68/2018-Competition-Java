package org.usfirst.frc.team68.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team68.robot.Robot;
import org.usfirst.frc.team68.robot.RobotMap;
import org.usfirst.frc.team68.robot.commands.DriveWithXboxJoysticks;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.sensors.PigeonIMU; 


public class DriveTrain extends Subsystem {
	
	private WPI_TalonSRX leftFront;
	private WPI_TalonSRX rightFront;
	private WPI_TalonSRX leftRear;
	private WPI_TalonSRX rightRear;
	private DifferentialDrive drive;
	//private DoubleSolenoid driveShifter;
	private boolean reverseDrive;
	private double leftRearCruiseVelocity; 
	private double leftRearAcceleration; 
	private double rightRearCruiseVelocity; 
	private double rightRearAcceleration; 
	private double leftRearSetPoint; 
	private double rightRearSetPoint; 	
	private double targetSpeedLeft;
	private double targetSpeedRight;
	StringBuilder reportPIDLeft = new StringBuilder();
	StringBuilder reportPIDRight = new StringBuilder();
	
	public static DriveTrain driveTrain;

	public static DriveTrain getDriveTrain() {
		if (driveTrain == null) {
			driveTrain = new DriveTrain();
		}
		return driveTrain;
	}

	private DriveTrain() {

		leftRear = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_REAR);
		rightRear = new WPI_TalonSRX(RobotMap.DRIVETRAIN_RIGHT_REAR);
		
		leftRear.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,0,0);
		
		leftRear.setSensorPhase(true); 
		leftRear.configNominalOutputForward(0, 0);
		leftRear.configNominalOutputReverse(0, 0);
		leftRear.configPeakOutputForward(1,0); 
		leftRear.configPeakOutputReverse(-1,0); 
		leftRear.selectProfileSlot(RobotMap.DRIVETRAIN_LEFT_PID_SLOT, 0);
		leftRear.config_kF(RobotMap.DRIVETRAIN_LEFT_PID_SLOT, RobotMap.DRIVETRAIN_LEFT_PID_F, 0);
		leftRear.config_kP(RobotMap.DRIVETRAIN_LEFT_PID_SLOT, RobotMap.DRIVETRAIN_LEFT_PID_P, 0);
		leftRear.config_kI(RobotMap.DRIVETRAIN_LEFT_PID_SLOT, RobotMap.DRIVETRAIN_LEFT_PID_I, 0);
		leftRear.config_kD(RobotMap.DRIVETRAIN_LEFT_PID_SLOT, RobotMap.DRIVETRAIN_LEFT_PID_D, 0);
		
		rightRear.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,0,0);
		
		rightRear.setSensorPhase(true); 
		rightRear.configNominalOutputForward(0, 0);
		rightRear.configNominalOutputReverse(0, 0);
		rightRear.configPeakOutputForward(1,0); 
		rightRear.configPeakOutputReverse(-1,0); 
		rightRear.selectProfileSlot(RobotMap.DRIVETRAIN_RIGHT_PID_SLOT, 0);
		rightRear.config_kF(RobotMap.DRIVETRAIN_RIGHT_PID_SLOT, RobotMap.DRIVETRAIN_RIGHT_PID_F, 0);
		rightRear.config_kP(RobotMap.DRIVETRAIN_RIGHT_PID_SLOT, RobotMap.DRIVETRAIN_RIGHT_PID_P, 0);
		rightRear.config_kI(RobotMap.DRIVETRAIN_RIGHT_PID_SLOT, RobotMap.DRIVETRAIN_RIGHT_PID_I, 0);
		rightRear.config_kD(RobotMap.DRIVETRAIN_RIGHT_PID_SLOT, RobotMap.DRIVETRAIN_RIGHT_PID_D, 0);
		
		leftFront = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_FRONT);
		leftFront.set(ControlMode.Follower, leftRear.getDeviceID());

		rightFront = new WPI_TalonSRX(RobotMap.DRIVETRAIN_RIGHT_FRONT);
		rightFront.set(ControlMode.Follower, rightRear.getDeviceID());

		drive = new DifferentialDrive(leftRear, rightRear);
		
		// setting the setSafetyEnabled out because there is a known issue
		// with the Motion Magic where the setpoint can get lost
		// as it gets starved for input
		drive.setSafetyEnabled(false);
		
		leftRear.setNeutralMode(NeutralMode.Coast);
		leftFront.setNeutralMode(NeutralMode.Coast);
		rightRear.setNeutralMode(NeutralMode.Coast);
		rightFront.setNeutralMode(NeutralMode.Coast);

		// Initialize the drive orientation.  We start with the orientation of
		// robot front = gear. 
		reverseDrive = false;  // note that pushing forward on the joystick returns negative values
	
		//driveShifter = new DoubleSolenoid(RobotMap.PCM_MAIN, RobotMap.DRIVETRAIN_SHIFT_HIGH, RobotMap.DRIVETRAIN_SHIFT_LOW);
		// Start in low gear
//		this.setShifterLow();
		
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new DriveWithXboxJoysticks());
	}
	
    public boolean getDriveOrientation() {
    	return reverseDrive;
    }
    
/*    public void setShifterHigh() {
    	driveShifter.set(Value.kForward);
    	//SmartDashboard.putBoolean("High Gear", true);
    }
    
    public void setShifterLow() {
    	driveShifter.set(Value.kReverse);
    	//SmartDashboard.putBoolean("High Gear", false);
    }
    */
    public void setDriveOrientation() {
    	// Reverse the current drive orientation
    	reverseDrive = !reverseDrive;
    	// update the dashboard to reflect the current drive orientation
    	//SmartDashboard.putBoolean("Drive Orientation: ", reverseDrive);
    }
    
    public void zeroEncoders(){
		Robot.navX.navX.zeroYaw();
    	leftRear.setSelectedSensorPosition(0,0,0);
    	rightRear.setSelectedSensorPosition(0,0,0);
    }

    /*public DoubleSolenoid.Value getShifter() {
    	return driveShifter.get();
    }
*/
    public void tankDrive(double leftSpeed, double rightSpeed) {
    	if(reverseDrive){
    		drive.tankDrive(-1*rightSpeed, -1*leftSpeed, true);
    	} else {
    		drive.tankDrive(leftSpeed, rightSpeed, true);
    	}
//    	SmartDashboard.putNumber("leftRear", leftSpeed);
//    	SmartDashboard.putNumber("rightRear", rightSpeed);
    }
        
    public void setModePercentVbus () {
    	leftRear.set(ControlMode.PercentOutput,0);
//    	leftRear.set(0);  Do we need this with the second parameter of the control mode setting?  Test it out?
       	rightRear.set(ControlMode.PercentOutput,0);
//    	rightRear.set(0);
    }
    
    public void setModeMotionMagic() {
    	leftRear.set(ControlMode.MotionMagic, 0);
//    	leftRear.set(0);
    	rightRear.set(ControlMode.MotionMagic, 0);
//    	rightRear.set(0);
    	this.zeroEncoders();
    }
    
    public void setMotionMagicProfile (int leftCruise, int leftAccel, int rightCruise, int rightAccel ) {
    	leftRear.configMotionCruiseVelocity(leftCruise, 0);
    	leftRear.configMotionAcceleration(leftAccel, 0);
    	rightRear.configMotionCruiseVelocity(rightCruise, 0);
    	rightRear.configMotionAcceleration(rightAccel, 0);
    }
    
    public void setMotionMagicPosition(double leftPos, double rightPos) {
//    	System.out.println("Setting Position to Left: " + leftPos +" Right: "+ rightPos);
    	leftRear.set(leftPos);
    	rightRear.set(rightPos);
    }
    
	public double getPositionLeft() {
		return leftRear.getSelectedSensorPosition(0);
	}
	
	public double getPositionRight() {
		return rightRear.getSelectedSensorPosition(0);
	}
	
	public double getClosedLoopErrorRight () {
		return rightRear.getClosedLoopError(0);
	}
	
	public double getClosedLoopErrorLeft () {
		return leftRear.getClosedLoopError(0);
	}
	  
    //**********************************************
    // For tuning drivetrain PID
    //**********************************************
    public void setDriveLeftSpeed(double speed) {
    	// set an instance variable to the incoming speed value.
    	// It is referenced by the getPIDReport() method in this class
    	//targetSpeed = speed;
    	
    	// Ensure that we are in speed mode.  We need to do this
    	// since we currently stop the shooter using percentVbus
       	leftRear.set(ControlMode.Velocity,0);

       	// Publish the target speed to the dashboard
       	targetSpeedLeft = speed;
    	//SmartDashboard.putNumber("Left Drive Target RPM Value: ", targetSpeedLeft);

    	leftRear.set(speed);
    }
    
    public void setDriveRightSpeed(double speed) {
    	// set an instance variable to the incoming speed value.
    	// It is referenced by the getPIDReport() method in this class
    	//targetSpeed = speed;
    	
    	// Ensure that we are in speed mode.  We need to do this
    	// since we currently stop the shooter using percentVbus
       	rightRear.set(ControlMode.Velocity,0);

       	// Publish the target speed to the dashboard
       	targetSpeedRight = speed;
    	//SmartDashboard.putNumber("Right Drive Target RPM Value: ", targetSpeedRight);

    	rightRear.set(speed);
    }
    
    public void setDriveLeftPID(double FL, double PL, double IL, double DL, double speed){
    	
		leftRear.config_kF(RobotMap.DRIVETRAIN_LEFT_PID_SLOT, FL, 0);
		leftRear.config_kP(RobotMap.DRIVETRAIN_LEFT_PID_SLOT, PL, 0);
		leftRear.config_kI(RobotMap.DRIVETRAIN_LEFT_PID_SLOT, IL, 0);
		leftRear.config_kD(RobotMap.DRIVETRAIN_LEFT_PID_SLOT, DL, 0);

    	targetSpeedLeft = speed;
//    	this.setDriveLeftSpeed(SmartDashboard.getNumber("Drive Left Target Speed: ", targetSpeedLeft));
    }

    public void setDriveRightPID(double FR, double PR, double IR, double DR, double speed){
		rightRear.config_kF(RobotMap.DRIVETRAIN_RIGHT_PID_SLOT, FR, 0);
		rightRear.config_kP(RobotMap.DRIVETRAIN_RIGHT_PID_SLOT, PR, 0);
		rightRear.config_kI(RobotMap.DRIVETRAIN_RIGHT_PID_SLOT, IR, 0);
		rightRear.config_kD(RobotMap.DRIVETRAIN_RIGHT_PID_SLOT, DR, 0);
    	targetSpeedRight = speed;
    	//this.setDriveRightSpeed(SmartDashboard.getNumber("Drive Right Target RPM Value: ", targetSpeedRight));
    }
    
    public double getDriveLeftSpeed() {
    	return leftRear.getActiveTrajectoryVelocity();
    }
    
    public int getDriveLeftSpeed2() {
    	return leftRear.getSelectedSensorVelocity(0);
    }
    
    public double getDriveRightSpeed() {
    	return rightRear.getActiveTrajectoryVelocity();
    }
    
    public double getDriveRightSpeed2() {
    	return rightRear.getSelectedSensorVelocity(0);
    }
 
    public String getPIDReportLeft() {
    	
    	double motorOutput = leftRear.getMotorOutputVoltage() / leftRear.getBusVoltage();
    	
    	reportPIDLeft.setLength(0);
    	
    	reportPIDLeft.append("\tout:");
    	reportPIDLeft.append(motorOutput);
    	reportPIDLeft.append("\tspd:");
    	reportPIDLeft.append(leftRear.get() );
    	reportPIDLeft.append("\terr:");
    	reportPIDLeft.append(leftRear.getClosedLoopError(0));
    	reportPIDLeft.append("\ttrg:");
/*    	reportPIDLeft.append(leftRear.getMotionMagicCruiseVelocity());
    	reportPIDLeft.append("\tactvel:");
    	reportPIDLeft.append(leftRear.getMotionMagicActTrajVelocity());
    	reportPIDLeft.append("\n");
*/
    	return reportPIDLeft.toString();
    }
    
    public String getPIDReportRight() {
    	
    	double motorOutput = rightRear.getMotorOutputVoltage() / rightRear.getBusVoltage();
    	
    	reportPIDRight.setLength(0);
    	
    	reportPIDRight.append("\tout:");
    	reportPIDRight.append(motorOutput);
    	reportPIDRight.append("\tspd:");
    	reportPIDRight.append(rightRear.getActiveTrajectoryVelocity() );
    	reportPIDRight.append("\terr:");
    	reportPIDRight.append(rightRear.getClosedLoopError(0));
    	reportPIDRight.append("\ttrg:");
    	reportPIDRight.append(targetSpeedRight);

    	return reportPIDRight.toString();
    }

}

