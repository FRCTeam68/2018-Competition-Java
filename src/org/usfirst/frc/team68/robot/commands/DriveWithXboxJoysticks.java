package org.usfirst.frc.team68.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team68.robot.Robot;


public class DriveWithXboxJoysticks extends Command {
	
	boolean isFinished = false;	
	
	public DriveWithXboxJoysticks() {
		
		requires(Robot.driveTrain);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		if (Math.abs(Robot.lift.getPosition()) > 50000){
			Robot.driveTrain.tankDrive(Robot.oi.getLeftXboxJoystickValue() * .75, Robot.oi.getRightXboxJoystickValue() * .75);
		}
		
		else {
			Robot.driveTrain.tankDrive(Robot.oi.getLeftXboxJoystickValue(), Robot.oi.getRightXboxJoystickValue());
		}
   		
	}

	@Override
	protected boolean isFinished() {
		return isFinished;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
}


