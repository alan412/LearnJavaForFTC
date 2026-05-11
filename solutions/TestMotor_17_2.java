package org.firstinspires.ftc.teamcode.solutions;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.mechanisms.TestItem;


public class TestMotor_17_2 extends TestItem {
    private double speed;
    private DcMotor motor;

    /**
     * @param description what to show for the name of this test
     * @param speed       the speed that "on" should run the motor at
     * @param motor       the motor to test
     */
    public TestMotor_17_2(String description, double speed, DcMotor motor) {
        super(description);
        this.speed = speed;
        this.motor = motor;
    }

    /**
     * Runs the motor test and reports encoder values to telemetry
     *
     * @param on        whether to run the motor or stop the motor
     * @param telemetry where to put the encoder results
     */
    @Override
    public void run(boolean on, Telemetry telemetry) {
        if (on) {
            motor.setPower(speed);
        } else {
            motor.setPower(0.0);
        }
        telemetry.addData("Encoder:", motor.getCurrentPosition());
    }
}
