package moriyashiine.crashma.client.integration.botania.packet;

import io.netty.buffer.Unpooled;
import moriyashiine.crashma.client.integration.botania.ModBotaniaClientIntegration;
import moriyashiine.crashma.common.Crashma;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public class CrashmaLensPacket {
	public static final ResourceLocation ID = new ResourceLocation(Crashma.MOD_ID, "crashma_lens_packet");

	public static void send(ServerPlayer player) {
		FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
		ServerPlayNetworking.send(player, ID, buf);
	}

	public static void receive(Minecraft client, ClientPacketListener handler, FriendlyByteBuf buf, PacketSender responseSender) {
		client.execute(() -> {
			if (!ModBotaniaClientIntegration.receivedCrashLens) {
				ModBotaniaClientIntegration.receivedCrashLens = true;
				Crashma.crashma();
			}
		});
	}
}
