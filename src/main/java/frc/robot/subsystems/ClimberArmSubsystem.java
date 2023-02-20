package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.util.pid.SparkMaxPIDSubsystem;
import frc.robot.Constants.ClimberPresets;
import frc.robot.util.math.GearRatio;
import frc.robot.util.pid.SparkMaxAngledPIDSubsystem;

import static com.revrobotics.CANSparkMaxLowLevel.MotorType.kBrushless;
import static frc.robot.Constants.ClimberPresets.CLIMBER_PRESETS;

public class ClimberArmSubsystem extends SubsystemBase {
    private final SparkMaxPIDSubsystem extension;
    private final SparkMaxAngledPIDSubsystem rotation;

    public ClimberArmSubsystem() {
        this.extension = new SparkMaxPIDSubsystem("Climber Extension", 7);
        this.rotation = new SparkMaxAngledPIDSubsystem("Climber Rotation", new GearRatio(1029), 8);
    
        extension.setPresetSupplier(() -> CLIMBER_PRESETS.getCurrentPreset("Climber Extension"));
        rotation.setTolerance(0.1);
        rotation.setPresetSupplier(() -> CLIMBER_PRESETS.getCurrentPreset("Climber Rotation"));
    }

    public SparkMaxPIDSubsystem getExtension() { return extension; }
    public SparkMaxAngledPIDSubsystem getRotation() { return rotation; }

}
