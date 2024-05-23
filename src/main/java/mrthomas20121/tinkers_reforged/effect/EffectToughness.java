package mrthomas20121.tinkers_reforged.effect;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.common.ForgeMod;
import slimeknights.tconstruct.tools.modifiers.effect.NoMilkEffect;

public class EffectToughness extends NoMilkEffect {

    public EffectToughness() {
        super(MobEffectCategory.HARMFUL, 0xC53439, true);

        addAttributeModifier(Attributes.ARMOR_TOUGHNESS, "8322ac4f-ddef-4bdb-9978-b2f8ff4b11f8", 2, AttributeModifier.Operation.MULTIPLY_TOTAL);
    }

    @Override
    public boolean isDurationEffectTick(int tick, int level) {
        return tick > 0 && tick % 20 == 0;
    }
}