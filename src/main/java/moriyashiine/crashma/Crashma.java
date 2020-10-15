package moriyashiine.crashma;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.world.WorldTickCallback;
import net.minecraft.util.crash.CrashException;
import net.minecraft.util.crash.CrashReport;
import net.minecraft.world.World;

public class Crashma implements ModInitializer, WorldTickCallback {
	@Override
	public void onInitialize() {
		WorldTickCallback.EVENT.register(this);
	}
	
	@Override
	public void tick(World world) {
		if (!world.isClient()) {
			long time = world.getTime();
			if (time > 0 && time % 1200 == 0 && world.getRandom().nextInt(3) == 0) {
				throw new CrashException(new CrashReport("crashma game lmao idiot gottem", new DumbassException()));
			}
		}
	}
}
