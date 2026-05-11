package org.firstinspires.ftc.teamcode.solutions;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp()
public class Exercise_18_1 extends OpMode {
    boolean wasA;

    @Override
    public void init() {
        telemetry.speak("Initialized");
    }

    @Override
    public void loop() {
        if (gamepad1.a && !wasA) {
            telemetry.speak("A button pressed");
        }
        wasA = gamepad1.a;
    }
}
