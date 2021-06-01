package mrthomas20121.tinkers_reforged.trait;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitRose extends AbstractTrait {

    public TraitRose() {
        super("ref_rose", 0xffffff);
    }

    @Override
    public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase player, boolean wasEffective) {
        String registryName = state.getBlock().getRegistryName().toString();
        if(contains(registryName, "grass")) {
            if(!world.isRemote && wasEffective) {
                int meta = world.rand.nextInt(15);
                float chance = world.rand.nextFloat();
                if(chance > 0.5f) {
                    world.spawnEntity( new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.DYE, 1, meta)));
                }
            }
        }
    }

    private boolean contains(String registryName, String... elements) {
        boolean result = false;
        for(String elem : elements) {
            result = registryName.contains(elem);
            if(result) break;
        }
        return result;
    }
}