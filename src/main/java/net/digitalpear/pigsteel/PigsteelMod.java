package net.digitalpear.pigsteel;


import net.digitalpear.pigsteel.register.*;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@SuppressWarnings({"unused"})
public class PigsteelMod implements ModInitializer {
	public static final String MOD_ID = "pigsteel";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		PigsteelBlocks.init();
		PigsteelItems.init();
		PigsteelConfiguredFeatures.init();
		PigsteelPlacedFeatures.init();
		PigsteelData.init();


		LOGGER.info("Let there be pigsteel!");
	}
}
