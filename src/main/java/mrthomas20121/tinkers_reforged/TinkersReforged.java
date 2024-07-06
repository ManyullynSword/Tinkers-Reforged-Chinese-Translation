package mrthomas20121.tinkers_reforged;

import mrthomas20121.tinkers_reforged.api.ReforgedModData;
import mrthomas20121.tinkers_reforged.client.TinkersReforgedBook;
import mrthomas20121.tinkers_reforged.datagen.*;
import mrthomas20121.tinkers_reforged.datagen.tcon.*;
import mrthomas20121.tinkers_reforged.init.*;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegisterEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import slimeknights.mantle.data.predicate.damage.DamageSourcePredicate;
import slimeknights.mantle.data.predicate.entity.LivingEntityPredicate;
import slimeknights.tconstruct.fluids.data.FluidBucketModelProvider;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;
import slimeknights.tconstruct.library.client.data.material.MaterialPartTextureGenerator;
import slimeknights.tconstruct.library.client.model.tools.ToolModel;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.json.variable.mining.MiningSpeedVariable;
import slimeknights.tconstruct.library.json.variable.tool.ToolVariable;
import slimeknights.tconstruct.tools.data.sprite.TinkerMaterialSpriteProvider;
import slimeknights.tconstruct.tools.data.sprite.TinkerPartSpriteProvider;

@Mod(TinkersReforged.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TinkersReforged {

	public static final String MOD_ID = "tinkers_reforged";
	public static final Logger LOGGER = LogManager.getLogger();

	public TinkersReforged() {
		TinkersReforgedTags.init();

		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		TinkersReforgedModifiers.MODIFIERS.register(bus);
		TinkersReforgedBlocks.BLOCKS.register(bus);
		TinkersReforgedItems.ITEMS.register(bus);
		TinkersReforgedFluids.FLUIDS.register(bus);
		TinkersReforgedWorldGen.CONFIGURED_FEATURES.register(bus);
		TinkersReforgedWorldGen.PLACED_FEATURES.register(bus);
		TinkersReforgedPotions.MOB_EFFECTS.register(bus);
		TinkersReforgedPotions.POTIONS.register(bus);

		MinecraftForge.EVENT_BUS.register(this);

		// execute this only on the client
		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> TinkersReforgedBook::initBook);
		bus.addListener(EventPriority.NORMAL, false, RegisterEvent.class, this::register);
	}

	private ResourceLocation getResource(String resource) {
		return new ResourceLocation(MOD_ID, resource);
	}

	private void register(RegisterEvent event) {
		if(event.getRegistryKey() == Registry.RECIPE_SERIALIZER_REGISTRY) {
			LivingEntityPredicate.LOADER.register(getResource("is_baby"), ReforgedModData.BABY.getLoader());
			LivingEntityPredicate.LOADER.register(getResource("non_minecraft_mob"), ReforgedModData.NON_MINECRAFT_MOB.getLoader());
			LivingEntityPredicate.LOADER.register(getResource("is_holding_item"), ReforgedModData.IS_HOLDING_ITEM.getLoader());
			LivingEntityPredicate.LOADER.register(getResource("is_wearing_armor"), ReforgedModData.IS_WEARING_ARMOR.getLoader());
			DamageSourcePredicate.LOADER.register(getResource("indirect"), ReforgedModData.INDIRECT.getLoader());
		}
	}

	@SubscribeEvent
	public static void gatherData(final GatherDataEvent event) {
		DataGenerator gen = event.getGenerator();
		ExistingFileHelper fileHelper = event.getExistingFileHelper();
		AbstractMaterialDataProvider materials = new ReforgedMaterials(gen);
		gen.addProvider(event.includeServer(), materials);
		gen.addProvider(event.includeServer(), new ReforgedTraits(gen, materials));
		gen.addProvider(event.includeServer(), new ReforgedMaterialStats(gen, materials));
		gen.addProvider(event.includeServer(), new ReforgedToolDefinitionDataProvider(gen));
		gen.addProvider(event.includeServer(), new ReforgedToolSlotLayout(gen));
		gen.addProvider(event.includeServer(), new ReforgedRecipes(gen));
		gen.addProvider(event.includeServer(), new ReforgedModifiers(gen));
		ReforgedBlocksTags tags = new ReforgedBlocksTags(gen, fileHelper);
		gen.addProvider(event.includeServer(), tags);
		gen.addProvider(event.includeServer(), new ReforgedFluidTags(gen, fileHelper));
		gen.addProvider(event.includeServer(), new ReforgedItemsTags(gen, tags, fileHelper));
		gen.addProvider(event.includeServer(), new ReforgedEntityTags(gen, fileHelper));
		gen.addProvider(event.includeServer(), new ReforgedWorldgenRegistryProvider(gen, fileHelper));
		gen.addProvider(event.includeClient(), new ReforgedColorDataProvider(gen));
		gen.addProvider(event.includeClient(), new ReforgedItemModels(gen, fileHelper));
		gen.addProvider(event.includeClient(), new ReforgedBlockStates(gen, fileHelper));
		gen.addProvider(event.includeClient(), new ReforgedLang(gen));
		AbstractMaterialSpriteProvider provider = new ReforgedMaterialSpriteProvider();
		AbstractMaterialSpriteProvider tinkersProvider = new TinkerMaterialSpriteProvider();
		gen.addProvider(event.includeClient(), new MaterialPartTextureGenerator(gen, fileHelper, new TinkerPartSpriteProvider(), provider));
		gen.addProvider(event.includeClient(), new MaterialPartTextureGenerator(gen, fileHelper, new ReforgedPartSprite(), provider));
		gen.addProvider(event.includeClient(), new MaterialPartTextureGenerator(gen, fileHelper, new ReforgedPartSprite(), tinkersProvider));
		gen.addProvider(event.includeClient(), new ReforgedRenderInfo(gen, provider, fileHelper));
		gen.addProvider(event.includeClient(), new ReforgedLootTables(gen));
		gen.addProvider(event.includeClient(), new FluidBucketModelProvider(gen, MOD_ID));
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = MOD_ID, value = Dist.CLIENT)
	public static class TinkersReforgedClient {
		public @SubscribeEvent
		static void itemColors(RegisterColorHandlersEvent.Item event) {
			final ItemColors colors = event.getItemColors();

			ToolModel.registerItemColors(colors, TinkersReforgedItems.LONGSWORD);
			ToolModel.registerItemColors(colors, TinkersReforgedItems.GREATSWORD);
		}
	}
}
