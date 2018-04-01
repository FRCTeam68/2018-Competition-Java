/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team68.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team68.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class LiftManual extends Command {
	public LiftManual() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.lift);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		/*double speed;
		speed = Robot.oi.getLeftXboxManipulatorJoystick()/1.5;
		Robot.lift.setLiftSpeed(speed);*/
		
		double position;
		position = Robot.lift.getPosition();
		
		if (Robot.oi.getPOVManipulator() == 0) {
			Robot.lift.setPosition(position - 200.0);
			
		}
		
		/*else if (Robot.oi.getPOVManipulator() == 180) {
			Robot.lift.setPosition(position + 750.0);
		}*/
	
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
