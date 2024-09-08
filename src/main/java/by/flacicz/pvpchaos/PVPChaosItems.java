package by.flacicz.pvpchaos;

import by.flacicz.pvpchaos.armor.DoubleJumpBoots;
import by.flacicz.pvpchaos.items.BerserkerRing;
import by.flacicz.pvpchaos.items.RingOfPower;
import cpw.mods.fml.common.registry.GameRegistry;

public class PVPChaosItems {
    public static final RingOfPower ringOfPower = new RingOfPower();
    public static final DoubleJumpBoots doubleJumpBoots = new DoubleJumpBoots();
    public static final BerserkerRing berserkerRing = new BerserkerRing();

    public static void registry() {
        GameRegistry.registerItem(ringOfPower, "ring_of_power");
        GameRegistry.registerItem(doubleJumpBoots, "double_jump_boots");
        GameRegistry.registerItem(berserkerRing, "berserker_ring");
    }
}
