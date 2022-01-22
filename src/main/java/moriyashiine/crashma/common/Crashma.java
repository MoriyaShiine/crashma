package moriyashiine.crashma.common;

import moriyashiine.crashma.common.integration.botania.ModBotaniaIntegration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.world.WorldTickCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.CrashReport;
import net.minecraft.ReportedException;

public class Crashma implements ModInitializer {
	public static final String MOD_ID = "crashma";

	@Override
	public void onInitialize() {
		WorldTickCallback.EVENT.register(level -> {
			if (!level.isClientSide()) {
				long time = level.getGameTime();
				if (time > 0 && time % 1200 == 0 && level.getRandom().nextInt(3) == 0) {
					crashma();
				}
			}
		});
		if (FabricLoader.getInstance().isModLoaded("botania")) {
			ModBotaniaIntegration.init();
		}
	}

	public static void crashma() {
		throw new ReportedException(new CrashReport("crashma game lmao idiot gottem", new DumbassException()));
	}
}
