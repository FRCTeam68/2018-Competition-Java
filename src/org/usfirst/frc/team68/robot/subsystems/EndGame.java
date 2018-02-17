package org.usfirst.frc.team68.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;	
import org.usfirst.frc.team68.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.VictorSP;



public class EndGame extends Subsystem {
	
	private VictorSP hookMotor1;
	private VictorSP hookMotor2;
	private WPI_TalonSRX rampMotor1;
	private WPI_TalonSRX rampMotor2;
	
	
    private static EndGame endgame;

    
    public static EndGame getEndGame() {
    	if (endgame == null) {
    		endgame = new EndGame();
    	}
    	return endgame;
    }
	
	private EndGame()
	{
		
		hookMotor1 = new VictorSP(RobotMap.HOOK_MOTOR_1);	
		hookMotor2 = new VictorSP(RobotMap.HOOK_MOTOR_2);	
		rampMotor1 = new WPI_TalonSRX(RobotMap.RAMP_MOTOR_1);
		rampMotor2 = new WPI_TalonSRX(RobotMap.RAMP_MOTOR_2);
	}
    
    
    
	public void initDefaultCommand() {
		
	}	
	
	
	
	public void setHookSpeed(double speed)
	{
			hookMotor1.set(speed);
			hookMotor2.set(speed);
			
	}	

	public void setRampSpeed(double speed)
	{
			rampMotor1.set(speed);
			rampMotor2.set(speed);	
	}
}