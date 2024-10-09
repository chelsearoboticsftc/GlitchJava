package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.hardware.digitalchickenlabs.OctoQuad;
import com.qualcomm.hardware.digitalchickenlabs.OctoQuadBase;

public class OdometryConstants {

    public static final int ODO_LEFT      = 0;
    public static final int ODO_RIGHT     = 1;
    public static final int ODO_CENTER    = 2;

    public static final OctoQuadBase.EncoderDirection ODO_LEFT_DIRECTION =
                                                    OctoQuadBase.EncoderDirection.REVERSE;
    public static final OctoQuadBase.EncoderDirection ODO_RIGHT_DIRECTION =
                                                    OctoQuadBase.EncoderDirection.FORWARD;
    public static final OctoQuadBase.EncoderDirection ODO_CENTER_DIRECTION =
                                                    OctoQuadBase.EncoderDirection.FORWARD;
}
