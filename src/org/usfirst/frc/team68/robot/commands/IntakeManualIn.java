package org.usfirst.frc.team68.robot.commands;

import org.usfirst.frc.team68.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team68.robot.RobotMap;
/**
 *
 */
public class IntakeManualIn extends Command {
	
	boolean isFinished = false;
	
	public IntakeManualIn() {
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
		Robot.intake.setIntakeSpeed(Robot.oi.getXboxManipulateLT());
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return isFinished;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.intake.setIntakeSpeed(RobotMap.INTAKE_SPEED_STOP);
	}
}