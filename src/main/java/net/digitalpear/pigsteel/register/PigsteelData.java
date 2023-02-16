package net.digitalpear.pigsteel.register;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Rarity;

public class PigsteelData {


    public static void registerLootTableModifications(){
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (LootTables.BASTION_OTHER_CHEST.equals(id) && source.isBuiltin()) {
                LootPool.Builder pool = LootPool.builder().with(ItemEntry.builder(PigsteelItems.PIGSTEEL_INGOT).weight(1).quality(Rarity.COMMON.ordinal() + 1))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1F, 2.0F)));
                tableBuilder.pool(pool);
            }
            if (LootTables.BASTION_TREASURE_CHEST.equals(id) && source.isBuiltin()) {
                LootPool.Builder pool = LootPool.builder().with(ItemEntry.builder(PigsteelBlocks.PIGSTEEL_BLOCK).weight(1).quality(Rarity.COMMON.ordinal() + 1))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2F, 5.0F)));
                tableBuilder.pool(pool);
            }
        });
    }
    public static void init(){
        registerLootTableModifications();
    }
}
