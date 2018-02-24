/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team68.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import jaci.pathfinder.Pathfinder;

import org.usfirst.frc.team68.robot.Path;
import org.usfirst.frc.team68.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class DrivetrainDriveTrajectory extends Command {

			public Path path;
			boolean firstRun = true;
			double l;
			double r;
			
		    public DrivetrainDriveTrajectory() 
		   {
		    	requires(Robot.driveTrain);
		    	path = new Path();
		    }

		    protected void initialize() 
		    {
		    }

		    protected void execute()
		   {
		    	
		    	SmartDashboard.putNumber("L Enc", Robot.driveTrain.getPositionLeft());
				SmartDashboard.putNumber("R Enc", Robot.driveTrain.getPositionRight());
				l = path.testEncLeft.calculate(Robot.driveTrain.getPositionLeft());
				r = path.testEncRight.calculate(Robot.driveTrain.getPositionRight());
				SmartDashboard.putNumber("path L", l);
				SmartDashboard.putNumber("path R", r);

				//double theta = -Robot.navX.getYaw();
				double theta = Robot.driveTrain.getGyroYaw();
				double desiredHeading = Pathfinder.r2d(path.testEncLeft.getHeading());
				double angleDifference = Pathfinder.boundHalfDegrees(desiredHeading-theta);
				SmartDashboard.putNumber("angle,", angleDifference);
				SmartDashboard.putNumber("Yaw", Robot.driveTrain.getGyroYaw());
				double turn = 0.8 * (-1.0/80.0) * angleDifference;

				Robot.driveTrain.drive(l+turn, r-turn);

		    	if(path.testEncLeft.isFinished() && path.testEncRight.isFinished()){
			    	Robot.driveTrain.drive(0, 0);
		    		System.out.println("Both trajectories finished");
		    	}
				//SmartDashboard.putNumber("Segment");

				firstRun = false;
		    }

		    protected boolean isFinished() 
		   {
		        return isFinished;
		    }

		    protected void end() 
		   {

		    }

		    protected void interrupted() 
		    {

		    }
		}
