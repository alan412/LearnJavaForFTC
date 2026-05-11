package org.firstinspires.ftc.teamcode.solutions;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class Exercise_4_2 extends OpMode {
    @Override
    public void init() {

    }

    @Override
    public void loop() {
        double ySpeed = gamepad1.left_stick_y;
        double xSpeed = gamepad1.left_stick_x;

        if (gamepad1.a) {   // crazy mode
            ySpeed = gamepad1.left_stick_x;
            xSpeed = gamepad1.left_stick_y;

        }
        telemetry.addData("X Speed", xSpeed);
        telemetry.addData("Y Speed", ySpeed);
    }
}
