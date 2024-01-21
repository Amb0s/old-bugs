package turniplabs.oldbugs.mixin;

import net.minecraft.core.block.Block;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.util.helper.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(value = EntityLiving.class, remap = false)
final class EntityLivingMixin {
    @Inject(method = "canClimb", at = @At("HEAD"), cancellable = true)
    public void increaseLadderCoverage(CallbackInfoReturnable<Boolean> cir) {
        EntityLiving self = ((EntityLiving) ((Object) this));

        int x = MathHelper.floor_double(self.x);
        int y = MathHelper.floor_double(self.bb.minY);
        int z = MathHelper.floor_double(self.z);

        cir.setReturnValue(self.world.getBlockId(x, y, z) == Block.ladderOak.id ||
            self.world.getBlockId(x, y + 1, z) == Block.ladderOak.id);
    }
}
