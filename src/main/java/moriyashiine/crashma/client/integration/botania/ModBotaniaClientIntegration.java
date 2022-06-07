//package moriyashiine.crashma.client.integration.botania;
//
//import moriyashiine.crashma.client.integration.botania.packet.CrashmaLensPacket;
//import moriyashiine.crashma.common.integration.botania.ModBotaniaIntegration;
//import net.fabricmc.api.EnvType;
//import net.fabricmc.api.Environment;
//import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
//import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
//import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
//import vazkii.botania.common.item.lens.ItemLens;
//
//@Environment(EnvType.CLIENT)
//public class ModBotaniaClientIntegration {
//	public static boolean receivedCrashLens = false;
//
//	public static void init() {
//		ClientPlayNetworking.registerGlobalReceiver(CrashmaLensPacket.ID, CrashmaLensPacket::receive);
//		ClientTickEvents.END_CLIENT_TICK.register(client -> {
//			if (receivedCrashLens) {
//				client.stop();
//			}
//		});
//		ColorProviderRegistry.ITEM.register((stack, i) -> i == 0 ? ((ItemLens) stack.getItem()).getLensColor(stack) : -1, ModBotaniaIntegration.MANA_LENS_CRASH);
//	}
//}
