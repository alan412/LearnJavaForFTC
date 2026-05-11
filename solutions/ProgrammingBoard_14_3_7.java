package org.firstinspires.ftc.teamcode.solutions;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class ProgrammingBoard_14_3_7 extends ProgrammingBoard_14_3_6 {
    protected ColorSensor colorSensor;
    protected DistanceSensor distanceSensor;

    public void init(HardwareMap hwMap) {
        super.init(hwMap);
        colorSensor = hwMap.get(ColorSensor.class, "sensor_color_distance");
        distanceSensor = hwMap.get(DistanceSensor.class, "sensor_color_distance");
    }

    public int getAmountRed() {
        return colorSensor.red();
    }

    public double getDistance(DistanceUnit du) {
        return distanceSensor.getDistance(du);
    }
}
