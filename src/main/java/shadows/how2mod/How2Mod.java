package shadows.how2mod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.SidedProxy;
import shadows.how2mod.proxy.CommonProxy;

@Mod(modid = How2Mod.MODID, name = How2Mod.NAME, version = How2Mod.VERSION)
public class How2Mod {

	public static final String MODID = "how2mod";
	public static final String NAME = "How 2 Mod";
	public static final String VERSION = "1.0.0";

	@Instance
	public static How2Mod INSTANCE;

	@SidedProxy(clientSide = "shadows.how2mod.proxy.ClientProxy", serverSide = "shadows.how2mod.proxy.CommonProxy")
	public static CommonProxy PROXY;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		PROXY.preInit(e);
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		MinecraftForge.EVENT_BUS.register(this);
		PROXY.init(e);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		PROXY.postInit(e);
	}
}
