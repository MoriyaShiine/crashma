package moriyashiine.crashma.client;

import moriyashiine.crashma.client.integration.botania.ModBotaniaClientIntegration;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;

@Environment(EnvType.CLIENT)
public class CrashmaClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		if (FabricLoader.getInstance().isModLoaded("botania")) {
			ModBotaniaClientIntegration.init();
		}
	}
}
