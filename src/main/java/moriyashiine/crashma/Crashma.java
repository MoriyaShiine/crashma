package moriyashiine.crashma;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Crashma.MODID, name = Crashma.NAME, version = Crashma.VERSION)
public class Crashma {
    static final String MODID = "crashma", NAME = "Crashma", VERSION = "69";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    //    @SubscribeEvent
    //    public void lol(TickEvent.WorldTickEvent event)
    //    {
    //        if (!event.world.isRemote)
    //        {
    //            long time = world.getTotalWorldTime();
    //            if (time > 0 && time % (60*20) == 0 && event.world.rand.nextInt(3) == 0) throw new CrashReport();
    //        }
    //    }
}
