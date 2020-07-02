package moriyashiine.crashma;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.world.WorldTickCallback;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class Crashma implements ModInitializer, WorldTickCallback {
	@Override
	public void onInitialize() {
		WorldTickCallback.EVENT.register(this);
	}
	
	@SuppressWarnings("ConstantConditions")
	@Override
	public void tick(World world) {
		if (!world.isClient)
		{
			long time = world.getTime();
			if (time > 0 && time % 1200 == 0 && world.random.nextInt(3) == 0) ((Entity) null).isOnFire();
		}
	}
}