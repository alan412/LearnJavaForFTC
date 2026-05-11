package org.firstinspires.ftc.teamcode.solutions;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ProgrammingBoard_14_3_3 extends ProgrammingBoard_14_3_2 {
    protected DcMotor motor;

    public void init(HardwareMap hwMap) {
        super.init(hwMap);
        motor = hwMap.get(DcMotor.class, "motor");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void setMotorSpeed(double speed) {
        motor.setPower(speed);
    }
}
