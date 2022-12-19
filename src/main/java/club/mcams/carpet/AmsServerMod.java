package club.mcams.carpet;

import club.mcams.carpet.util.AutoMixinAuditExecutor;
import net.fabricmc.api.ModInitializer;

public class AmsServerMod implements ModInitializer {
    @Override
    public void onInitialize() {
        AmsServer.loadExtension();
        AutoMixinAuditExecutor.run();
    }
}
