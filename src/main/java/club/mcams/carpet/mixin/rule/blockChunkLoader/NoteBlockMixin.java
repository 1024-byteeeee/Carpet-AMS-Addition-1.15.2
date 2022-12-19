package club.mcams.carpet.mixin.rule.blockChunkLoader;

import club.mcams.carpet.AmsServerSettings;
import club.mcams.carpet.function.BlockChunkLoader;

import net.minecraft.block.NoteBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NoteBlock.class)
public abstract class NoteBlockMixin {
    @Inject(at = @At("HEAD"), method = "playNote")
    private void playNoteMixin(
            World world, BlockPos pos, CallbackInfo info) {
        if (AmsServerSettings.noteBlockChunkLoader && !world.isClient) {
            ChunkPos chunkPos = new ChunkPos(pos);
            ((ServerWorld) world).getChunkManager().addTicket(BlockChunkLoader.BLOCK_LOADER, chunkPos, 3, chunkPos);
        }
    }
}
