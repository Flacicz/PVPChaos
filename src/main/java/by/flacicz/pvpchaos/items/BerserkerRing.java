package by.flacicz.pvpchaos.items;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import by.flacicz.pvpchaos.PVPChaosCreativeTab;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class BerserkerRing extends Item implements IBauble {
    public BerserkerRing() {
        setUnlocalizedName("berserker_ring");
        setMaxStackSize(1);
        setCreativeTab(PVPChaosCreativeTab.INSTANCE);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer entity) {
        if (!world.isRemote) {
            if (stack.hasTagCompound()) {
                NBTTagCompound nbt = stack.getTagCompound();
                entity.addChatMessage(new ChatComponentText(nbt.toString()));
            } else {
                entity.addChatMessage(new ChatComponentText("Item has no NBT tags."));
            }
        }
        return stack;
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
        super.onUpdate(stack, world, entity, itemSlot, isSelected);

        if (!stack.hasTagCompound() & !world.isRemote) {
            stack.setTagCompound(new NBTTagCompound());
            NBTTagCompound nbt = stack.getTagCompound();
            nbt.setInteger("cooldown", 0);
            stack.setTagCompound(nbt);
        }
    }

    public boolean canUseRelic(ItemStack stack) {
        if (stack.hasTagCompound()) {
            NBTTagCompound nbt = stack.getTagCompound();
            if (nbt.hasKey("cooldown")) {
                int cooldown = nbt.getInteger("cooldown");

                if (cooldown != 0) {
                    nbt.setInteger("cooldown", --cooldown);
                    stack.setTagCompound(nbt);
                } else {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack) {
        return BaubleType.RING;
    }

    @Override
    public void onWornTick(ItemStack stack, EntityLivingBase entityLivingBase) {
        EntityPlayer player = (EntityPlayer) entityLivingBase;
        NBTTagCompound nbt = stack.getTagCompound();

        if (player.getHealth() < 5.0F & canUseRelic(stack)) {
            player.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 400, 1, true));
            player.addPotionEffect(new PotionEffect(22, 2400, 3, true));
            player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 6000, 0, true));
            player.addPotionEffect(new PotionEffect(Potion.resistance.getId(), 6000, 0, true));

            nbt.setInteger("cooldown", 400);
            stack.setTagCompound(nbt);
        }


    }

    @Override
    public void onEquipped(ItemStack itemStack, EntityLivingBase entityLivingBase) {

    }

    @Override
    public void onUnequipped(ItemStack itemStack, EntityLivingBase entityLivingBase) {

    }

    @Override
    public boolean canEquip(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        return true;
    }

    @Override
    public boolean canUnequip(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        return true;
    }
}
