package shadows.how2mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import shadows.how2mod.How2Mod;
import shadows.how2mod.init.ModRegistry;

public class BlockTest extends Block {

	public BlockTest(String name) {
		super(Material.ROCK);
		setRegistryName(name);
		setUnlocalizedName(How2Mod.MODID + "." + name);
		setCreativeTab(CreativeTabs.MISC);
		ModRegistry.BLOCKS.add(this);
		ModRegistry.ITEMS.add(new ItemBlock(this).setRegistryName(getRegistryName()));
	}

}
