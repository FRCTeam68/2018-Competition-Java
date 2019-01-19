package org.usfirst.frc.team68.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team68.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;



public class EndGame extends Subsystem {
	
	private VictorSP hookMotor1;
	private VictorSP hookMotor2;
	private WPI_TalonSRX winchMotor1;
	private WPI_TalonSRX winchMotor2;
	private DigitalInput limitSwitchA;
	private DigitalInput limitSwitchB;
/*	private AnalogInput hookSensorA;
	private AnalogInput hookSensorB;*/

	
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
		winchMotor1 = new WPI_TalonSRX(RobotMap.WINCH_MOTOR_1);
		winchMotor2 = new WPI_TalonSRX(RobotMap.WINCH_MOTOR_2);
		limitSwitchA = new DigitalInput(RobotMap.HOOK_LIMIT_SWITCH_A);
		limitSwitchB = new DigitalInput(RobotMap.HOOK_LIMIT_SWITCH_B);
/*		hookSensorA = new AnalogInput(RobotMap.HOOK_SENSOR_A);
		hookSensorB = new AnalogInput(RobotMap.HOOK_SENSOR_B);
*/		SmartDashboard.putBoolean("LimitSwitchHookA", limitSwitchA.get());
		SmartDashboard.putBoolean("LimitSwitchHookB", limitSwitchB.get());
		
		winchMotor1.setNeutralMode(NeutralMode.Coast);
		winchMotor2.setNeutralMode(NeutralMode.Coast);
	}
    
    
    
	public void initDefaultCommand() {
		
	}	
	
	
	
	public void setHookSpeed(double speedE, double speedF)
	{
			hookMotor1.set(speedE);
			hookMotor2.set(speedF);
			
	}	
	
	public void setHookSpeed2(double speed) {
		hookMotor2.set(speed);
	}

	public void setWinchSpeed(double speedC, double speedD)
	{
			winchMotor1.set(speedC);
			winchMotor2.set(speedD);	
	}
	
	public boolean getSwitchA() {
		return limitSwitchA.get();
	}
	
	public boolean getSwitchB() {
		return limitSwitchB.get();
	}
	
}