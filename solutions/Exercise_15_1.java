package org.firstinspires.ftc.teamcode.solutions;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp()
public class Exercise_15_1 extends OpMode {
    ProgrammingBoard_6_1 board = new ProgrammingBoard_6_1();
    boolean wasPressed;

    @Override
    public void init() {
        board.init(hardwareMap);
    }

    @Override
    public void loop() {
        if (board.isTouchSensorPressed() && !wasPressed) {
            gamepad1.rumbleBlips(3);
        }
        wasPressed = board.isTouchSensorPressed();
    }
}
