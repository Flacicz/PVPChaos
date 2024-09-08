package by.flacicz.pvpchaos.armor;

import by.flacicz.pvpchaos.PVPChaosCreativeTab;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DoubleJumpBoots extends ItemArmor {
    private static final int maxAllowedJumps = 1;
    private int jumps = 0;

    public DoubleJumpBoots() {
        super(ArmorMaterial.DIAMOND, 0, 3);
        setUnlocalizedName("double_jump_boots");
        setCreativeTab(PVPChaosCreativeTab.INSTANCE);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
        player.fallDistance = 0.0f;

        if (player.onGround) {
            jumps = 0;
        }
        if (jumps < maxAllowedJumps && player.isAirBorne && Minecraft.getMinecraft().gameSettings.keyBindJump.isPressed()) {
            player.jump();
            jumps++;
        }
    }
}
