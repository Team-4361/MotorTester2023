package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class OpenSolenoidCommand extends CommandBase{
    
    public OpenSolenoidCommand(){
        addRequirements(Robot.solenoidSubsystem);
    }
    @Override
    public void initialize(){
        Robot.solenoidSubsystem.openSolenoid();
    }
    

    
}
