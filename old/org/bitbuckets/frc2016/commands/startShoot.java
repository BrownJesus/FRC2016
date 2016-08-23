package org.bitbuckets.frc2016.commands;

import org.bitbuckets.frc2016.Constants;
import org.bitbuckets.frc2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class startShoot extends Command {
	private long timeInit;
	
    public startShoot() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.shooty);
        requires(Robot.sucky);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timeInit = System.currentTimeMillis();
    	Robot.sucky.intakeOut();	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return System.currentTimeMillis()>timeInit+Constants.SHOOT_DELAY_TIME;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooty.setMotor(Constants.SHOOTER_SPEED);
    	Robot.sucky.intakeOff();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.sucky.intakeOff();
    	Robot.shooty.setMotor(0);
    }
}