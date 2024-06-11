package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeDamageModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

// Deal more damage to target from the back
public class BackStabModifier extends Modifier implements MeleeDamageModifierHook {

    public BackStabModifier() {
        super();
    }

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);

        hookBuilder.addHook(this, ModifierHooks.MELEE_DAMAGE);
    }

    @Override
    public float getMeleeDamage(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float baseDamage, float damage) {
        float bonus = 0;
        if(context.getLivingTarget() != null) {
            LivingEntity target = context.getLivingTarget();

            if(!context.getAttacker().getLookAngle().equals(target.getLookAngle())) {
                bonus = 1.1f*modifier.getLevel();
            }
        }
        return damage+bonus;
    }
}
