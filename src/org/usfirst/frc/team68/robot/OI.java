package org.usfirst.frc.team68.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team68.robot.commands.*;

import edu.wpi.first.wpilibj.GenericHID.Hand;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	// Driver's Xbox Controller
	private XboxController xboxDrive;
	private Button xboxDriveA;
	private Button xboxDriveB;
	private Button xboxDriveX;
	private Button xboxDriveY;
	private Button xboxDriveRB;
	private Button xboxDriveLB;
	private Button xboxDriveBack;
	private Button xboxDriveStart;
	
	private XboxController xboxManipulate;
	private Button xboxManipulateLB;
	private Button xboxManipulateX;
	private Button xboxManipulateY;
	private Button xboxManipulateRB;
	private Button xboxManipulateA;
	private Button xboxManipulateB;
	private Button xboxManipulateLT;
	private Button xboxManipulateShare;
	private Button xboxManipulateOptions;
	
	private static OI oi;
	

	public static OI getOI(){
		if (oi == null) {
			oi = new OI();
		}
		return oi;	
	}
	
	
	private OI() {
		
		xboxDrive = new XboxController(RobotMap.XBOX_DRIVE);	
		
		xboxDriveX = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_X);
		xboxDriveX.whenPressed(new ExtendRamp());
		
		xboxDriveY = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_Y);
		xboxDriveY.whenPressed(new RetractRamp());
		
		xboxDriveA = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_A);
		xboxDriveA.whenPressed(new RetractHooks());
	
		xboxDriveB = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_B);	
		xboxDriveB.whenPressed(new ExtendHooks());		
		
		xboxDriveLB = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_LB);
		xboxDriveLB.whenPressed(new DriveShiftLow());
		
		xboxDriveRB = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_RB);
		xboxDriveRB.whenPressed(new DriveShiftHigh());

		xboxDriveStart = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_BS);

		xboxDriveB = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_B);	
		
		// Manipulator Xbox Controller Bindings
		xboxManipulate = new XboxController(RobotMap.XBOX_MANIPULATE); 

		xboxManipulateLB = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_LB);
		
		xboxManipulateX = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_X);
		
		xboxManipulateY = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_Y);
		
		xboxManipulateRB = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_RB);

		xboxManipulateA = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_B);
		xboxManipulateA.whileHeld(new IntakeManualOut());

		xboxManipulateB = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_A);
		xboxManipulateB.whenPressed(new IntakeAuto());
		
		xboxManipulateOptions = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_OPTIONS);
		xboxManipulateOptions.whenPressed(new IntakeUpPosition());
		
		xboxManipulateShare = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_SHARE);
		xboxManipulateShare.whenPressed(new IntakeDownPosition());

	}
	
	// Custom user defined methods should go here
	
	// Drivetrain Tank Drive Left 
	public double getLeftXboxJoystickValue() {
		double leftAxis;
		leftAxis = xboxDrive.getY(Hand.kLeft);
		// Allow for up to 10% of joystick noises
		leftAxis = (Math.abs(leftAxis) < 0.1) ? 0 : leftAxis;
    	return leftAxis;
	}

	// Drivetrain Tank Drive Right
	public double getRightXboxJoystickValue() {
		double rightAxis;
		rightAxis = xboxDrive.getY(Hand.kRight);
		// Allow for up to 10% of joystick noise
		rightAxis = (Math.abs(rightAxis) < 0.1) ? 0 : rightAxis;
    	return rightAxis;
    	
	}
	
	// Manipulator Joystick for Lift
	public double getLeftXboxManipulatorJoystick() {
		double leftAxis;
		leftAxis = xboxManipulate.getY(Hand.kLeft)/2;
		SmartDashboard.putNumber("OISpeed", leftAxis);
		// Allow for up to 10% of joystick noise
		leftAxis = (Math.abs(leftAxis) < 0.1) ? 0 : leftAxis;
    	return leftAxis;
	}
	
	//Intake In
	public double getXboxManipulateLT() {
		double leftAxis;
		leftAxis = xboxManipulate.getRawAxis(RobotMap.XBOX_MANIPULATE_LT);
		// Allow for up to 10% of joystick noise
		leftAxis = (Math.abs(leftAxis) < 0.1) ? 0 : leftAxis;
    	return leftAxis;
	}

	
}
