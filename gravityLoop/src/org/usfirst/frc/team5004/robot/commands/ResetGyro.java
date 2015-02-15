package org.usfirst.frc.team5004.robot.commands;

import org.usfirst.frc.team5004.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ResetGyro extends Command {
	
	public ResetGyro(){
		requires(Robot.gyro);
	}
	
	boolean finished = false;

	protected void initialize() {
		Robot.gyro.reset();
		finished = true;
	}

	protected void execute() {

	}

	protected boolean isFinished() {
		return finished;
	}

	protected void end() {
	}

	protected void interrupted() {
		
	}

}
