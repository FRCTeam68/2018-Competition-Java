package org.usfirst.frc.team68.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team68.robot.commands.LeftAutoStartCommand;
import org.usfirst.frc.team68.robot.commands.RightAutoStartCommand;
import org.usfirst.frc.team68.robot.subsystems.Compressor;
import org.usfirst.frc.team68.robot.subsystems.DriveTrain;
import org.usfirst.frc.team68.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.TimedRobot;
import org.usfirst.frc.team68.robot.subsystems.Lift;
import org.usfirst.frc.team68.robot.subsystems.NavX;
import org.usfirst.frc.team68.robot.subsystems.USBCamera;
import org.usfirst.frc.team68.robot.subsystems.EndGame;

public class Robot extends IterativeRobot {
	
	public static RobotMap robotMap;
	public static Compressor compressor;
	public static DriveTrain driveTrain;
	public static Lift lift;
	public static Intake intake;
	public static OI oi;
	public static NavX navX;
	public static EndGame endGame;
	public static USBCamera camera;
    private LeftAutoStartCommand leftAuto;
    private RightAutoStartCommand rightAuto;

	Command autonomousCommand;
	SendableChooser<Command> autoChooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		// The RobotMap class should be the first to instantiate
		robotMap = RobotMap.getRobotMap();

		// Create a single instance of each Robot subsystem here
//		compressor = Compressor.getCompressor();
		navX = new NavX();
		driveTrain = DriveTrain.getDriveTrain();   
		lift = Lift.getLift();
        intake = Intake.getIntake();
		endGame = EndGame.getEndGame();
		camera = USBCamera.getCamera();
		// The OI class should be the last to be instantiated
		 autoChooser = new SendableChooser<>();
	     autoChooser.addObject("Left Start Auto", leftAuto);
	     autoChooser.addObject("Right Start Auto", rightAuto);
//	        autoChooser.addObject("Center Start Auto", new CenterAutoStartCommand());
	     autoChooser.addDefault("Auto-Run", new DriveXInchesCommand(100, 0.8));

	        SmartDashboard.putData("Autonomous", autoChooser);
		oi = OI.getOI();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		
		Robot.driveTrain.zeroEncoders();
		Robot.driveTrain.setShifterLow();

		autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		//driveTrain.GetLeftFront().enableBrakeMode(true);
		//driveTrain.GetRightFront().enableBrakeMode(true);
		
		//schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		Robot.driveTrain.setModePercentVbus();
    	Robot.driveTrain.setShifterLow();
    	Robot.driveTrain.zeroEncoders();
    	if (Robot.lift.getSwitchDown() == false) {
    		Robot.lift.zeroEncoder();
    	}
    	Robot.intake.intakeUpPosition();
    	Robot.intake.intakeNormal();

		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Lift Value Stick", Robot.oi.getXboxManipulateLT());
		SmartDashboard.putNumber("Lift Encoder Position", Robot.lift.getPosition());
		SmartDashboard.putBoolean("LiftSwitchDown", Robot.lift.getSwitchDown());
		SmartDashboard.putBoolean("LiftManual", Robot.lift.getManualStatus());

		if (Robot.lift.getSwitchDown() == false) {
    		Robot.lift.zeroEncoder();
    	}
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
	//	LiveWindow.run();
	}

} 
 