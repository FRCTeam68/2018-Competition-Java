package org.usfirst.frc.team68.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team68.robot.Robot;


public class IntakeManualXboxJoysticks extends Command {
	
	boolean isFinished = false;
	private double speedLeft;
	private double speedRight;
	
	
	public IntakeManualXboxJoysticks() {
		
		requires(Robot.intake);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		/*if (Robot.intake.getSwitch() == true && ((Robot.oi.getLeftXboxManipulatorJoystick() > 0.01) && (Robot.oi.getRightXboxManipulatorJoystick() < 0.01)))
		{
			
		}*/
		

		
		
		if (Robot.intake.getSwitch() == false && (Robot.oi.getLeftXboxManipulatorJoystick() > 0.05) && (Robot.oi.getRightXboxManipulatorJoystick() < 0.05))  {
			//Robot.intake.intakeUpPosition();
			Robot.intake.intakeClamp();
			Robot.intake.setIntakeSpeedLeft(0);
	   		Robot.intake.setIntakeSpeedRight(0);
		}
		
		if (Robot.intake.getSwitch() == true && (Robot.oi.getLeftXboxManipulatorJoystick() < 0.5) && (Robot.oi.getRightXboxManipulatorJoystick() > 0.5))  {
			Robot.intake.intakeNormal();
			Robot.intake.setIntakeSpeedLeft(Robot.oi.getLeftXboxManipulatorJoystick()/2);
			Robot.intake.setIntakeSpeedRight(Robot.oi.getRightXboxManipulatorJoystick()/2);
		}
		
		else {
			Robot.intake.setIntakeSpeedLeft(Robot.oi.getLeftXboxManipulatorJoystick());
	   		Robot.intake.setIntakeSpeedRight(Robot.oi.getRightXboxManipulatorJoystick());
		}
		
		if (Robot.oi.getXboxManipulateLT() > 0) {
   			Robot.intake.intakeNormal();
   		}
   		
   		if (Robot.oi.getXboxManipulateRT() > 0) {
   			Robot.intake.intakeDownPosition();
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


