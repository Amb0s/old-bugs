package ambos.oldbugs.mixin;

import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.util.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import ambos.oldbugs.OldBugs;

@Mixin(value = Entity.class, remap = false)
final class EntityMixin {
    @Inject(method = "checkAndHandleWater", at = @At("HEAD"), cancellable = true)
    private void onCheckAndHandleWater(CallbackInfoReturnable<Boolean> cir) {
        if (!OldBugs.SOUTH_WEST_RULE_LIQUIDS) {
            return;
        }

        Entity self = ((Entity) ((Object) this));
        AABB aabb = self.bb.expand(0.0, -0.4000000059604645, 0.0);
        boolean res = self.world.handleMaterialAcceleration(aabb, Material.water, self);
        cir.setReturnValue(res);
    }

    @Inject(method = "isInLava", at = @At("HEAD"), cancellable = true)
    private void lavaInject(CallbackInfoReturnable<Boolean> cir){
        if (!OldBugs.SOUTH_WEST_RULE_LIQUIDS) {
            return;
        }

        Entity self = ((Entity) ((Object) this));
        AABB aabb = self.bb.expand(0.0, -0.4000000059604645, 0.0);
        boolean res = self.world.isMaterialInBB(aabb, Material.lava);
        cir.setReturnValue(res);
    }
}
