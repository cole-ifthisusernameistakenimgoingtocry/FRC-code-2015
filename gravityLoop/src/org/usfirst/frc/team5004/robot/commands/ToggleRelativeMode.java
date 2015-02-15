package org.usfirst.frc.team5004.robot.commands;

import org.usfirst.frc.team5004.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleRelativeMode extends Command {
	
	boolean finished = false;

    public ToggleRelativeMode() {
    	requires(Robot.driveTrain);
    }

    protected void initialize() {
    	Robot.driveTrain.toggleRelative();
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
