package ambos.oldbugs.mixin;

import net.minecraft.core.entity.vehicle.EntityMinecart;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import ambos.oldbugs.OldBugs;

@Mixin(value = EntityMinecart.class, remap = false)
final class EntityMinecartMixin {
    @ModifyVariable(method = "push", at = @At(value = "STORE"), ordinal = 6)
    private double change(double d6) {
        if (OldBugs.MINECART_BOOSTERS) {
            return 0;
        } else {
            return d6;
        }
    }
}
