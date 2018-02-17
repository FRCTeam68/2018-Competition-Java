package org.usfirst.frc.team68.robot.commands;

import org.usfirst.frc.team68.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

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
        //Check if problem
		Robot.intake.initializeCounter();

		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
		Robot.intake.setIntakeSpeed(RobotMap.INTAKE_SPEED_FORWARD);
		
	}
	
	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return Robot.intake.isSwitchSet();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.intake.setIntakeSpeed(RobotMap.INTAKE_SPEED_STOP);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.intake.setIntakeSpeed(RobotMap.INTAKE_SPEED_STOP);
	}
}