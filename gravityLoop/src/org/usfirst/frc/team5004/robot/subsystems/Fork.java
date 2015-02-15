package org.usfirst.frc.team5004.robot.subsystems;

import org.usfirst.frc.team5004.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Fork extends Subsystem {

	CANTalon motor = new CANTalon(RobotMap.fork);
	
	public void fork()
	
	protected void initDefaultCommand() {
		
	}

}
