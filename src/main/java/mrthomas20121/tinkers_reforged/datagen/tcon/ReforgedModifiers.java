package mrthomas20121.tinkers_reforged.datagen.tcon;

import mrthomas20121.tinkers_reforged.api.material.EnumReforgedModifier;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedPotions;
import net.minecraft.client.Minecraft;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;
import slimeknights.mantle.data.predicate.IJsonPredicate;
import slimeknights.mantle.data.predicate.damage.DamageSourcePredicate;
import slimeknights.mantle.data.predicate.entity.LivingEntityPredicate;
import slimeknights.mantle.data.predicate.entity.MobTypePredicate;
import slimeknights.mantle.data.registry.GenericLoaderRegistry;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.data.tinkering.AbstractModifierProvider;
import slimeknights.tconstruct.library.json.RandomLevelingValue;
import slimeknights.tconstruct.library.json.predicate.modifier.ModifierPredicate;
import slimeknights.tconstruct.library.json.predicate.tool.HasModifierPredicate;
import slimeknights.tconstruct.library.json.variable.melee.MeleeVariable;
import slimeknights.tconstruct.library.json.variable.tool.ConditionalToolVariable;
import slimeknights.tconstruct.library.json.variable.tool.ToolVariable;
import slimeknights.tconstruct.library.modifiers.modules.armor.BlockDamageSourceModule;
import slimeknights.tconstruct.library.modifiers.modules.armor.ProtectionModule;
import slimeknights.tconstruct.library.modifiers.modules.behavior.AttributeModule;
import slimeknights.tconstruct.library.modifiers.modules.build.StatBoostModule;
import slimeknights.tconstruct.library.modifiers.modules.combat.ConditionalMeleeDamageModule;
import slimeknights.tconstruct.library.modifiers.modules.combat.MobEffectModule;
import slimeknights.tconstruct.library.modifiers.modules.mining.ConditionalMiningSpeedModule;
import slimeknights.tconstruct.library.modifiers.modules.technical.ArmorStatModule;
import slimeknights.tconstruct.library.tools.capability.TinkerDataKeys;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import slimeknights.tconstruct.tools.TinkerModifiers;
import slimeknights.tconstruct.tools.data.ModifierIds;

public class ReforgedModifiers extends AbstractModifierProvider implements IConditionBuilder {

    public ReforgedModifiers(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void addModifiers() {
        buildModifier(EnumReforgedModifier.RAID_PROTECTION.id())
                .addModule(ProtectionModule.builder().attacker(new MobTypePredicate(MobType.ILLAGER)).eachLevel(1.25f));
        buildModifier(EnumReforgedModifier.ROCK_SOLID.id())
                .addModule(StatBoostModule.multiplyBase(ToolStats.DURABILITY).eachLevel(1.3f));
        buildModifier(EnumReforgedModifier.ADAPTABILITY.id()).addModule(
                ConditionalMiningSpeedModule.builder()
                        .customVariable("current_durability", ToolVariable.CURRENT_DURABILITY) // get the current durability
                        .formula()
                        .customVariable("durability", ToolVariable.simple(toolStack -> toolStack.getStats().getInt(ToolStats.DURABILITY))) // get the tool max durability
                        .subtract() // do current durability - durability
                        .variable(-1).multiply() // multiply the result by -1
                        .constant(0.01f).multiply() // multiply the result by 0.01
                        .add() // add the value
                        .build());

        buildModifier(EnumReforgedModifier.AMPLIFIER.id()).addModules(
                AttributeModule.builder(ForgeMod.ATTACK_RANGE.get(), AttributeModifier.Operation.ADDITION).eachLevel(0.1f),
                AttributeModule.builder(Attributes.MOVEMENT_SPEED, AttributeModifier.Operation.ADDITION).eachLevel(0.1f)
        );

        buildModifier(EnumReforgedModifier.AMPLITUDE.id()).addModules(
                AttributeModule.builder(ForgeMod.ATTACK_RANGE.get(), AttributeModifier.Operation.ADDITION).eachLevel(0.1f),
                StatBoostModule.multiplyBase(ToolStats.DURABILITY).eachLevel(1.1f)
        );

        buildModifier(EnumReforgedModifier.DEFENSIVE.id()).addModules(
                AttributeModule.builder(Attributes.MAX_HEALTH, AttributeModifier.Operation.ADDITION).eachLevel(1f)
        );

        buildModifier(EnumReforgedModifier.DRACONIC.id())
                .addModules(
                        ArmorStatModule.builder(TinkerDataKeys.EXPERIENCE).eachLevel(1.1f));

        buildModifier(EnumReforgedModifier.MALLEABLE.id())
                .addModules(
                        ArmorStatModule.builder(TinkerDataKeys.JUMP_BOOST).eachLevel(1.1f));

        buildModifier(EnumReforgedModifier.SIZZLING.id()).addModule(ConditionalMeleeDamageModule.builder().attacker(
                LivingEntityPredicate.or(LivingEntityPredicate.simple(LivingEntity::isOnFire), LivingEntityPredicate.simple(LivingEntity::fireImmune)))
                .eachLevel(1.5f));

        // deal more damage to illager, players and villagers
        buildModifier(EnumReforgedModifier.VORACIOUS.id()).addModule(
                ConditionalMeleeDamageModule.builder()
                        .attacker(
                                LivingEntityPredicate.or(
                                        new MobTypePredicate(MobType.ILLAGER),
                                        LivingEntityPredicate.set(EntityType.PLAYER),
                                        LivingEntityPredicate.tag(TinkerTags.EntityTypes.VILLAGERS)))
                        .eachLevel(1));

        buildModifier(EnumReforgedModifier.FROSTY.id())
                .addModules(
                        MobEffectModule.builder(TinkersReforgedPotions.FROZEN.get()).level(RandomLevelingValue.perLevel(0, 0.5f)).time(RandomLevelingValue.random(20, 10)).build());

        buildModifier(EnumReforgedModifier.TICKING.id())
                .addModules(
                        MobEffectModule.builder(TinkersReforgedPotions.TICKING.get()).level(RandomLevelingValue.perLevel(0, 1)).time(RandomLevelingValue.flat(3)).build());
    }

    @Override
    public @NotNull String getName() {
        return "Tinkers Reforged Modifiers";
    }
}
