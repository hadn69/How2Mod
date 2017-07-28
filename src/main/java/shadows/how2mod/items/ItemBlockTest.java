package shadows.how2mod.items;

import net.minecraft.item.ItemBlock;
import shadows.how2mod.blocks.BlockWithStates;

public class ItemBlockTest extends ItemBlock {

	public ItemBlockTest(BlockWithStates block) {
		super(block);
		setRegistryName(block.getRegistryName());
		setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int damage) {
		return damage;
	}

}
