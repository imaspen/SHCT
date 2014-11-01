package uk.zebcoding.shct.lib;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import uk.zebcoding.shct.common.items.ItemSHCTPick;
import uk.zebcoding.shct.init.SHCTItems;

/**
 * Created by Charlotte on 23/10/2014.
 */
public class SHCTEvents {
    @SubscribeEvent
    public void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        EntityPlayer player = event.entityPlayer;
        if (player != null) {
            ItemStack held = player.getHeldItem();
            if (held != null && (held.getItem() == SHCTItems.itemSHCTPick || held.getItem() == SHCTItems.itemSHCTShovel) && held.getItemDamage() == 1) {
                if (held.getItem() != null && held.getItem().canHarvestBlock(event.block, held)) {
                    event.newSpeed = event.originalSpeed * 7.5F;
                }
            }
        }
    }

    @SubscribeEvent
    public void onDropHarvest(BlockEvent.HarvestDropsEvent event) {
        if (!event.world.isRemote && event.harvester != null && event.harvester.getHeldItem() != null) {
            ItemStack tool = event.harvester.getHeldItem();
            if (tool.getItem() == SHCTItems.itemSHCTPick || tool.getItem() == SHCTItems.itemSHCTShovel) {
                if (tool.getItemDamage() == 1) {
                    Block block = event.block;
                    if (FurnaceRecipes.smelting().getSmeltingResult(new ItemStack(block)) != null || block == Blocks.stone) {
                        event.dropChance = 0.0F;
                        ItemStack furnaceResult = FurnaceRecipes.smelting().getSmeltingResult(new ItemStack(block));
                        float f = 0.7F;
                        double d0 = (double) (event.world.rand.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
                        double d1 = (double) (event.world.rand.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
                        double d2 = (double) (event.world.rand.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
                        if (furnaceResult != null) {
                            event.world.spawnEntityInWorld(new EntityItem(event.world, (double) event.x + d0, (double) event.y + d1, (double) event.z + d2, new ItemStack(furnaceResult.getItem())));
                        } else if (block == Blocks.stone) {
                            event.world.spawnEntityInWorld(new EntityItem(event.world, (double) event.x + d0, (double) event.y + d1, (double) event.z + d2, new ItemStack(Blocks.stone)));
                        }
                    }
                }
            }
        }
    }
}
