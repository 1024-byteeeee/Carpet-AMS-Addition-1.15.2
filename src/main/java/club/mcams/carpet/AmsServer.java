
package club.mcams.carpet;

import carpet.CarpetExtension;
import carpet.CarpetServer;

import club.mcams.carpet.function.ChunkLoading;
import club.mcams.carpet.util.AmsCarpetTranslations;

import com.mojang.brigadier.CommandDispatcher;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class AmsServer implements CarpetExtension {

    public static final String MOD_NAME = "Carpet AMS Addition";
    public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);
    public static MinecraftServer minecraftServer;

    @Override

    public void onPlayerLoggedOut(ServerPlayerEntity player) {
        ChunkLoading.onPlayerDisconnect(player);
    }

    public static void loadExtension() {
        CarpetServer.manageExtension(new AmsServer());
    }

    @Override
    public void onGameStarted() {
        // let's /carpet handle our few simple settings
        CarpetServer.settingsManager.parseSettingsClass(AmsServerSettings.class);
        LOGGER.info(MOD_NAME + " " + "载入成功");
        LOGGER.info("开源链接：https://github.com/Minecraft-AMS/Carpet-AMS-Addition");
        LOGGER.info("BUG反馈：https://github.com/Minecraft-AMS/Carpet-AMS-Addition/issues");
    }

    @Override
    public void onServerLoaded(MinecraftServer server) {
        minecraftServer = server;
    }

    @Override
    public void onTick(MinecraftServer server) {

    }

    @Override
    public void registerCommands(CommandDispatcher<ServerCommandSource> dispatcher) {

    }

    @Override
    public void onPlayerLoggedIn(ServerPlayerEntity player) {
        ChunkLoading.onPlayerConnect(player);
    }

    @Override
    public void registerLoggers() {

    }

    @Override
    public Map<String, String> canHasTranslations(String lang) {
        return AmsCarpetTranslations.getTranslationFromResourcePath(lang);
    }
}


