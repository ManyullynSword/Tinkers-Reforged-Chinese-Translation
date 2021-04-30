package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.tinkers_reforged.library.MaterialGen;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.library.module.ModuleReforgedBase;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class MaterialsProjectRed extends ModuleReforgedBase {

    private MaterialGen red_alloy = new MaterialGen("red_alloy", 0xED4242, "RedAlloy", 500);
    private MaterialGen electrotine_alloy = new MaterialGen("electrotine_alloy", 0x0E73AA, "ElectrotineAlloy", 700);
    private Material electrotine = new Material("ref_electrotine", 0x43C7ED);

    @Override
    public boolean canLoad() {
        return TinkersReforgedConfig.SettingMaterials.modules.project_red;
    }

    @Override
    public void preInit() {
        if(TinkersReforgedConfig.SettingMaterials.materials.red_alloy) {
            red_alloy.preInit();
            red_alloy.getMaterial().addTrait(TinkerTraits.jagged);
            TinkerRegistry.addMaterial(red_alloy.getMaterial());
            TinkerRegistry.addMaterialStats(red_alloy.getMaterial(),
                    new HeadMaterialStats(200, 6, 6, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1.3f, 88),
                    new ExtraMaterialStats(47),
                    new BowMaterialStats(4.8f, 4.2f, 4));
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.electrotine_alloy) {
            electrotine_alloy.preInit();
            electrotine_alloy.getMaterial().addTrait(TinkerTraits.shocking, MaterialTypes.HEAD);
            electrotine_alloy.getMaterial().addTrait(TinkerTraits.magnetic);
            TinkerRegistry.addMaterial(electrotine_alloy.getMaterial());
            TinkerRegistry.addMaterialStats(electrotine_alloy.getMaterial(),
                    new HeadMaterialStats(300, 7, 7, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1.3f, 88),
                    new ExtraMaterialStats(80),
                    new BowMaterialStats(4.8f, 4.2f, 4));
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.electrotine) {
            electrotine.addTrait(TinkerTraits.shocking);
            TinkerRegistry.addMaterial(electrotine);
            TinkerRegistry.addMaterialStats(electrotine,
                    new HeadMaterialStats(200, 4, 4, HarvestLevels.IRON),
                    new HandleMaterialStats(1.3f, 88),
                    new ExtraMaterialStats(23),
                    new BowMaterialStats(4.8f, 4.2f, 4));
        }
    }

    @Override
    public void init() {
        if(TinkersReforgedConfig.SettingMaterials.materials.red_alloy) {
            red_alloy.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.electrotine_alloy) {
            electrotine_alloy.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.electrotine) {
            electrotine.setCraftable(true);
            electrotine.addItem("dustElectrotine", 1, Material.VALUE_Ingot);
            electrotine.setRepresentativeItem("dustElectrotine");
        }
    }
}
