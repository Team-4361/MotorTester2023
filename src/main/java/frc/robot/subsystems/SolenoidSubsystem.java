package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SolenoidSubsystem extends SubsystemBase{
    public Solenoid solenoid;

    public SolenoidSubsystem(PneumaticsModuleType pneumaticsModuleType){
        solenoid = new Solenoid(pneumaticsModuleType, 1);
    }
    public void openSolenoid(){
        solenoid.set(true);
    }
    public void closeSolenoid(){
        solenoid.set(false);
    }

    
}
