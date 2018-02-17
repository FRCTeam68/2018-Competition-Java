package org.usfirst.frc.team68.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team68.robot.Robot;
import org.usfirst.frc.team68.robot.RobotMap;



public class RetractRamp extends Command 
{
	boolean isFinished = false;

	
    public RetractRamp() 
   {
    	requires(Robot.endGame);
    }

    
    protected void initialize() 
    {
    }

    
    protected void execute()
   {
    	Robot.endGame.setRampSpeed(RobotMap.RAMP_MOTOR_1_BACKWARDS);
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

    	Robot.endGame.setRampSpeed(RobotMap.RAMP_MOTOR_1_STOP);
    	
    }
}
