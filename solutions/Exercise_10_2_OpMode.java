package org.firstinspires.ftc.teamcode.solutions;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp()
public class Exercise_10_2_OpMode extends OpMode {
    ProgrammingBoard_10_1 board = new ProgrammingBoard_10_1();

    @Override
    public void init() {
        board.init(hardwareMap);
    }

    @Override
    public void loop() {
        double distanceCM = board.getDistance(DistanceUnit.CM);
        if (distanceCM < 10.0) {
            board.setMotorSpeed(0.0);
        } else {
            board.setMotorSpeed(0.5);
        }
        telemetry.addData("Distance (CM)", distanceCM);
    }
}
