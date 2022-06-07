package moriyashiine.crashma.common;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.CrashReport;
import net.minecraft.ReportedException;
import net.minecraft.world.level.Level;

public class Crashma implements ModInitializer {
	public static final String MOD_ID = "crashma";

	@Override
	public void onInitialize() {
		ServerTickEvents.END_SERVER_TICK.register(server -> {
			Level overworld = server.overworld();
			long time = overworld.getGameTime();
			if (time > 0 && time % 1200 == 0 && overworld.getRandom().nextInt(3) == 0) {
				crashma();
			}
		});
//		if (FabricLoader.getInstance().isModLoaded("botania")) {
//			ModBotaniaIntegration.init();
//		}
	}

	public static void crashma() {
		throw new ReportedException(new CrashReport("crashma game lmao idiot gottem", new DumbassException()));
	}
}
