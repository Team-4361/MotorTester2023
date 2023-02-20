// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.util.pid.PresetGroup;
import frc.robot.util.pid.PresetList;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static class OperatorConstants {
        public static final int DRIVER_CONTROLLER_PORT = 0;
    }

    public static class ClimberWristValues {
        public static final int WRIST_MOTOR_ID = 5;
        public static final int WRIST_ENCODER_CPR = 8192;
        public static final int WRIST_GEAR_RATIO = 1;
    }

    public static class ClimberPresets {
        public static final PresetList EXTENSION_PRESETS = new PresetList(20.0, 40.0, 60.0, 80.0);

        public static final PresetList ROTATION_PRESETS = new PresetList(30.0, 60.0, 90.0, 120.0);
        public static final PresetList WRIST_PRESETS = new PresetList(0.0, 30.0, 60.0, 90.0);
    
        public static final PresetGroup CLIMBER_PRESETS = new PresetGroup()
            .addPreset("Climber Extension", EXTENSION_PRESETS)
            .addPreset("Climber Rotation", ROTATION_PRESETS)
            .addPreset("Climber Wrist", WRIST_PRESETS);
    }

}
