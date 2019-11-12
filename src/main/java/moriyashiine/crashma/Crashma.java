package moriyashiine.crashma;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("crashma")
public class Crashma {
	public Crashma() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
	}
	
	private void setup(final FMLCommonSetupEvent event) {
		MinecraftForge.EVENT_BUS.register(new Handler());
	}
	
	private static class Handler {
		@SuppressWarnings("ConstantConditions")
		@SubscribeEvent
		public void worldTick(TickEvent.WorldTickEvent event) {
			World world = event.world;
			if (!world.isRemote)
			{
				long time = world.getGameTime();
				if (time > 0 && time % 1200 == 0 && world.rand.nextInt(3) == 0) ((Entity) null).isBurning();
			}
		}
	}
}
