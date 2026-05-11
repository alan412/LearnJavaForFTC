package org.firstinspires.ftc.teamcode.solutions;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp()
public class TouchSensorOpMode_6_2 extends OpMode {
    ProgrammingBoard_6_1 board = new ProgrammingBoard_6_1();

    @Override
    public void init() {
        board.init(hardwareMap);
    }

    @Override
    public void loop() {
        String touchSensorString = "Not Pressed";
        if (board.isTouchSensorPressed()) {
            touchSensorString = "Pressed";
        }
        telemetry.addData("Touch sensor", touchSensorString);
    }
}
