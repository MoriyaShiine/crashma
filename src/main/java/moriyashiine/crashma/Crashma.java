package moriyashiine.crashma;

import net.minecraft.crash.CrashReport;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod(modid = Crashma.MODID, name = Crashma.NAME, version = Crashma.VERSION)
public class Crashma {
    static final String MODID = "crashma", NAME = "Crashma", VERSION = "69";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    @SubscribeEvent
    public void lol(TickEvent.WorldTickEvent event)
    {
        if (!event.world.isRemote)
        {
            long time = event.world.getTotalWorldTime();
            if (time > 0 && time % (60*20) == 0 && event.world.rand.nextInt(3) == 0) FMLCommonHandler.instance().raiseException(new Throwable(), "gottem", true);
        }
    }
}
