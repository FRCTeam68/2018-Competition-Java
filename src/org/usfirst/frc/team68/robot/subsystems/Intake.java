package org.usfirst.frc.team68.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.VictorSP;

import org.usfirst.frc.team68.robot.RobotMap;
import org.usfirst.frc.team68.robot.commands.IntakeManualIn;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
public class Intake extends Subsystem {
    
	private DoubleSolenoid intakeOrientation;

	private VictorSP intakeMotors;

    
    // Declare Class variables her
    private static Intake intake;
    private DigitalInput limitSwitch;
    Counter counter = new Counter(limitSwitch);
    

    
    public static Intake getIntake() {
    	if (intake == null) {
    		intake = new Intake();
    	}
    	return intake;
    }
    
    // Constructor
    private Intake()
    {
    	
    	intakeOrientation = new DoubleSolenoid(RobotMap.PCM_MAIN, RobotMap.INTAKE_UP, RobotMap.INTAKE_DOWN); 
    	intakeMotors = new VictorSP(RobotMap.INTAKE_MOTORS);
		limitSwitch = new DigitalInput(RobotMap.INTAKE_LIMIT_SWITCH);

    }
    
    public boolean isSwitchSet() {
        return counter.get() > 0;
    }

    public void initializeCounter() {
        counter.reset();
    }

    public void initDefaultCommand() 
    {
    	setDefaultCommand(new IntakeManualIn());    	
    }
    
    public void intakeUpPosition() 
    {
		intakeOrientation.set(Value.kReverse);
    }
    
    public void intakeDownPosition() 
    {
    	intakeOrientation.set(Value.kForward);
    }
        
    public void setIntakeSpeed(double speed) 
    {
    	
    	intakeMotors.set(speed);
    	
    }
    
    public double getIntakeSpeed()
    {
    	return intakeMotors.get();
    }

    public void intakeWithJoystick()
    {
    	
    }
    
    
}