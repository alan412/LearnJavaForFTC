package org.firstinspires.ftc.teamcode.solutions;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.util.ArrayList;

@TeleOp()
public class Exercise_13_2 extends OpMode {
    ArrayList<String> lines = new ArrayList<>();

    int lineIndex;
    double DELAY_SECS = 0.5;

    double nextTime;

    @Override
    public void init() {
        lineIndex = 0;
        lines.clear();
        lines.add("Then he waddled away");
        lines.add("(Waddle waddle)");
        lines.add("Then he waddled away");
        lines.add("(Waddle waddle waddle)");
        lines.add("Then he waddled away");
        lines.add("(Waddle waddle)");
        lines.add("'Til the very next day");
        lines.add("(Bum bum bum bum bum ba-dum)");
        lines.add("");
    }

    @Override
    public void loop() {
        if (nextTime < getRuntime()) {
            lineIndex++;
            if (lineIndex >= lines.size()) {
                lineIndex = 0;
            }
            nextTime = getRuntime() + DELAY_SECS;
        }
        telemetry.addLine(lines.get(lineIndex));
    }
}
