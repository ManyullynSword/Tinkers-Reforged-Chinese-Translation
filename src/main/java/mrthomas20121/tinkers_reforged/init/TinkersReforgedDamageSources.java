package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Function;

public class TinkersReforgedDamageSources {

    public static DamageSource RADIANT(Entity entity) {
        return new EntityDamageSource("tinkers_reforged:radiant", entity).setScalesWithDifficulty().damageHelmet().bypassEnchantments();
    }

}
