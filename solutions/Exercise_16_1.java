package org.firstinspires.ftc.teamcode.solutions;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.processors.FirstVisionProcessor;
import org.firstinspires.ftc.vision.VisionPortal;

@Autonomous()
public class Exercise_16_1 extends OpMode {

    private FirstVisionProcessor visionProcessor;
    private VisionPortal visionPortal;
    ProgrammingBoard_8_1 board = new ProgrammingBoard_8_1();

    @Override
    public void init() {
        visionProcessor = new FirstVisionProcessor();
        visionPortal = VisionPortal.easyCreateWithDefaults(
                hardwareMap.get(WebcamName.class, "Webcam 1"), visionProcessor);
        board.init(hardwareMap);
    }

    @Override
    public void init_loop() {
    }

    @Override
    public void start() {
        visionPortal.stopStreaming();
    }

    @Override
    public void loop() {
        telemetry.addData("Identified", visionProcessor.getSelection());
        switch (visionProcessor.getSelection()) {
            case LEFT:
            case NONE:
                board.setServoPosition(0);
                break;
            case MIDDLE:
                board.setServoPosition(90);
                break;
            case RIGHT:
                board.setServoPosition(180);
                break;
        }
    }
}
