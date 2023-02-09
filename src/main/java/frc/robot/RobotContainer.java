// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
    // The robot's subsystems and commands are defined here...
    private final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();

    private SlewRateLimiter rateLimiter = new SlewRateLimiter(3);

    // Replace with CommandPS4Controller or CommandJoystick if needed
    private final CommandXboxController xbox = new CommandXboxController(2);

    public static double pidSpeed = 3000;

    public static PIDMotor fl, fr, bl, br;
    public static Servo servo;

    public WPI_TalonSRX talon2;

    //public static WPI_TalonSRX talon2;

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        // Configure the trigger bindings
        fl = new PIDMotor(5, MotorType.kBrushless);
        fr = new PIDMotor(6, MotorType.kBrushless);
        bl = new PIDMotor(7, MotorType.kBrushless);
        br = new PIDMotor(8, MotorType.kBrushed);
        servo = new Servo(1);
        talon2 = new WPI_TalonSRX(12);

        servo.setBounds(2.43, 2.43, 1.49, 0.557, 0.557);

        //servo.setBounds(100, 100, 0, -100, -100);
        configureBindings();
    }

    /**
     * Use this method to define your trigger->command mappings. Triggers can be created via the
     * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
     * predicate, or via the named factories in {@link
     * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
     * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
     * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
     * joysticks}.
     */
    private void configureBindings() {
        // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
        
        
        xbox.x().whileTrue(Commands.run(() -> {
            fl.set(xbox.getLeftY());
            fr.set(xbox.getLeftY());
            bl.set(xbox.getLeftY());
            br.set(xbox.getLeftY());
            talon2.set(xbox.getLeftY());
        }));

        xbox.a().onTrue(Commands.runOnce(() -> {
            fl.getEncoder().setPosition(0);
            fr.getEncoder().setPosition(0);
            bl.getEncoder().setPosition(0);
            //br.getEncoder().setPosition(0);    
        }));

        xbox.povUp().onTrue(Commands.runOnce(() -> {
            pidSpeed+=100;
        }));

        xbox.povDown().onTrue(Commands.runOnce(() -> {
            pidSpeed-=100;
            /* 
             * 
             * 
             */
        }));

        SmartDashboard.putNumber("Servo Angle", 0);
        
        xbox.y().whileTrue(Commands.run(() -> {
            servo.setSpeed(xbox.getLeftY());
        }));
    }


    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // An example command will be run in autonomous
        return Autos.exampleAuto(exampleSubsystem);
    }
}
