package mrthomas20121.tinkers_reforged.api.material;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.modifier.*;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierId;

import java.util.Locale;
import java.util.function.Supplier;

public enum EnumModifier implements StringRepresentable {

    // any modifiers with supplier does not have a json modifier
    ACHILLES_RELIC("Achille's Relic", "While BELOW 50% hp, deal 10% more arrow and weapon damage.", AchillesRelicModifier::new),
    CHILD_PROTECTION("Increases protection against baby entities."),
    AQUA_PROTECTION("Increases protection against underwater entities."),
    WEAPON_PROTECTION("Increases protection against entities with weapons in hand."),
    ARMORED_PROTECTION("Increases protection against entities with armor pieces."),
    ADRENALINE("When you reach 30% of your health, you get regeneration 1 for 30s", AdrenalineModifier::new),
    RAID_PROTECTION("Increases protection against Illager."),
    ALL_PROTECTION("Increases protection against ALL entities."),
    GIANT_PROTECTION("Increases protection against bosses."),
    ROCK_SOLID("Increases Durability"),
    ADAPTABILITY("The more durability you have, the faster you mine."),
    MALLEABLE("Increases the protection cap."),
    AMPLIFIER("Increases Attack Range and Movement Speed."),
    VORACIOUS("Deal more damage to Witches, Villager, Pillager and Player."),
    DEFENSIVE("Increases Max Health by 1."),
    DRACONIC("Increases the amount of Experience orbs dropped."),
    DIFFUSING("Set base attack damage and mining speed to the highest of the two.", DiffusingModifier::new),
    LUCKY_CHARM("Increases luck."),
    COLOSSAL("Deal more damage to entities with more max health than you.", ColossalModifier::new),
    HEADSHOT("Deal more damage to armored targets.", HeadshotModifier::new),
    INFERNO("Deal more damage to entity based on their current health.", InfernoModifier::new),
    SIZZLING("Deal more damage against entity immune to fire."),
    AMPLITUDE("Increases your mining speed by 1.5x and Increases your reach distance by 1."),
    MIDAS_TOUCH("Entity drop gold nuggets when killed.", MidasTouchModifier::new),
    MYTHOLOGICAL_RESISTANCE("Increases protection against non vanilla mobs."),
    VITAL("Deal more critical hit damage.", VitalModifier::new),
    FROSTY("Arrows/Damage/Getting Attacked freeze the target for a few seconds."),
    GLINT("Arrows/Damage/Getting Attacked make the target glow/withered for a few seconds."),
    MUFFLED("x3 damage but you can never critical strike.", MuffledModifier::new),
    BUMPER("Knockback entity that damage you.", BumperModifier::new),
    SLASHING("Always land Critical Strike.", SlashingModifier::new),
    UNDER_THE_SEA("Mine faster the lower you are under the sea level.", UnderTheSeaModifier::new),
    RADIANT("Deal bonus radiant damage.", RadiantModifier::new),
    WEIGHT_RATIO("Add your tool's mining speed to the base damage.", WeightRatioModifier::new),
    PREVENTIVE_WEIGHT("Add your armor's armor stat to the base damage.", PreventiveWeightModifier::new),
    SPREAD("Set your mining speed and attack to the highest of the two stats.", DiffusingModifier::new),
    BACKSTAB("Deal more damage to entity if you damage them from behind.", BackStabModifier::new),
    TICKING("5s after hitting an entity, they take a percentage of their health as damage.")
    ;

    // java create a new array every time you call values() so we use a final array
    public static final EnumModifier[] VALUES = values();

    private final String modifierName;
    private final ModifierId modifierID;
    private final String description;
    private final @Nullable Supplier<Modifier> mod;

    EnumModifier(String description) {
        this.modifierName = this.getSerializedName();
        this.modifierID = this.create(this.getSerializedName());
        this.description = description;
        this.mod = null;
    }

    EnumModifier(String description, @Nullable Supplier<Modifier> mod) {
        this.modifierName = this.getSerializedName();
        this.description = description;
        this.modifierID = this.create(this.getSerializedName());
        this.mod = mod;
    }

    EnumModifier(String name, String description, @Nullable Supplier<Modifier> mod) {
        this.modifierName = name;
        this.modifierID = this.create(this.getSerializedName());
        this.description = description;
        this.mod = mod;
    }

    public final ModifierId id() {
        return this.modifierID;
    }

    public String getDescription() {
        return description;
    }

    public boolean hasModifier() {
        return this.mod != null;
    }

    public Supplier<Modifier> getModifier() {
        return mod;
    }

    private ModifierId create(String name) {
        return new ModifierId(TinkersReforged.MOD_ID, name);
    }

    public String getModifierName() {
        return modifierName;
    }

    @Override
    public @NotNull String getSerializedName() {
        return this.name().toLowerCase(Locale.ROOT);
    }
}
