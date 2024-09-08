package by.flacicz.pvpchaos.items;

import by.flacicz.pvpchaos.PVPChaos;
import by.flacicz.pvpchaos.PVPChaosCreativeTab;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class RingOfPower extends Item {
    public RingOfPower() {
        setUnlocalizedName("ring_of_power");
        setTextureName(PVPChaos.MODID + ":ring_of_power");
        setMaxStackSize(1);

        setCreativeTab(PVPChaosCreativeTab.INSTANCE);
    }

    public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
        super.onUpdate(stack, world, entity, itemSlot, isSelected);
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 2, 1, true));
        }
    }

}
