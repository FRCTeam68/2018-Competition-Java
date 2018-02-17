package org.usfirst.frc.team68.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team68.robot.Robot;
import org.usfirst.frc.team68.robot.RobotMap;



public class ExtendPitHooks extends Command 
{
	boolean isFinished = false;

	
    public ExtendPitHooks() 
   {
    	requires(Robot.endGame);
    }

    
    protected void initialize() 
    {
    }

    
    protected void execute()
   {
    	Robot.endGame.setHookSpeed(RobotMap.HOOK_MOTOR_1_PITSPEED_FORWARDS);
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

     	Robot.endGame.setHookSpeed(RobotMap.HOOK_MOTOR_1_STOP);

    }
}
