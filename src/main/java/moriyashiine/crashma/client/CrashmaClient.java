package moriyashiine.crashma.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class CrashmaClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
//		if (FabricLoader.getInstance().isModLoaded("botania")) {
//			ModBotaniaClientIntegration.init();
//		}
	}
}
