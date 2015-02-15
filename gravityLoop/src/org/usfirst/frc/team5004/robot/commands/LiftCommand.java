package org.usfirst.frc.team5004.robot.commands;

import org.usfirst.frc.team5004.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftCommand extends Command {

    public LiftCommand() {
        requires(Robot.lift);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.lift.lift();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
