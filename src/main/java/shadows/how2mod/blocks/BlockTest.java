package shadows.how2mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import shadows.how2mod.How2Mod;
import shadows.how2mod.client.IHasModel;
import shadows.how2mod.init.ModRegistry;

public class BlockTest extends Block implements IHasModel {

	public BlockTest(String name, boolean hasCustomItemBlock) {
		super(Material.ROCK);
		setRegistryName(name);
		setUnlocalizedName(How2Mod.MODID + "." + name);
		setCreativeTab(ModRegistry.TAB);
		ModRegistry.BLOCKS.add(this);
		if(!hasCustomItemBlock) ModRegistry.ITEMS.add(new ItemBlock(this).setRegistryName(getRegistryName()));
	}
	
	public BlockTest(String name) {
		this(name, false);
	}

	@Override
	public void registerModels() {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

}
