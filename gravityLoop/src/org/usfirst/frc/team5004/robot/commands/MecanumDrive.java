package org.usfirst.frc.team5004.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5004.robot.Robot;

public class MecanumDrive extends Command{
	
	public MecanumDrive(){
		requires(Robot.driveTrain);
	}

	protected void initialize() {
		
	}

	protected void execute() {
		Robot.driveTrain.drive(); //repeatedly execute the mecanum wheel function
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.driveTrain.killMotors();
	}

	protected void interrupted() {
		Robot.driveTrain.killMotors();
	}

}
