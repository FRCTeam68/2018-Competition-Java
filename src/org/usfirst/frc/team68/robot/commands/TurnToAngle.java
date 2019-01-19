package org.usfirst.frc.team68.robot.commands;
import org.usfirst.frc.team68.robot.Robot;
import org.usfirst.frc.team68.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class TurnToAngle extends Command {
	
	double _angle;
	int count;
	
    public TurnToAngle(double angle) {
    	_angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	count = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.setRobotHeading(_angle);
    	count++;
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.navX.getAngle() < _angle + RobotMap.rotateToAngleHiEnd && Robot.navX.getAngle() > _angle - RobotMap.rotateToAngleLoEnd) || count > 50;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("Done Turning " + Robot.navX.getAngle());
    	Robot.driveTrain.stopDriving();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}