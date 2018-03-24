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
	private Button xboxManipulateSR;
	private Button xboxLeftJoyStickButton;
	
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
		xboxDriveX.whileHeld(new WinchUp());
		
		xboxDriveY = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_Y);
		xboxDriveY.whileHeld(new RetractHooks());
		
		xboxDriveA = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_A);
		xboxDriveA.whileHeld(new ExtendHooks());
	
		xboxDriveB = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_B);	
		//xboxDriveB.whileHeld(new WinchDown());		
		
		xboxDriveLB = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_LB);
		xboxDriveLB.whenPressed(new DriveShiftLow());
		
		xboxDriveRB = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_RB);
		xboxDriveRB.whenPressed(new DriveShiftHigh());

		xboxDriveStart = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_BS);

		xboxDriveB = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_B);	
		
		// Manipulator Xbox Controller Bindings
		xboxManipulate = new XboxController(RobotMap.XBOX_MANIPULATE); 

		//Lift Presets
		xboxManipulateLB = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_LB);
		xboxManipulateLB.whenPressed(new IntakeClamp());

		xboxManipulateRB = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_RB);
		xboxManipulateRB.whenPressed(new IntakeUpPosition());
		
		xboxManipulateX = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_X);
		xboxManipulateX.whileHeld(new LiftSetPosition2(RobotMap.LIFT_NORMAL_SCALE));

		xboxManipulateY = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_Y);
		xboxManipulateY.whileHeld(new LiftSetPosition2(RobotMap.LIFT_HIGH_SCALE));


		//Intake
		xboxManipulateB = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_B);
		xboxManipulateB.whileHeld(new LiftSetPosition2(RobotMap.LIFT_NORMAL_SWITCH));


		xboxManipulateA = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_A);
		xboxManipulateA.whileHeld(new LiftSetPosition2(RobotMap.LIFT_GROUND));
		
		
	}
	
	// Custom user defined methods should go here
	
	// Drivetrain Tank Drive Left 
	public double getLeftXboxJoystickValue() {
		double leftAxis;
		leftAxis = xboxDrive.getY(Hand.kLeft);
		// Allow for up to 10% of joystick noises
		leftAxis = (Math.abs(leftAxis) < 0.1) ? 0 : leftAxis;
    	return -leftAxis;
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
		leftAxis = xboxManipulate.getY(Hand.kLeft);
		/*if (leftAxis > 0) {
			leftAxis = 1/2 * leftAxis;
		}*/
		// Allow for up to 10% of joystick noise
    	return leftAxis;
	}
	
	public double getRightXboxManipulatorJoystick() {
		double leftAxis;
		leftAxis = -xboxManipulate.getY(Hand.kRight);
		/*if (leftAxis > 0) {
			leftAxis = 1/2 * leftAxis;
		}*/
		// Allow for up to 10% of joystick noise
    	return leftAxis;
	}
	
	//Intake In
	public double getXboxManipulateLT() {
		double leftAxis;
		leftAxis = xboxManipulate.getRawAxis(RobotMap.XBOX_MANIPULATE_LT);
		// Allow for up to 10% of joystick noise
    	return leftAxis;
	}
	
	public double getXboxManipulateRT() {
		double rightAxis;
		rightAxis = xboxManipulate.getRawAxis(RobotMap.XBOX_MANIPULATE_RT);
		// Allow for up to 10% of joystick noise
    	return rightAxis;
	}
}
