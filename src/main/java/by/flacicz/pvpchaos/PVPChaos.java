package by.flacicz.pvpchaos;

import by.flacicz.pvpchaos.common.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import static by.flacicz.pvpchaos.PVPChaos.MODID;
import static by.flacicz.pvpchaos.PVPChaos.VERSION;

@Mod(modid = MODID,
        version = VERSION
)
public class PVPChaos {
    public static final String MODID = "pvpchaos";
    public static final String VERSION = "1.0.0";

    @SidedProxy(
            clientSide = "by.flacicz.pvpchaos.client.ClientProxy",
            serverSide = "by.flacicz.pvpchaos.common.CommonProxy"
    )
    public static CommonProxy proxy;



    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
