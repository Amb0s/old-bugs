package ambos.oldbugs;

import net.fabricmc.api.ModInitializer;
import turniplabs.halplibe.util.TomlConfigHandler;
import turniplabs.halplibe.util.toml.Toml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OldBugs implements ModInitializer {
    public static final String MOD_ID = "oldbugs";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final TomlConfigHandler TOML_CONFIG_HANDLER;
    public static final boolean OLD_FIRE_SPREAD;
    public static final boolean BOAT_WATER_LIFT;
    public static final boolean LADDER_GAP;
    public static final boolean MINECART_BOOSTER;
    public static final boolean SOUTH_EAST_RULE_LIQUIDS;
    public static final int FIRE_TICK_RATE;
    static {
        Toml configToml = new Toml();
        configToml.addCategory("Bugs");
        configToml.addEntry("old_fire_spread", true);
        configToml.addEntry("boat_water_lift", true);
        configToml.addEntry("ladder_gap", true);
        configToml.addEntry("minecart_booster", true);
        configToml.addEntry("south_east_rule_liquids", true);
        configToml.addCategory("Settings");
        configToml.addEntry("fire_tick_rate", 10);

        TOML_CONFIG_HANDLER = new TomlConfigHandler(MOD_ID, configToml);
        OLD_FIRE_SPREAD = TOML_CONFIG_HANDLER.getBoolean("Bugs.old_fire_spread");
        BOAT_WATER_LIFT = TOML_CONFIG_HANDLER.getBoolean("Bugs.boat_water_lift");
        LADDER_GAP = TOML_CONFIG_HANDLER.getBoolean("Bugs.ladder_gap");
        MINECART_BOOSTER = TOML_CONFIG_HANDLER.getBoolean("Bugs.minecart_booster");
        SOUTH_EAST_RULE_LIQUIDS = TOML_CONFIG_HANDLER.getBoolean("Bugs.south_east_rule_liquids");
        FIRE_TICK_RATE = TOML_CONFIG_HANDLER.getInt("Settings.fire_tick_rate");
    }

    @Override
    public void onInitialize() {
        LOGGER.info("Old Bugs initialized");
    }
}
