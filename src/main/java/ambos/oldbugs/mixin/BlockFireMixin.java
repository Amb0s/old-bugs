package ambos.oldbugs.mixin;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockFire;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

import ambos.oldbugs.OldBugs;

@Mixin(value = BlockFire.class, remap = false)
final class BlockFireMixin {
    @ModifyConstant(method = "tickRate", constant = @Constant(intValue = 40))
    private int changeTickRate(int a) {
        if (OldBugs.OLD_FIRE_SPREAD) {
            return OldBugs.FIRE_TICK_RATE;
        } else {
            return a;
        }
    }

    @Redirect(method = "tryToCatchBlockOnFire", at = @At(value = "INVOKE",
        target = "Lnet/minecraft/core/world/World;setBlockAndMetadataWithNotify(IIIII)Z"))
    private boolean infiniteSpreading(World world, int x, int y, int z, int id, int meta) {
        if (OldBugs.OLD_FIRE_SPREAD) {
            world.setBlockAndMetadataWithNotify(x, y, z, Block.fire.id, 0);
        }

        return false;
    }

    @Redirect(method = "tryToCatchBlockOnFire", at = @At(value = "INVOKE",
        target = "Lnet/minecraft/core/block/BlockFire;setBurnResult(Lnet/minecraft/core/world/World;III)V"))
    private void cancelSetBurnResult(BlockFire instance, World world, int x, int y, int z) {
        if (!OldBugs.OLD_FIRE_SPREAD) {
            instance.setBurnResult(world, x, y, z);
        }
    }
}
