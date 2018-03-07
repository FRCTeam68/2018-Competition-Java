package org.usfirst.frc.team68.robot.commands;

import org.usfirst.frc.team68.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team68.robot.RobotMap;
/**
 *
 */
public class IntakeAuto extends Command {
	
	boolean isFinished = false;
	
	public IntakeAuto() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.intake);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.intake.intakeDownPosition();
		Robot.intake.setIntakeSpeed(RobotMap.INTAKE_A_SPEED_FORWARD, RobotMap.INTAKE_B_SPEED_FORWARD);
	}
	
	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return (Robot.intake.getSwitch() == false);
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.intake.intakeClamp();
		Timer.delay(0.1);
		Robot.intake.setIntakeSpeed(RobotMap.INTAKE_SPEED_STOP, RobotMap.INTAKE_SPEED_STOP);
		Robot.intake.intakeUpPosition();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.intake.setIntakeSpeed(RobotMap.INTAKE_SPEED_STOP, RobotMap.INTAKE_SPEED_STOP);

	}
}