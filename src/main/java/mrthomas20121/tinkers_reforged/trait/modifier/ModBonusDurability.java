package mrthomas20121.tinkers_reforged.trait.modifier;

import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.tools.modifiers.ToolModifier;

public class ModBonusDurability extends ToolModifier {

    private int durability = 500;

    public ModBonusDurability(String name, int color)
    {
        super(name, color);
    }
    public ModBonusDurability(String name, int color, int durability)
    {
        this(name, color);
        this.durability = durability;
    }

    @Override
    public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
        ToolNBT data = TagUtil.getToolStats(rootCompound);
        data.durability += this.durability;

        if(data.harvestLevel < HarvestLevels.OBSIDIAN) {
            data.harvestLevel++;
        }

        data.attack += 1f;
        data.speed += 0.5f;

        TagUtil.setToolTag(rootCompound, data.get());
    }
}
