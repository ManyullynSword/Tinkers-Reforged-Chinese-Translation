package mrthomas20121.tinkers_reforged.modifier;

import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeDamageModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class GiganticModifier extends Modifier implements MeleeDamageModifierHook {

    public GiganticModifier() {
        super();
    }

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this, ModifierHooks.MELEE_DAMAGE);
    }

    private float calcBonusDamage(ModifierEntry modifier, float targetMaxHealth, float playerHealth) {
        if(targetMaxHealth > playerHealth) {
            return targetMaxHealth-playerHealth*(0.02f*modifier.getLevel());
        }
        return 0;
    }

    @Override
    public float getMeleeDamage(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float baseDamage, float damage) {
        if(context.getLivingTarget() != null) {
            return damage+calcBonusDamage(modifier, context.getLivingTarget().getMaxHealth(), context.getAttacker().getMaxHealth());
        }
        return damage;
    }
}
