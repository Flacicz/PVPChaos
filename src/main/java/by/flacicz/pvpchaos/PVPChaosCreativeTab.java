package by.flacicz.pvpchaos;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PVPChaosCreativeTab extends CreativeTabs {
    public static final PVPChaosCreativeTab INSTANCE = new PVPChaosCreativeTab();

    private PVPChaosCreativeTab() {
        super("PVPChaosTab");
    }


    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() {
        return PVPChaosItems.ringOfPower;
    }
}
