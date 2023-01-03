package club.mcams.carpet;

import carpet.settings.Rule;
import static carpet.settings.RuleCategory.*;

/**
 * Here is your example Settings class you can plug to use carpetmod /carpet settings command
 */

@SuppressWarnings({"CanBeFinal"})
public class AmsServerSettings {
    public static final String AMS = "AMS";

    @Rule(
            desc = "Load nearby 3x3 chunks for 15 seconds when a note block is triggered",
            category = {AMS, FEATURE}
    )
    public static boolean noteBlockChunkLoader = false;
    @Rule(
            desc = "Load nearby 3x3 chunks for 15 seconds when a bell is triggered",
            category = {AMS, FEATURE}
    )
    public static boolean bellBlockChunkLoader = false;
    @Rule(
            desc = "Load nearby 3x3 chunks for 15 seconds when a piston with a bone block at its top extends",
            category = {AMS, FEATURE}
    )
    public static boolean pistonBlockChunkLoader = false;

    @Rule(
            desc = "Change the hardness of obsdian to deepslate",
            category = {AMS, FEATURE, SURVIVAL}
    )
    public  static boolean breakableObsdian = false;

    @Rule(
            desc = "TNT can destroy any block not protected by fluid (BlastResistance:0)",
            category = {AMS, FEATURE, SURVIVAL, TNT}
    )
    public  static boolean tntDestroysEverything = false;

}
