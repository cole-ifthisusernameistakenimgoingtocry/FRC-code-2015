package org.usfirst.frc.team5004.robot.commands;

import org.usfirst.frc.team5004.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ForkCommand extends Command {

    public ForkCommand() {
    	requires(Robot.fork);
    }

    protected void initialize() {
    }

    protected void execute() {
    	if(Robot.oi.forkClose.get()){
    		Robot.fork.fork(-1.0);
    	}else if(Robot.oi.forkOpen.get()){
    		Robot.fork.fork(1.0);
    	}else{
    		Robot.fork.fork(0.0);
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.fork.fork(0.0);
    }

    protected void interrupted() {
    	Robot.fork.fork(0.0);
    }
}
