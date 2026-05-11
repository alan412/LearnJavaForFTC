package org.firstinspires.ftc.teamcode.solutions;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp()
public class MotorOpMode_7_1 extends OpMode {
    ProgrammingBoard_7_1 board = new ProgrammingBoard_7_1();

    @Override
    public void init() {
        board.init(hardwareMap);
    }

    @Override
    public void loop() {
        double motorSpeed = gamepad1.left_stick_y;

        board.setMotorSpeed(motorSpeed);
        telemetry.addData("speed", motorSpeed);
        if (gamepad1.a) {
            board.setMotorZeroBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            telemetry.addData("Zero", "Brake");
        } else if (gamepad1.b) {
            board.setMotorZeroBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            telemetry.addData("Zero", "Float");
        }
    }
}
