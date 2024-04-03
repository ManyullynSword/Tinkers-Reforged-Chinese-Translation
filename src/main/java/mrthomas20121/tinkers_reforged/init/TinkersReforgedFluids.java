package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.fluid.MoltenMetalFluidType;
import mrthomas20121.tinkers_reforged.api.fluid.ReforgedFluidType;
import mrthomas20121.tinkers_reforged.api.material.EnumFluid;
import mrthomas20121.tinkers_reforged.util.Helpers;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.registration.deferred.FluidDeferredRegister;
import slimeknights.mantle.registration.object.FlowingFluidObject;
import slimeknights.mantle.registration.object.FluidObject;

import java.util.Map;

public class TinkersReforgedFluids {

    public static final FluidDeferredRegister FLUIDS = new FluidDeferredRegister(TinkersReforged.MOD_ID);

    public static Map<EnumFluid, FlowingFluidObject<ForgeFlowingFluid>> ALL_FLUIDS = Helpers.mapOfKeys(EnumFluid.class,
            fluid -> register(fluid.getName(), fluid.getTemp(), fluid.getColor()));

    private static FlowingFluidObject<ForgeFlowingFluid> register(String name, int temp, int color) {

        FluidType.Properties type = FluidType.Properties.create()
                .density(2000)
                .viscosity(100000)
                .temperature(temp)
                .supportsBoating(false)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA);

        return FLUIDS.register(name).type(() -> new MoltenMetalFluidType(type, new ReforgedFluidType.FluidInfo(name, color,  0.1F, 1.5F))).block(Material.LAVA, 15).bucket().flowing();
    }
}
