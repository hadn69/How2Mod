package shadows.how2mod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
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
}
