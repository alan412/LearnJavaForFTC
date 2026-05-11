package org.firstinspires.ftc.teamcode.solutions;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ProgrammingBoard_14_3_5 extends ProgrammingBoard_14_3_4 {
    protected Servo servo;

    public void init(HardwareMap hwMap) {
        super.init(hwMap);
        servo = hwMap.get(Servo.class, "servo");
    }

    public void setServoPosition(double position) {
        servo.setPosition(position);
    }
}
