package org.usfirst.frc.team5004.robot.subsystems;

import org.usfirst.frc.team5004.robot.Robot;
import org.usfirst.frc.team5004.robot.RobotMap;
import org.usfirst.frc.team5004.robot.commands.LiftCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lift extends Subsystem {

	CANTalon left = new CANTalon(RobotMap.leftPulley);
	CANTalon right = new CANTalon(RobotMap.rightPulley);
	
	{
		//left.changeControlMode(ControlMode.);
		//right motor is a follower
		right.changeControlMode(ControlMode.Follower);
		//right motor follows left motor
		right.set(left.getDeviceID()); 
		//right motor is reversed
		//right.reverseOutput(true);
	}
	
	public void lift(){
		left.set((Robot.oi.joySecondary1.getY()*0.8));
		//right.set(-(Robot.oi.joySecondary1.getY()*0.1));
	} 
	
	protected void initDefaultCommand() {
		setDefaultCommand(new LiftCommand());
	}
}
