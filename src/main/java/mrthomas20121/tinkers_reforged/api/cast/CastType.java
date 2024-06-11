package mrthomas20121.tinkers_reforged.api.cast;

import mrthomas20121.tinkers_reforged.util.EnumData;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public enum CastType implements StringRepresentable {
    BOW_LIMB,
    BOW_GRIP,
    BOWSTRING,
    BROAD_AXE_HEAD,
    BROAD_BLADE,
    COIN,
    GEAR,
    GEM,
    HAMMER_HEAD,
    INGOT,
    LARGE_PLATE,
    NUGGET,
    PICK_HEAD,
    PLATE,
    REPAIR_KIT,
    ROD,
    SMALL_AXE_HEAD,
    SMALL_BLADE,
    TOOL_BINDING,
    TOOL_HANDLE,
    TOUGH_HANDLE,
    WIRE,
    GREAT_BLADE,
    LONG_BLADE,
    ROUND_PLATE;

    public static final CastType[] VALUES = CastType.values();

    @Override
    public @NotNull String getSerializedName() {
        return this.name().toLowerCase(Locale.ROOT);
    }
}
