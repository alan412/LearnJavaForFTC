package org.firstinspires.ftc.teamcode.solutions;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

public class ProgrammingBoard_14_3_6 extends ProgrammingBoard_14_3_5 {
    protected AnalogInput pot;

    public void init(HardwareMap hwMap) {
        pot = hwMap.get(AnalogInput.class, "pot");
    }

    public double getPotAngle() {
        return Range.scale(pot.getVoltage(), 0, pot.getMaxVoltage(), 0, 270);
    }
}
