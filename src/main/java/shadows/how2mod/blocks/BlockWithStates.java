package shadows.how2mod.blocks;

import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;

public class BlockWithStates extends BlockTest{
	
	public static final PropertyInteger META = PropertyInteger.create("meta", 0, 7);

	public BlockWithStates(String name) {
		super(name);
		setDefaultState(this.blockState.getBaseState().withProperty(META, 0));
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

}
