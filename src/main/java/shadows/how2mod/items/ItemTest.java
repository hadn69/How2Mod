package shadows.how2mod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import shadows.how2mod.How2Mod;
import shadows.how2mod.init.ModRegistry;

public class ItemTest extends Item {
	
	public ItemTest(String name) {
		setRegistryName(name);
		setUnlocalizedName(How2Mod.MODID + "." + name);
		setCreativeTab(CreativeTabs.MISC);
		ModRegistry.ITEMS.add(this);
	}

}
