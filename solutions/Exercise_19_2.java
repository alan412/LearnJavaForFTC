package org.firstinspires.ftc.teamcode.solutions;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.Polar;

@TeleOp()
public class Exercise_19_2 extends OpMode {
    @Override
    public void init() {

    }

    @Override
    public void loop() {
        Polar leftStick = new Polar(gamepad1.left_stick_x, -gamepad1.left_stick_y);
        Polar rightStick = new Polar(gamepad1.right_stick_x, -gamepad1.right_stick_y);

        telemetry.addData("Left", "%+.0f", leftStick.getAngle(AngleUnit.DEGREES));
        telemetry.addData("Right", "%+.0f", rightStick.getAngle(AngleUnit.DEGREES));
    }
}
