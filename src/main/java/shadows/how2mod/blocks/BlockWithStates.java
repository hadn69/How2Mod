package shadows.how2mod.blocks;

import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import shadows.how2mod.init.ModRegistry;
import shadows.how2mod.items.ItemBlockTest;

public class BlockWithStates extends BlockTest{
	
	public static final PropertyInteger META = PropertyInteger.create("meta", 0, 7);

	public BlockWithStates(String name) {
		super(name, true);
		setDefaultState(this.blockState.getBaseState().withProperty(META, 0));
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
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
		for(int i = 0; i < 8; i++) list.add(new ItemStack(this, 1, i));
	}

}
