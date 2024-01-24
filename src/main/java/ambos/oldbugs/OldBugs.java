package ambos.oldbugs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import turniplabs.halplibe.util.TomlConfigHandler;
import turniplabs.halplibe.util.toml.Toml;

public class OldBugs implements ModInitializer {
    public static final String MOD_ID = "oldbugs";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final TomlConfigHandler CONFIG;
    public static final boolean OLD_FIRE_SPREAD;
    public static final boolean BOAT_ELEVATORS;
    public static final boolean LADDERS_GAPS;
    public static final boolean MINECART_BOOSTERS;
    public static final boolean SOUTH_WEST_RULE_LIQUIDS;
    public static final int FIRE_TICK_RATE;
    static {
        Toml toml = new Toml();
        toml.addCategory("Bugs");
        toml.addEntry("Bugs.old_fire_spread", "Restores fast and large fire spread", true);
        toml.addEntry("Bugs.boat_elevators", "Restores boat elevators", true);
        toml.addEntry("Bugs.ladders_gaps", "Restores ladders gaps", true);
        toml.addEntry("Bugs.minecart_boosters", "Restores minecart boosters", true);
        toml.addEntry("Bugs.south_west_rule_liquids", "Restores south-west rule for water and lava", true);
        toml.addCategory("Settings");
        toml.addEntry("Settings.fire_tick_rate", "Sets fire tick rate (requires 'old_fire_spread = true')", 10);

        CONFIG = new TomlConfigHandler(MOD_ID, toml);
        OLD_FIRE_SPREAD = CONFIG.getBoolean("Bugs.old_fire_spread");
        BOAT_ELEVATORS = CONFIG.getBoolean("Bugs.boat_elevators");
        LADDERS_GAPS = CONFIG.getBoolean("Bugs.ladders_gaps");
        MINECART_BOOSTERS = CONFIG.getBoolean("Bugs.minecart_boosters");
        SOUTH_WEST_RULE_LIQUIDS = CONFIG.getBoolean("Bugs.south_west_rule_liquids");
        FIRE_TICK_RATE = CONFIG.getInt("Settings.fire_tick_rate");
    }

    @Override
    public void onInitialize() {
        LOGGER.info("Old Bugs initialized");
    }
}
