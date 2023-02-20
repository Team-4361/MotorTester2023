package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import frc.robot.Constants.ClimberPresets;
import frc.robot.util.math.GearRatio;
import frc.robot.util.pid.SparkMaxAngledPIDSubsystem;
import frc.robot.util.pid.SparkMaxPIDSubsystem;

import static com.revrobotics.CANSparkMaxLowLevel.MotorType.kBrushed;
import static frc.robot.Constants.ClimberPresets.CLIMBER_PRESETS;
import static frc.robot.Constants.ClimberWristValues.*;

public class ClimberWristSubsystem extends SparkMaxAngledPIDSubsystem {

    public ClimberWristSubsystem() {
        super(
                "Climber Wrist",
                new GearRatio(WRIST_GEAR_RATIO),
                new CANSparkMax(WRIST_MOTOR_ID, kBrushed),
                0.01,
                0,
                0
        );
        setTolerance(0.1);
        setPresetSupplier(() -> CLIMBER_PRESETS.getCurrentPreset("Climber Wrist"));
    }
}
