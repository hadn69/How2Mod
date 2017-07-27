package shadows.how2mod.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import shadows.how2mod.How2Mod;
import shadows.how2mod.client.IHasModel;
import shadows.how2mod.init.ModRegistry;

public class ItemTest extends Item implements IHasModel{
	
	public ItemTest(String name) {
		setRegistryName(name);
		setUnlocalizedName(How2Mod.MODID + "." + name);
		setCreativeTab(CreativeTabs.MISC);
		ModRegistry.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

}
