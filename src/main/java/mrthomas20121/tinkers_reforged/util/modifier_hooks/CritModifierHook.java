package mrthomas20121.tinkers_reforged.util.modifier_hooks;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public interface CritModifierHook {

    CritModifierHook DEFAULT = (tool, player, event) -> {};

    void onCrit(IToolStackView tool, Player player, CriticalHitEvent event);
}
