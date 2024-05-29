/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.crashma.mixin;

import moriyashiine.crashma.common.DumbassException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin {
	@Unique
	private static final List<ServerWorld> WORLDS = new ArrayList<>();

	@Shadow
	public abstract Iterable<ServerWorld> getWorlds();

	@Inject(method = "tick", at = @At("TAIL"))
	private void crashma(CallbackInfo ci) {
		if (WORLDS.isEmpty()) {
			getWorlds().forEach(WORLDS::add);
		}
		DumbassException.crashma(WORLDS.get(0));
	}
}
