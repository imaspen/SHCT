package uk.zebcoding.shct.client.renderers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;
import uk.zebcoding.shct.lib.Names;

/**
 * Created by Charlotte on 29/10/2014.
 */
public class ToolRenderer implements IItemRenderer {
    private static RenderItem renderItem = new RenderItem();

    @Override
    public boolean handleRenderType(ItemStack itemStack, ItemRenderType type) {
        return type == ItemRenderType.INVENTORY;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return false;
    }

    @Override
    public void renderItem(IItemRenderer.ItemRenderType type, ItemStack itemStack, Object... data) {
        FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
        GL11.glEnable(GL11.GL_BLEND);

        IIcon icon = itemStack.getIconIndex();
        renderItem.renderIcon(0, 0, icon, 16, 16);

        if (itemStack.getItemDamage() == 1) {
            int damage = itemStack.stackTagCompound.getByte(Names.NBT.DAMAGE);

            GL11.glDisable(GL11.GL_TEXTURE_2D);
            GL11.glDepthMask(false);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

            Tessellator tessellator = Tessellator.instance;
            tessellator.startDrawing(GL11.GL_QUADS);
            tessellator.setColorRGBA(0, 0, 0, 128);
            if (damage >= 10) {
                tessellator.addVertex(3, 7, 0);
                tessellator.addVertex(3, 16, 0);
            } else {
                tessellator.addVertex(9, 7, 0);
                tessellator.addVertex(9, 16, 0);
            }
            tessellator.addVertex(16, 16, 0);
            tessellator.addVertex(16, 7, 0);
            tessellator.draw();

            GL11.glDepthMask(true);
            GL11.glDisable(GL11.GL_BLEND);

            GL11.glEnable(GL11.GL_TEXTURE_2D);
            String text = Integer.toString(itemStack.stackTagCompound.getByte(Names.NBT.DAMAGE));
            fontRenderer.drawStringWithShadow(text, damage >= 10 ? 4 : 10, 8, 0xFFFFFF);
        } else {
            GL11.glDisable(GL11.GL_BLEND);
        }
    }
}