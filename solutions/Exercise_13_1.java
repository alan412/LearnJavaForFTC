package org.firstinspires.ftc.teamcode.solutions;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp()
public class Exercise_13_1 extends OpMode {
    String[] lines = {
            "Then he waddled away",
            "(Waddle waddle)",
            "Then he waddled away",
            "(Waddle waddle waddle)",
            "Then he waddled away",
            "(Waddle waddle)",
            "'Til the very next day",
            "(Bum bum bum bum bum ba-dum)"};
    int lineIndex;
    double DELAY_SECS = 0.5;

    double nextTime;

    @Override
    public void init() {
        lineIndex = 0;
    }

    @Override
    public void loop() {
        if (nextTime < getRuntime()) {
            lineIndex++;
            if (lineIndex >= lines.length) {
                lineIndex = lines.length - 1;
            }
            nextTime = getRuntime() + DELAY_SECS;
        }
        telemetry.addLine(lines[lineIndex]);
    }
}
