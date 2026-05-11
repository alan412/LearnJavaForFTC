package org.firstinspires.ftc.teamcode.solutions;

import com.qualcomm.robotcore.hardware.DigitalChannel;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.mechanisms.TestItem;

public class TestDigitalChannel_14_1 extends TestItem {
    private DigitalChannel digitalChannel;

    public TestDigitalChannel_14_1(String description, DigitalChannel channel) {
        super(description);
        this.digitalChannel = channel;
    }

    @Override
    public void run(boolean on, Telemetry telemetry) {
        telemetry.addData("Sensor state: ", digitalChannel.getState());
    }
}
