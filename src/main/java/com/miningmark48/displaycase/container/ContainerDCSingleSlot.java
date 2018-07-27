package com.miningmark48.displaycase.container;

import com.miningmark48.displaycase.container.slot.SlotType;
import com.miningmark48.displaycase.tile.base.TileEntityDisplayCaseBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import java.util.Objects;

public class ContainerDCSingleSlot extends Container {

    private TileEntityDisplayCaseBase te;
    private static int INV_START = TileEntityDisplayCaseBase.INV_SIZE, INV_END = INV_START + 26, HOTBAR_START = INV_END + 1, HOTBAR_END = HOTBAR_START + 8;

    public ContainerDCSingleSlot(final IInventory playerInv, TileEntityDisplayCaseBase te, SlotType slotType){
        this.te = te;

        this.addSlotToContainer(Objects.requireNonNull(slotType.getSlot(te, 0, 7, 7)));

        //Player Inventory
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                this.addSlotToContainer(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 31 + i * 18));
            }
        }

        //Hotbar
        for (int i = 0; i < 9; i++) {
            this.addSlotToContainer(new Slot(playerInv, i, 8 + i * 18, 89));
        }

    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return te.isUsableByPlayer(playerIn);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index){
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = (Slot) this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()){
            ItemStack itemstack1 = slot.getStack();
            stack = itemstack1.copy();

            if (index < INV_START){
                if (!this.mergeItemStack(itemstack1, INV_START, HOTBAR_END + 1, true)){
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, stack);
            } else {
                if(!this.mergeItemStack(itemstack1, 0, INV_START, false)){
                    return ItemStack.EMPTY;
                }
            }

            if (itemstack1.getCount() == 0){
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == stack.getCount()){
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemstack1);

        }

        return stack;

    }

}
