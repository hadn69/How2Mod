package shadows.how2mod.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import shadows.how2mod.How2Mod;
import shadows.how2mod.blocks.BlockTest;
import shadows.how2mod.blocks.BlockWithStates;
import shadows.how2mod.items.ItemMetaTest;
import shadows.how2mod.items.ItemTest;

public class ModRegistry {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final CreativeTabs TAB = new CreativeTabs(How2Mod.MODID) {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(META_TEST, 1, 16);
		}
		
	};

	public static final Item TEST = new ItemTest("test");
	public static final Block TEST_BLOCK = new BlockTest("test_block");
	public static final Item META_TEST = new ItemMetaTest("test_meta_item");
	public static final Block STATE_TEST = new BlockWithStates("test_state_block");

	@SubscribeEvent
	public void onBlockRegister(Register<Block> event) {
		event.getRegistry().registerAll(BLOCKS.toArray(new Block[0]));
	}

	@SubscribeEvent
	public void onItemRegister(Register<Item> event) {
		event.getRegistry().registerAll(ITEMS.toArray(new Item[0]));
	}

}
