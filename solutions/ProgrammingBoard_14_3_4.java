package org.firstinspires.ftc.teamcode.solutions;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class ProgrammingBoard_14_3_4 extends ProgrammingBoard_14_3_3 {
    private double ticksPerRotation;

    public void init(HardwareMap hwMap) {
        super.init(hwMap);
        ticksPerRotation = motor.getMotorType().getTicksPerRev();
    }

    public double getMotorRotations() {
        return motor.getCurrentPosition() / ticksPerRotation;
    }
}
