package org.firstinspires.ftc.teamcode.solutions;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp()
public class MotorOpMode_7_2 extends OpMode {
    ProgrammingBoard_7_1 board = new ProgrammingBoard_7_1();

    @Override
    public void init() {
        board.init(hardwareMap);
    }

    double squareInputWithSign(double input) {
        double output = input * input;
        if (input < 0) {
            output = output * -1;
        }
        return output;
    }

    @Override
    public void loop() {
        double motorSpeed = squareInputWithSign(gamepad1.left_stick_y);

        board.setMotorSpeed(motorSpeed);
    }
}
