package club.mcams.carpet.mixin.rule.blockChunkLoader;

import club.mcams.carpet.AmsServerSettings;
import club.mcams.carpet.function.BlockChunkLoader;

import net.minecraft.block.*;
import net.minecraft.world.World;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Direction;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PistonBlock.class)
public abstract class PistonBlockMixin {
    @Inject(method = "onBlockAction", at = @At("HEAD"))
    private void load(BlockState state, World world, BlockPos pos, int type, int data, CallbackInfoReturnable info) {
        if(world instanceof ServerWorld && AmsServerSettings.pistonBlockChunkLoader) {
            Direction direction = state.get(FacingBlock.FACING);
            BlockPos nbp = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
            Block block = world.getBlockState(nbp).getBlock();
            if (block.getDropTableId().hashCode() == BlockChunkLoader.BoneBlockHash && AmsServerSettings.pistonBlockChunkLoader) {
                int x = pos.getX() + direction.getOffsetX();
                int z = pos.getZ() + direction.getOffsetZ();
                ChunkPos cp = new ChunkPos(x >> 4, z >> 4);
                ((ServerWorld) world).getChunkManager().addTicket(BlockChunkLoader.BLOCK_LOADER, cp, 3, cp);
            }
        }
    }
}