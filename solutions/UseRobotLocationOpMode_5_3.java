package org.firstinspires.ftc.teamcode.solutions;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp
public class UseRobotLocationOpMode_5_3 extends OpMode {
    RobotLocation_5_3 robotLocation = new RobotLocation_5_3(0);

    @Override
    public void init() {
        robotLocation.setAngle(0);
    }

    @Override
    public void loop() {
        if (gamepad1.a) {
            robotLocation.turn(0.1);
        } else if (gamepad1.b) {
            robotLocation.turn(-0.1);
        }
        if (gamepad1.dpad_left) {
            robotLocation.changeX(-0.1);
        } else if (gamepad1.dpad_right) {
            robotLocation.changeX(0.1);
        }
        if (gamepad1.dpad_up) {
            robotLocation.changeY(-0.1);
        } else if (gamepad1.dpad_down) {
            robotLocation.changeY(0.1);
        }
        telemetry.addData("Location", robotLocation);
        telemetry.addData("Heading", robotLocation.getHeading());
    }
}
