package org.usfirst.frc.team4229.robot.subsystems;

import org.usfirst.frc.team4229.robot.Robot;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class GyroPID extends PIDSubsystem {

    // Initialize your subsystem here
    public GyroPID() {
    	super("GyroPID", 2.0, 0.0, 0.0);
    	getPIDController().setContinuous(false);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return Robot.gyro.getAngle();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	Robot.drivetrain.drive(-output, output);
    }
}
