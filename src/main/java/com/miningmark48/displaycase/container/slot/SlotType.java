package com.miningmark48.displaycase.container.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

import java.lang.reflect.InvocationTargetException;

public enum SlotType {

    ALL (Slot.class),
    ARMOR (SlotArmor.class),
    BLOCK (SlotBlock.class),
    ITEM (SlotItem.class),
    TOOL (SlotTool.class),
    WEAPON (SlotWeapon.class);

    private Class<? extends Slot> slotClass;

    private <T extends Slot> SlotType(Class<T> slot) {
        this.slotClass = slot;
    }

    public Slot getSlot(IInventory te, int index, int x, int y) {
        try {
            return slotClass.getConstructor(IInventory.class, int.class, int.class, int.class).newInstance(te, index, x, y);
        } catch (InstantiationException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

}
