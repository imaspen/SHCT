package uk.zebcoding.shct.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import uk.zebcoding.shct.common.container.ContainerSHCTFurnace;
import uk.zebcoding.shct.common.tileentity.TileEntitySHCTFurnace;

/**
 * Created by Charlotte on 01/11/2014.
 */
public class GuiSHCTFurnace extends GuiContainer {
    private static final ResourceLocation furnaceGuiTextures = new ResourceLocation("textures/gui/container/furnace.png");
    private TileEntitySHCTFurnace ceramicFurnace;

    public GuiSHCTFurnace(InventoryPlayer inventoryPlayer, TileEntitySHCTFurnace ceramicFurnace) {
        super(new ContainerSHCTFurnace(inventoryPlayer, ceramicFurnace));
        this.ceramicFurnace = ceramicFurnace;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
        String s = I18n.format(this.ceramicFurnace.getInventoryName(), new Object[0]);
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(furnaceGuiTextures);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

        int i1 = this.ceramicFurnace.getCookProgressScaled(24);
        this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
    }
}
