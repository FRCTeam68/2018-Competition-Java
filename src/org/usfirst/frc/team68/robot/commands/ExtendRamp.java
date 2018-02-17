package org.usfirst.frc.team68.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team68.robot.Robot;
import org.usfirst.frc.team68.robot.RobotMap;



public class ExtendRamp extends Command 
{
	boolean isFinished = false;

	
    public ExtendRamp() 
   {
    	requires(Robot.endGame);
    }

    
    protected void initialize() 
    {
    	
    }

    
    protected void execute()
   {
    	Robot.endGame.setRampSpeed(RobotMap.RAMP_MOTOR_1_FORWARDS);
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
