package mrthomas20121.tinkers_reforged.util.modifier_hooks;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public interface DeathModifierHook {

    DeathModifierHook DEFAULT = (tool, attacker, source, target) -> {};

    /**
     * This method only triggers when the attacker is holding a tool and that they are a player/entity attacking
     * @param tool tool the player is holding
     * @param attacker the entity attacking(the player or another entity)
     * @param source the damage source
     * @param target the dying entity
     */
    void onDeath(IToolStackView tool, LivingEntity attacker, DamageSource source, LivingEntity target);
}
