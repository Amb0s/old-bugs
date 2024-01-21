package turniplabs.oldbugs;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OldBugs implements ModInitializer {
    public static final String MOD_ID = "oldbugs";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Old Bugs initialized");
    }
}
