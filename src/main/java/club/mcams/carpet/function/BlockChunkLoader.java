
package club.mcams.carpet.function;

import net.minecraft.server.world.ChunkTicketType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ChunkPos;

import java.util.Comparator;


public class BlockChunkLoader {
    public static final ChunkTicketType<ChunkPos>
            BLOCK_LOADER = ChunkTicketType.create
            (
                    "block_loader", Comparator.comparingLong(ChunkPos::toLong),
                    300
            );
    public static final int BoneBlockHash = new Identifier("minecraft", "blocks/bone_block").hashCode();
}


