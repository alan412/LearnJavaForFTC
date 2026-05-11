package org.firstinspires.ftc.teamcode.solutions;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard8;

@TeleOp()
public class Exercise_11_1 extends OpMode {
    ProgrammingBoard8 board = new ProgrammingBoard8();

    @Override
    public void init() {
        board.init(hardwareMap);
    }

    @Override
    public void loop() {
        telemetry.addData("Our Heading (DEG)", board.getHeading(AngleUnit.DEGREES));
        telemetry.addData("Our Heading (RAD)", board.getHeading(AngleUnit.RADIANS));
    }
}
