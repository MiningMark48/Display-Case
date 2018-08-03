package com.miningmark48.displaycase.container;

import com.miningmark48.displaycase.container.slot.SlotType;
import com.miningmark48.displaycase.tile.base.TileEntityDisplayCaseBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import java.util.Objects;

public class ContainerDC extends Container {

    private IInventory tileInv;

    public ContainerDC(final IInventory playerInv, IInventory tileInv, SlotType slotType){
        this.tileInv = tileInv;
        tileInv.openInventory(null);

        if (tileInv.getSizeInventory() == 1) {
            this.addSlotToContainer(Objects.requireNonNull(slotType.getSlot(tileInv, 0, 80, 31)));
        } else if (tileInv.getSizeInventory() == 2) {
            this.addSlotToContainer(Objects.requireNonNull(slotType.getSlot(tileInv, 0, 53, 31)));
            this.addSlotToContainer(Objects.requireNonNull(slotType.getSlot(tileInv, 1, 107, 31)));
        } else if (tileInv.getSizeInventory() == 3) {
            this.addSlotToContainer(Objects.requireNonNull(slotType.getSlot(tileInv, 0, 53, 31)));
            this.addSlotToContainer(Objects.requireNonNull(slotType.getSlot(tileInv, 1, 80, 31)));
            this.addSlotToContainer(Objects.requireNonNull(slotType.getSlot(tileInv, 2, 107, 31)));
        }

        //Player Inventory
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                this.addSlotToContainer(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 62 + i * 18));
            }
        }

        //Hotbar
        for (int i = 0; i < 9; i++) {
            this.addSlotToContainer(new Slot(playerInv, i, 8 + i * 18, 120));
        }

    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return tileInv.isUsableByPlayer(playerIn);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index){
        ItemStack itemCopy = ItemStack.EMPTY;
        Slot slot = (Slot) this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack item = slot.getStack();
            itemCopy = item.copy();

            if (index < 15)
            {
                if (!this.mergeItemStack(item, 15, this.inventorySlots.size(), true))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(item, 0, 15, false))
            {
                return ItemStack.EMPTY;
            }

            if (item.getCount() == 0)
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return itemCopy;

    }

}
