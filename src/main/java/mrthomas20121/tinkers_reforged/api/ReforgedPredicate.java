package mrthomas20121.tinkers_reforged.api;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;
import slimeknights.mantle.data.predicate.IJsonPredicate;
import slimeknights.mantle.data.predicate.entity.LivingEntityPredicate;
import slimeknights.mantle.data.predicate.entity.MobTypePredicate;

public class ReforgedPredicate {

    public static IJsonPredicate<LivingEntity> BOSSES = LivingEntityPredicate.tag(Tags.EntityTypes.BOSSES);
    public static IJsonPredicate<LivingEntity> BABY = LivingEntityPredicate.simple(LivingEntity::isBaby);
    public static IJsonPredicate<LivingEntity> NON_MINECRAFT_MOB = LivingEntityPredicate.simple(entity -> !ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).getNamespace().equals("minecraft"));
    public static IJsonPredicate<LivingEntity> IS_HOLDING_ITEM = LivingEntityPredicate.simple(entity -> entity.isHolding(ItemStack::isEnchantable));
    public static IJsonPredicate<LivingEntity> IS_WEARING_ARMOR = LivingEntityPredicate.simple(entity -> entity.getArmorCoverPercentage() > 0.0f);
    public static MobTypePredicate ILLAGER = new MobTypePredicate(MobType.ILLAGER);
}
