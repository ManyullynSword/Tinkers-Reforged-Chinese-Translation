package mrthomas20121.tinkers_reforged.util;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public interface EnumData extends StringRepresentable {

    String name();

    @Override
    default @NotNull String getSerializedName() {
        return this.getName();
    }

    default String getName() {
        return this.name().toLowerCase(Locale.ROOT);
    }
}
