package org.usfirst.frc.team5004.robot.commands;

import org.usfirst.frc.team5004.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ForkClose extends Command {

    public ForkClose() {
        requires(Robot.fork);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.fork.fork(-1);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
