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

public enum EnumReforgedModifier implements StringRepresentable {

    // any modifiers with supplier does not have a json modifier
    RAID_PROTECTION("Increases protection against Illager."),
    ROCK_SOLID("Increases Durability"),
    ADAPTABILITY("Deal bonus damage based on the difference between max and current durability."),
    MALLEABLE("Increases Jump Boost and Attack Damage."),
    AMPLIFIER("Increases Attack Range and Movement Speed."),
    VORACIOUS("Deal more damage to Witches, Villager, Pillager and Player."),
    DEFENSIVE("Increases Max Health by 1."),
    DRACONIC("Increases the amount of Experience orbs dropped."),
    SIZZLING("Deal more damage against entity immune to fire."),
    AMPLITUDE("Increases your mining speed by 1.5x and Increases your reach distance by 1."),
    MIDAS_TOUCH("Entity drop gold nuggets when killed.", MidasTouchModifier::new),
    VITAL("Deal more critical hit damage.", VitalModifier::new),
    FROSTY("Arrows freeze the target for a few seconds."),
    BUMPER("Knockback entity that damage you.", BumperModifier::new),
    SLASHING("Always land Critical Strike.", SlashingModifier::new),
    UNDER_THE_SEA("Mine faster the lower you are under the sea level.", UnderTheSeaModifier::new),
    WEIGHT_RATIO("Add your tool's mining speed to the base damage.", WeightRatioModifier::new),
    SPREAD("Set your mining speed and attack to the highest of the two stats.", DiffusingModifier::new),
    BACKSTAB("Deal more damage to entity if you damage them from behind.", BackStabModifier::new),
    TICKING("5s after hitting an entity, they take a percentage of their health as damage.")
    ;

    // java create a new array every time you call values() so we use a final array
    public static final EnumReforgedModifier[] VALUES = values();

    private final ModifierId modifierID;
    private final String description;
    private final @Nullable Supplier<Modifier> mod;

    EnumReforgedModifier(String description) {
        this.modifierID = this.create(this.getSerializedName());
        this.description = description;
        this.mod = null;
    }

    EnumReforgedModifier(String description, @NotNull Supplier<Modifier> mod) {
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

    @Override
    public @NotNull String getSerializedName() {
        return this.name().toLowerCase(Locale.ROOT);
    }
}
