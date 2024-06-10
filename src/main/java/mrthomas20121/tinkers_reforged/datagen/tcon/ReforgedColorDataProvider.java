package mrthomas20121.tinkers_reforged.datagen.tcon;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.material.EnumMaterial;
import net.minecraft.data.DataGenerator;

public class ReforgedColorDataProvider extends MantleColorDataGenerator {

    public ReforgedColorDataProvider(DataGenerator generator) {
        super(generator, TinkersReforged.MOD_ID);
    }

    @Override
    void addColors() {
        for(EnumMaterial material: EnumMaterial.values()) {
            addMaterial(material.id, material.palette.baseColor);
            addModifier(material.mod.id(), material.palette.baseColor);
            if(!material.mod.id().equals(material.armorMod.id())) {
                addModifier(material.armorMod.id(), material.palette.baseColor);
            }
        }
    }
}
