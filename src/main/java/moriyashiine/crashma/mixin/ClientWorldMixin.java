/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.crashma.mixin;

import moriyashiine.crashma.common.DumbassException;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientWorld.class)
public class ClientWorldMixin {
	@Inject(method = "tick", at = @At("TAIL"))
	private void crashma(CallbackInfo ci) {
		DumbassException.crashma((ClientWorld) (Object) this);
	}
}
