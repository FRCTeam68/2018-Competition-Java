/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team68.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team68.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class IntakeToggleOrientation extends Command {
			boolean isFinished = false;

		    public IntakeToggleOrientation() 
		   {
		    	requires(Robot.intake);
		    }

		    protected void initialize() 
		    {

		    }

		    protected void execute()
		   {
		    	
		    	Robot.intake.toggleIntake();
		    	isFinished = true;
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
