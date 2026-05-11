package org.firstinspires.ftc.teamcode.solutions;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp()
public class Exercise_9_2 extends OpMode {
    ProgrammingBoard_9_1 board = new ProgrammingBoard_9_1();

    @Override
    public void init() {
        board.init(hardwareMap);
    }

    @Override
    public void loop() {
        double potValue = board.getPotRange();

        telemetry.addData("Pot Value", potValue);

        board.setServoPosition(potValue);
    }
}
