package org.firstinspires.ftc.teamcode.solutions;

import org.firstinspires.ftc.teamcode.mechanisms.TestAnalogInput;
import org.firstinspires.ftc.teamcode.mechanisms.TestItem;
import org.firstinspires.ftc.teamcode.mechanisms.TestMotor;

import java.util.ArrayList;

public class ProgrammingBoard_14_3_9 extends ProgrammingBoard_14_3_8 {
    public ArrayList<TestItem> getTests() {
        ArrayList<TestItem> tests = new ArrayList<>();
        tests.add(new TestMotor("PB Motor", 0.5, motor));
        tests.add(new TestAnalogInput("PB Pot", pot, 0, 270));
        return tests;
    }
}
