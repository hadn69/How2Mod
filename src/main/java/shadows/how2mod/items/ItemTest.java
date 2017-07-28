package shadows.how2mod.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import shadows.how2mod.How2Mod;
import shadows.how2mod.client.IHasModel;
import shadows.how2mod.init.ModRegistry;

public class ItemTest extends Item implements IHasModel {

	public ItemTest(String name) {
		setRegistryName(name);
		setUnlocalizedName(How2Mod.MODID + "." + name);
		setCreativeTab(ModRegistry.TAB);
		ModRegistry.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		if (world.isRemote)
			player.sendMessage(new TextComponentString("You have right clicked with a " + this.getRegistryName()));
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (world.isRemote)
			player.sendMessage(new TextComponentString("You have right clicked a " + world.getBlockState(pos).getBlock().getRegistryName() + " with a " + this.getRegistryName()));
		return EnumActionResult.SUCCESS;
	}

}
