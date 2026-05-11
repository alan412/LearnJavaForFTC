package org.firstinspires.ftc.teamcode.solutions;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp()
public class Exercise_2_2 extends OpMode {
    @Override
    public void init() {
        String myName = "Your Name";
        int grade = 38;

        telemetry.addData("Hello", myName);
        telemetry.addData("Grade", grade);
    }

    @Override
    public void loop() {

    }
}
