package ambos.oldbugs.mixin;

import net.minecraft.core.entity.vehicle.EntityBoat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = EntityBoat.class, remap = false)
final class EntityBoatMixin {
    @ModifyConstant(method = "tick", constant = @Constant(doubleValue = 1.0, ordinal = 1))
    private double change(double d) {
        return Double.MAX_VALUE;
    }
}
