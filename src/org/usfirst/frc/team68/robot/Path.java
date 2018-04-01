package org.usfirst.frc.team68.robot;

import java.io.File;

import org.usfirst.frc.team68.robot.commands.DrivetrainDriveTrajectory;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;

public class Path {
	double timeStep = 0.05;
	double maxVel = 3;
	double maxAccel = 2;
	double maxJerk = 80;
	double wheelBaseWidth = 2.208333;
	int ticksPerRev = 8400; 
	double wheelDiameter = 0.33333333;

	double p = 3;
	double i = 0.0;
	double d = 0.5;
	double velocityRatio = 1/maxVel;
	double accelGain = 0.0;	
	// The first argument is the proportional gain. Usually this will be quite high
		// The second argument is the integral gain. This is unused for motion profiling
		// The third argument is the derivative gain. Tweak this if you are unhappy with the tracking of the trajectory
		// The fourth argument is the velocity ratio. This is 1 over the maximum velocity you provided in the 
		//	      trajectory configuration (it translates m/s to a -1 to 1 scale that your motors can read)
		// The fifth argument is your acceleration gain. Tweak this if you want to get to a higher or lower speed quicker

		double l;
		double r;

		public Trajectory forwardLeftTrajectory;
		public Trajectory forwardRightTrajectory;
		Trajectory forwardTrajectory;
		public EncoderFollower testEncLeft;
		public EncoderFollower testEncRight;
		
	
	public Path(File leftCSV, File rightCSV) {
		try{	
			System.out.println("Generating trajectory...");
			Trajectory trajectoryLW = Pathfinder.readFromCSV(leftCSV);
			Trajectory trajectoryRW = Pathfinder.readFromCSV(rightCSV);


			System.out.println("Trajectory Generation completed");
			
						
			testEncLeft = new EncoderFollower(trajectoryLW);
			testEncRight = new EncoderFollower(trajectoryRW);
			testEncLeft.configureEncoder(Robot.driveTrain.getPositionLeftPF(), ticksPerRev, wheelDiameter);
			testEncRight.configureEncoder(Robot.driveTrain.getPositionRightPF(), ticksPerRev, wheelDiameter);
			testEncLeft.configurePIDVA(p, i, d, velocityRatio, accelGain);
			testEncRight.configurePIDVA(p, i, d, velocityRatio, accelGain);
			Robot.driveTrain.setModePercentVbus();
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error in Path Construction" + e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
}
