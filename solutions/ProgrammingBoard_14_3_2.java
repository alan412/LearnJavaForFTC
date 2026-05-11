package org.firstinspires.ftc.teamcode.solutions;

public class ProgrammingBoard_14_3_2 extends ProgrammingBoard_14_3_1 {
    public boolean isTouchSensorPressed() {
        return !touchSensor.getState();
    }
}
