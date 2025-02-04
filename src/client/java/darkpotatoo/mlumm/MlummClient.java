package darkpotatoo.mlumm;

import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

import net.fabricmc.api.ClientModInitializer;

public class MlummClient implements ClientModInitializer {

	public static final String MODID = "mlumm";
	private static final Logger LOGGER = LogUtils.getLogger();

	public static int combatTicks = 0;
	public static int crateTicks = 0;


	@Override
	public void onInitializeClient() {
		LOGGER.info("mlum mod loading...");
	}
}