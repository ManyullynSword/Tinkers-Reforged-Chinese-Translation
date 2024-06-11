package mrthomas20121.tinkers_reforged.effect;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.common.ForgeMod;
import slimeknights.tconstruct.tools.modifiers.effect.NoMilkEffect;

public class EffectTicking extends NoMilkEffect {

    public EffectTicking() {
        super(MobEffectCategory.HARMFUL, 0xC53439, true);
    }

    @Override
    public boolean isDurationEffectTick(int tick, int level) {
        return tick > 0 && tick % 20 == 0;
    }
}