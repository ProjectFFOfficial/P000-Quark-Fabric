package net.projectff.quarkfabric.internal_zeta.org;

import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.projectff.quarkfabric.internal_zeta.math.fast.SpeedyMath;

public class MiscUtil {

    public MiscUtil() {

    }

    public static Vec2f getMinecraftAnglesLossy(Vec3d direction) {
        direction = direction.normalize();
        double pitch = SpeedyMath.asin(direction.y);
        double yaw = SpeedyMath.asin(direction.x / SpeedyMath.cos(pitch));
        return new Vec2f((float)(pitch * 180.0 / Math.PI), (float)(-yaw * 180.0 / Math.PI));
    }
}
