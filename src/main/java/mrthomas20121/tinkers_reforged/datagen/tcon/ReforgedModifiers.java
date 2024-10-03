package mrthomas20121.tinkers_reforged.datagen.tcon;

import mrthomas20121.tinkers_reforged.api.ReforgedModData;
import mrthomas20121.tinkers_reforged.api.material.EnumModifier;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedPotions;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;
import slimeknights.mantle.data.predicate.entity.LivingEntityPredicate;
import slimeknights.mantle.data.predicate.entity.MobTypePredicate;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.data.tinkering.AbstractModifierProvider;
import slimeknights.tconstruct.library.json.RandomLevelingValue;
import slimeknights.tconstruct.library.json.variable.tool.ToolVariable;
import slimeknights.tconstruct.library.modifiers.impl.BasicModifier;
import slimeknights.tconstruct.library.modifiers.modules.armor.ProtectionModule;
import slimeknights.tconstruct.library.modifiers.modules.behavior.AttributeModule;
import slimeknights.tconstruct.library.modifiers.modules.build.StatBoostModule;
import slimeknights.tconstruct.library.modifiers.modules.combat.ConditionalMeleeDamageModule;
import slimeknights.tconstruct.library.modifiers.modules.combat.MobEffectModule;
import slimeknights.tconstruct.library.modifiers.modules.mining.ConditionalMiningSpeedModule;
import slimeknights.tconstruct.library.modifiers.modules.technical.ArmorStatModule;
import slimeknights.tconstruct.library.tools.capability.TinkerDataKeys;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class ReforgedModifiers extends AbstractModifierProvider implements IConditionBuilder {

    public ReforgedModifiers(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void addModifiers() {
        buildModifier(EnumModifier.RAID_PROTECTION.id())
                .addModule(ProtectionModule.builder().attacker(ReforgedModData.ILLAGER).eachLevel(1.25f));
        buildModifier(EnumModifier.CHILD_PROTECTION.id())
                .addModule(ProtectionModule.builder().attacker(ReforgedModData.BABY).eachLevel(1.25f));
        buildModifier(EnumModifier.ARMORED_PROTECTION.id())
                .addModule(ProtectionModule.builder().attacker(ReforgedModData.IS_WEARING_ARMOR).eachLevel(1f));
        buildModifier(EnumModifier.WEAPON_PROTECTION.id())
                .addModule(ProtectionModule.builder().attacker(ReforgedModData.IS_HOLDING_ITEM).eachLevel(1.25f));
        buildModifier(EnumModifier.AQUA_PROTECTION.id())
                .addModule(ProtectionModule.builder().attacker(LivingEntityPredicate.UNDERWATER).eachLevel(1.25f));
        buildModifier(EnumModifier.INDIRECT_PROTECTION.id())
                .addModule(ProtectionModule.builder().source(ReforgedModData.INDIRECT).eachLevel(0.8f));
        buildModifier(EnumModifier.GIANT_PROTECTION.id())
                .addModule(ProtectionModule.builder().attacker(ReforgedModData.BOSSES).eachLevel(1.25f));
        buildModifier(EnumModifier.MYTHOLOGICAL_RESISTANCE.id())
                .addModule(ProtectionModule.builder().attacker(ReforgedModData.BOSSES).eachLevel(1f));
        buildModifier(EnumModifier.ROCK_SOLID.id())
                .addModule(StatBoostModule.multiplyBase(ToolStats.DURABILITY).eachLevel(1.3f));
        buildModifier(EnumModifier.ADAPTABILITY.id()).addModule(
                ConditionalMiningSpeedModule.builder()
                        .formula()
                        .customVariable("current_durability", ToolVariable.CURRENT_DURABILITY) // get the current durability
                        .constant(0.05f).multiply() // multiply the result by 0.01
                        .build());

        buildModifier(EnumModifier.AMPLIFIER.id()).addModules(
                AttributeModule.builder(ForgeMod.ATTACK_RANGE.get(), AttributeModifier.Operation.ADDITION).uniqueFrom(new ResourceLocation("tinkers_reforged:amplifier_range")).eachLevel(0.1f),
                AttributeModule.builder(Attributes.MOVEMENT_SPEED, AttributeModifier.Operation.ADDITION).uniqueFrom(new ResourceLocation("tinkers_reforged:amplifier_speed")).eachLevel(0.1f)
        );

        buildModifier(EnumModifier.AMPLITUDE.id()).addModules(
                AttributeModule.builder(ForgeMod.ATTACK_RANGE.get(), AttributeModifier.Operation.ADDITION).uniqueFrom(EnumModifier.AMPLITUDE.id()).eachLevel(0.1f),
                StatBoostModule.multiplyBase(ToolStats.DURABILITY).eachLevel(1.1f)
        );

        buildModifier(EnumModifier.DEFENSIVE.id()).addModules(
                AttributeModule.builder(Attributes.MAX_HEALTH, AttributeModifier.Operation.ADDITION).uniqueFrom(EnumModifier.DEFENSIVE.id()).eachLevel(1f)
        );

        buildModifier(EnumModifier.HEALTH_CHARM.id()).addModules(
                AttributeModule.builder(Attributes.MAX_HEALTH, AttributeModifier.Operation.ADDITION).uniqueFrom(EnumModifier.HEALTH_CHARM.id()).eachLevel(1f)
        );

        buildModifier(EnumModifier.DRACONIC.id())
                .addModules(
                        ArmorStatModule.builder(TinkerDataKeys.EXPERIENCE).eachLevel(1.1f));

        buildModifier(EnumModifier.MALLEABLE.id())
                .addModules(
                        ArmorStatModule.builder(TinkerDataKeys.PROTECTION_CAP).allowBroken().heldTag(TinkerTags.Items.HELD_ARMOR).eachLevel(1.1f));

        buildModifier(EnumModifier.SIZZLING.id()).addModule(ConditionalMeleeDamageModule.builder()
                .target(LivingEntityPredicate.FIRE_IMMUNE)
                .eachLevel(1.5f));

        // deal more damage to illager, players and villagers
        buildModifier(EnumModifier.VORACIOUS.id()).addModule(
                ConditionalMeleeDamageModule.builder()
                        .attacker(
                                LivingEntityPredicate.or(
                                        new MobTypePredicate(MobType.ILLAGER),
                                        LivingEntityPredicate.set(EntityType.PLAYER),
                                        LivingEntityPredicate.tag(TinkerTags.EntityTypes.VILLAGERS)))
                        .eachLevel(1));

        buildModifier(EnumModifier.FROSTY.id())
                .addModules(
                        MobEffectModule.builder(TinkersReforgedPotions.FROZEN.get()).level(RandomLevelingValue.perLevel(0, 0.5f)).time(RandomLevelingValue.random(20, 10)).build());

        buildModifier(EnumModifier.GLINT.id())
                .addModules(
                        MobEffectModule.builder(MobEffects.GLOWING).level(RandomLevelingValue.perLevel(0, 0.5f)).time(RandomLevelingValue.random(20, 10)).build(),
                        MobEffectModule.builder(MobEffects.WITHER).level(RandomLevelingValue.perLevel(0, 0.5f)).time(RandomLevelingValue.random(20, 10)).build()
                );

        buildModifier(EnumModifier.TICKING.id())
                .addModules(
                        MobEffectModule.builder(TinkersReforgedPotions.TICKING.get()).level(RandomLevelingValue.perLevel(0, 1)).time(RandomLevelingValue.flat(3)).build());

        // tools mod
        buildModifier(EnumModifier.LONGSWORD_MOD.id()).addModules(
                AttributeModule.builder(ForgeMod.ATTACK_RANGE.get(), AttributeModifier.Operation.ADDITION).uniqueFrom(new ResourceLocation("tinkers_reforged:attack_range_mod")).flat(1.5f),
                AttributeModule.builder(ForgeMod.REACH_DISTANCE.get(), AttributeModifier.Operation.ADDITION).uniqueFrom(new ResourceLocation("tinkers_reforged:reach_distance_mod")).flat(1.5f),
                AttributeModule.builder(Attributes.ATTACK_DAMAGE, AttributeModifier.Operation.ADDITION).uniqueFrom(new ResourceLocation("tinkers_reforged:attack_damage_mod")).flat(0.5f)
        ).tooltipDisplay(BasicModifier.TooltipDisplay.NEVER);

        buildModifier(EnumModifier.GREATSWORD_MOD.id()).addModules(
                AttributeModule.builder(Attributes.ATTACK_SPEED, AttributeModifier.Operation.ADDITION).uniqueFrom(new ResourceLocation("tinkers_reforged:attack_damage_mod")).flat(-0.3f),
                AttributeModule.builder(Attributes.ATTACK_DAMAGE, AttributeModifier.Operation.MULTIPLY_BASE).uniqueFrom(new ResourceLocation("tinkers_reforged:attack_damage_mod")).flat(1.1f)
        ).tooltipDisplay(BasicModifier.TooltipDisplay.NEVER);
    }

    @Override
    public @NotNull String getName() {
        return "Tinkers Reforged Modifiers";
    }
}
