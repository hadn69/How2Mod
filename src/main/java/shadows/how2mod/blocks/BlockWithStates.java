package shadows.how2mod.blocks;

import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import shadows.how2mod.init.ModRegistry;
import shadows.how2mod.items.ItemBlockTest;

public class BlockWithStates extends BlockTest{
	
	public static final PropertyInteger META = PropertyInteger.create("meta", 0, 7);

	public BlockWithStates(String name) {
		super(name, true);
		setDefaultState(this.blockState.getBaseState().withProperty(META, 0));
		setHardness(2.0F);
		setResistance(2.0F);
		ModRegistry.ITEMS.add(new ItemBlockTest(this));
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(META);
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(META, meta);
	}
	
	@Override
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, META);
	}
	
	@Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        return getDefaultState().withProperty(META, meta);
    }
	
	@Override
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
		for(int i = 0; i < 8; i++) list.add(new ItemStack(this, 1, i));
	}
	
	@Override
    public int damageDropped(IBlockState state) {
        return state.getValue(META);
    }
	
	@Override
	public void registerModels() {
		for(int i = 0; i < 8; i++) ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), i, new ModelResourceLocation(getRegistryName(), "meta=" + i));
	}

}
