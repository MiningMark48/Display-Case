package com.miningmark48.displaycase.init;

import com.miningmark48.displaycase.item.ItemFake;
import net.minecraft.item.Item;

public class ModItems {

    //Fake Items
    public static Item fake_fishing_rod;

    public static void init() {
        fake_fishing_rod = new ItemFake().setUnlocalizedName("fake_fishing_rod").setRegistryName("fake_fishing_rod");
    }

}
