package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.cast.CastType;
import mrthomas20121.tinkers_reforged.item.book.TinkersReforgedBookItem;
import mrthomas20121.tinkers_reforged.util.Helpers;
import mrthomas20121.tinkers_reforged.api.material.EnumGem;
import mrthomas20121.tinkers_reforged.api.material.EnumMetal;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import slimeknights.mantle.registration.object.EnumObject;
import slimeknights.mantle.registration.object.ItemObject;
import slimeknights.mantle.util.SupplierCreativeTab;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.common.registration.CastItemObject;
import slimeknights.tconstruct.common.registration.ItemDeferredRegisterExtension;
import slimeknights.tconstruct.library.materials.MaterialRegistry;
import slimeknights.tconstruct.library.materials.definition.IMaterial;
import slimeknights.tconstruct.library.tools.part.ToolPartItem;
import slimeknights.tconstruct.tools.item.ModifiableSwordItem;
import slimeknights.tconstruct.tools.stats.HeadMaterialStats;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TinkersReforgedItems {

    public static final ItemDeferredRegisterExtension ITEMS = new ItemDeferredRegisterExtension(TinkersReforged.MOD_ID);

    public static final CreativeModeTab resourceTab = new SupplierCreativeTab(TinkersReforged.MOD_ID, "resources",
            () -> new ItemStack(TinkersReforgedItems.METALS.get(EnumMetal.ALUMINUM).get(EnumMetal.ItemType.INGOT).get()));

    public static final CreativeModeTab castTab = new SupplierCreativeTab(TinkersReforged.MOD_ID, "casts",
            () -> new ItemStack(TinkersReforgedItems.ALU_BRASS_CASTS.get(CastType.GEAR)));

    public static final CreativeModeTab TAB_TOOL_PARTS = new SupplierCreativeTab(TinkersReforged.MOD_ID, "tool_parts", () -> {
        List<IMaterial> materials = new ArrayList<>(MaterialRegistry.getInstance().getVisibleMaterials());
        if (materials.isEmpty()) {
            return new ItemStack(TinkersReforgedItems.LONG_BLADE.get());
        }
        return TinkersReforgedItems.LONG_BLADE.get().withMaterial(materials.get(TConstruct.RANDOM.nextInt(materials.size())).getIdentifier());
    });

    public static final CreativeModeTab TAB_TOOLS = new SupplierCreativeTab(TinkersReforged.MOD_ID, "tools", () -> TinkersReforgedItems.LONGSWORD.get().getRenderTool());

    private static final Item.Properties TOOL = new Item.Properties().stacksTo(1).tab(TAB_TOOLS);
    private static final Item.Properties PARTS_PROPS = new Item.Properties().tab(TAB_TOOL_PARTS);

    public static ItemObject<Item> book = ITEMS.register("reforging_guide", () -> new TinkersReforgedBookItem(new Item.Properties().stacksTo(1).tab(resourceTab)));

    public static ItemObject<Item> ender_bone = ITEMS.register("ender_bone", TinkersReforgedItems::register);

    public static Map<EnumMetal, ItemObject<Item>> RAW_ORES = Helpers.mapOfKeys(EnumMetal.class, EnumMetal::isThisOre, metal ->
            ITEMS.register("raw_%s".formatted(metal.getName()), () -> new Item(new Item.Properties().tab(resourceTab))));

    public static Map<EnumMetal, Map<EnumMetal.ItemType, ItemObject<Item>>> METALS = Helpers.mapOfKeys(EnumMetal.class, metal ->
            Helpers.mapOfKeys(EnumMetal.ItemType.class, itemType -> ITEMS.register("%s_%s".formatted(metal.getName(), itemType.getName()), () -> new Item(new Item.Properties().tab(resourceTab)))));

    public static Map<EnumGem, Map<EnumGem.ItemType, ItemObject<Item>>> GEMS = Helpers.mapOfKeys(EnumGem.class, gem ->
            Helpers.mapOfKeys(EnumGem.ItemType.class, itemType -> ITEMS.register("%s_%s".formatted(gem.getName(), itemType.getName()), () -> new Item(new Item.Properties().tab(resourceTab)))));

    public static EnumObject<CastType, Item> ALU_BRASS_CASTS = ITEMS.registerEnum("aluminum_brass_cast", CastType.VALUES, (type) -> new Item(new Item.Properties().tab(castTab)));

    public static final ItemObject<ToolPartItem> GREAT_BLADE = ITEMS.register("great_blade", () -> new ToolPartItem(PARTS_PROPS, HeadMaterialStats.ID));

    public static final ItemObject<ToolPartItem> LONG_BLADE = ITEMS.register("long_blade", () -> new ToolPartItem(PARTS_PROPS, HeadMaterialStats.ID));

    public static final ItemObject<ModifiableSwordItem> LONGSWORD = ITEMS.register("longsword", () -> new ModifiableSwordItem(TOOL, TinkersReforgedToolDefinitions.LONGSWORD));

    public static final ItemObject<ModifiableSwordItem> GREATSWORD = ITEMS.register("greatsword", () -> new ModifiableSwordItem(TOOL, TinkersReforgedToolDefinitions.GREATSWORD));

    public static CastItemObject GREAT_BLADE_CAST = ITEMS.registerCast("great_blade", new Item.Properties().tab(castTab));

    public static CastItemObject LONG_BLADE_CAST = ITEMS.registerCast("long_blade", new Item.Properties().tab(castTab));

    public static Item register() {
        return new Item(new Item.Properties().tab(resourceTab));
    }

}
