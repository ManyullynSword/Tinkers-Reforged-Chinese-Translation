package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.tinkers_reforged.ReforgedTraits;
import mrthomas20121.tinkers_reforged.library.MaterialGen;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.library.module.ModuleReforgedBase;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class MaterialsBaseMaterials extends ModuleReforgedBase {

    private Material glowstone = new Material("ref_glowstone", 0xFFC16B);
    private MaterialGen zinc = new MaterialGen("zinc", 0x94BD5E, "Zinc", 600);
    private MaterialGen titanium = new MaterialGen("titanium", 0xB2669E, "Titanium", 1000);
    private MaterialGen iridium = new MaterialGen("iridium", 0x80818E, "Iridium", 1200);
    private MaterialGen aluminum = new MaterialGen("aluminum", 0xBAAEA5, "Aluminum", 900);
    private MaterialGen platinum = new MaterialGen("platinum", 0x50939E, "Platinum", 2000);
    private MaterialGen invar = new MaterialGen("invar", 0xA2A4AA, "Invar", 800);
    private MaterialGen amethyst = new MaterialGen("amethyst", 0xF98EEB, "Amethyst", 600, true);
    private MaterialGen ruby = new MaterialGen("ruby", 0xFF1C28, "Ruby", 600, true);
    private MaterialGen sapphire = new MaterialGen("sapphire", 0xA8AFAB, "Sapphire", 600, true);
    private MaterialGen peridot = new MaterialGen("peridot", 0x6EC94A, "Peridot", 600, true);

    @Override
    public boolean canLoad() {
        return TinkersReforgedConfig.SettingMaterials.modules.base_materials;
    }

    @Override
    public void preInit() {
        if(TinkersReforgedConfig.SettingMaterials.materials.glowstone) {
            glowstone.addTrait(TinkerTraits.lightweight, MaterialTypes.HEAD);
            glowstone.addTrait(ReforgedTraits.bright);
            TinkerRegistry.addMaterial(glowstone);
            TinkerRegistry.addMaterialStats(glowstone,
                    new HeadMaterialStats(450, 4.7f, 4.3f, HarvestLevels.IRON),
                    new HandleMaterialStats(1, 90),
                    new ExtraMaterialStats(10),
                    new BowMaterialStats(2, 1.5f, 6));
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.zinc) {
            zinc.preInit();
            zinc.getMaterial().addTrait(TinkerTraits.crumbling, MaterialTypes.HEAD);
            zinc.getMaterial().addTrait(TinkerTraits.dense);
            TinkerRegistry.addMaterial(zinc.getMaterial());
            TinkerRegistry.addMaterialStats(zinc.getMaterial(),
                    new HeadMaterialStats(500, 5.7f, 6.3f, HarvestLevels.OBSIDIAN),
                    new HandleMaterialStats(1, 90),
                    new ExtraMaterialStats(10),
                    new BowMaterialStats(2, 1.5f, 6));
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.titanium) {
            titanium.preInit();
            titanium.getMaterial().addTrait(TinkerTraits.lightweight);
            TinkerRegistry.addMaterial(titanium.getMaterial());
            TinkerRegistry.addMaterialStats(titanium.getMaterial(),
                    new HeadMaterialStats(500, 5.7f, 6.3f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1, 90),
                    new ExtraMaterialStats(10),
                    new BowMaterialStats(3, 5, 3));
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.iridium) {
            iridium.preInit();
            iridium.getMaterial().addTrait(TinkerTraits.dense);
            TinkerRegistry.addMaterial(iridium.getMaterial());
            TinkerRegistry.addMaterialStats(iridium.getMaterial(),
                    new HeadMaterialStats(500, 5.7f, 6.3f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1, 60),
                    new ExtraMaterialStats(2),
                    new BowMaterialStats(5, 2.3f, 5));
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.aluminum) {
            aluminum.preInit();
            aluminum.getMaterial().addTrait(TinkerTraits.dense);
            TinkerRegistry.addMaterial(aluminum.getMaterial());
            TinkerRegistry.addMaterialStats(aluminum.getMaterial(),
                    new HeadMaterialStats(500, 5.9f, 6.1f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1, 100),
                    new ExtraMaterialStats(10),
                    new BowMaterialStats(8, 0.5f, 6));
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.platinum) {
            platinum.preInit();
            platinum.getMaterial().addTrait(TinkerTraits.dense);
            TinkerRegistry.addMaterial(platinum.getMaterial());
            TinkerRegistry.addMaterialStats(platinum.getMaterial(),
                    new HeadMaterialStats(500, 5.7f, 6.3f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1, 90),
                    new ExtraMaterialStats(10),
                    new BowMaterialStats(2, 12, 3));
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.invar) {
            invar.preInit();
            invar.getMaterial().addTrait(TinkerTraits.hellish);
            TinkerRegistry.addMaterial(invar.getMaterial());
            TinkerRegistry.addMaterialStats(invar.getMaterial(),
                    new HeadMaterialStats(500, 5.7f, 6.3f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1, 90),
                    new ExtraMaterialStats(10),
                    new BowMaterialStats(2, 1.5f, 6));
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.amethyst) {
            amethyst.preInit();
            amethyst.getMaterial().addTrait(TinkerTraits.sharp);
            TinkerRegistry.addMaterial(amethyst.getMaterial());
            TinkerRegistry.addMaterialStats(amethyst.getMaterial(),
                    new HeadMaterialStats(300, 5.7f, 6.3f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(0.6f, 190),
                    new ExtraMaterialStats(10),
                    new BowMaterialStats(2, 3, 5));
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.ruby) {
            ruby.preInit();
            ruby.getMaterial().addTrait(TinkerTraits.sharp);
            TinkerRegistry.addMaterial(ruby.getMaterial());
            TinkerRegistry.addMaterialStats(ruby.getMaterial(),
                    new HeadMaterialStats(300, 5.7f, 6.3f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(0.6f, 190),
                    new ExtraMaterialStats(10),
                    new BowMaterialStats(3, 2, 5));
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.sapphire) {
            sapphire.preInit();
            sapphire.getMaterial().addTrait(TinkerTraits.sharp);
            TinkerRegistry.addMaterial(sapphire.getMaterial());
            TinkerRegistry.addMaterialStats(sapphire.getMaterial(),
                    new HeadMaterialStats(300, 5.7f, 6.3f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(0.6f, 190),
                    new ExtraMaterialStats(10),
                    new BowMaterialStats(5, 3, 2));
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.peridot) {
            peridot.preInit();
            peridot.getMaterial().addTrait(TinkerTraits.splintering);
            TinkerRegistry.addMaterial(peridot.getMaterial());
            TinkerRegistry.addMaterialStats(peridot.getMaterial(),
                    new HeadMaterialStats(300, 5.7f, 6.3f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(0.6f, 190),
                    new ExtraMaterialStats(10),
                    new BowMaterialStats(2, 5, 3));
        }
    }

    @Override
    public void init() {

        if(TinkersReforgedConfig.SettingMaterials.materials.glowstone) {
            glowstone.setRepresentativeItem("dustGlowstone");
            glowstone.addItem("dustGlowstone", 1, 1);
        }

        if(!OreDictionary.getOres("ingotZinc").isEmpty() && TinkersReforgedConfig.SettingMaterials.materials.zinc) {
            zinc.init();
        }
        if(!OreDictionary.getOres("ingotTitanium").isEmpty() && TinkersReforgedConfig.SettingMaterials.materials.titanium) {
            titanium.init();
        }
        if(!OreDictionary.getOres("ingotIridium").isEmpty() && TinkersReforgedConfig.SettingMaterials.materials.iridium) {
            iridium.init();
        }
        if(!OreDictionary.getOres("ingotAluminum").isEmpty() && TinkersReforgedConfig.SettingMaterials.materials.aluminum) {
            aluminum.init();
        }
        if(!OreDictionary.getOres("ingotPlatinum").isEmpty() && TinkersReforgedConfig.SettingMaterials.materials.platinum) {
            platinum.init();
        }
        if(!OreDictionary.getOres("ingotInvar").isEmpty() && TinkersReforgedConfig.SettingMaterials.materials.invar) {
            invar.init();
        }
        if(!OreDictionary.getOres("gemAmethyst").isEmpty() && TinkersReforgedConfig.SettingMaterials.materials.amethyst) {
            amethyst.init();
        }
        if(!OreDictionary.getOres("gemRuby").isEmpty() && TinkersReforgedConfig.SettingMaterials.materials.ruby) {
            ruby.init();
        }
        if(!OreDictionary.getOres("gemSapphire").isEmpty() && TinkersReforgedConfig.SettingMaterials.materials.sapphire) {
            sapphire.init();
        }
        if(!OreDictionary.getOres("gemPeridot").isEmpty() && TinkersReforgedConfig.SettingMaterials.materials.peridot) {
            peridot.init();
        }
    }
}
