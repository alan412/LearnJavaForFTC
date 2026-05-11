package org.firstinspires.ftc.teamcode.solutions;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard5;

@TeleOp()
public class ServoGamepadOpMode_8_2 extends OpMode {
    ProgrammingBoard5 board = new ProgrammingBoard5();

    @Override
    public void init() {
        board.init(hardwareMap);
    }

    @Override
    public void loop() {
        board.setServoPosition(gamepad1.left_trigger);
    }
}
