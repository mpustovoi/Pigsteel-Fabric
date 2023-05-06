package net.digitalpear.pigsteel.datagen;

import net.digitalpear.pigsteel.register.PigsteelBlocks;
import net.digitalpear.pigsteel.register.PigsteelItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public class PigsteelBlockLootTableGen extends FabricBlockLootTableProvider {
    public PigsteelBlockLootTableGen(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {

    }

    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> biConsumer) {
        PigsteelBlocks.PIGSTEEL_WAXING_MAP.forEach((normal, waxed) -> {
            makeDrop(biConsumer, normal);
            makeDrop(biConsumer, waxed);
        });

        makeDrop(biConsumer, PigsteelBlocks.PORKSLAG, oreDrops(PigsteelBlocks.PORKSLAG, PigsteelItems.RAW_PIGSTEEL));

        makeDrop(biConsumer, PigsteelBlocks.PIGSTEEL_LANTERN);
        makeDrop(biConsumer, PigsteelBlocks.PIGSTEEL_SOUL_LANTERN);


        makeOre(biConsumer, PigsteelBlocks.PIGSTEEL_ORE, PigsteelItems.PIGSTEEL_NUGGET);
        makeOre(biConsumer, PigsteelBlocks.STONE_PIGSTEEL_ORE, PigsteelItems.PIGSTEEL_NUGGET);
        makeOre(biConsumer, PigsteelBlocks.DEEPSLATE_PIGSTEEL_ORE, PigsteelItems.PIGSTEEL_NUGGET);
        makeOre(biConsumer, PigsteelBlocks.BLUE_PIGSTEEL_ORE, PigsteelItems.PIGSTEEL_NUGGET);
        makeOre(biConsumer, PigsteelBlocks.BRIMSTONE_PIGSTEEL_ORE, PigsteelItems.PIGSTEEL_NUGGET);

    }
    public void makeDrop(BiConsumer<Identifier, LootTable.Builder> biConsumer, Block block){
        makeDrop(biConsumer, block, this.drops(block));
    }

    public void makeDrop(BiConsumer<Identifier, LootTable.Builder> biConsumer, Block block, net.minecraft.loot.LootTable.Builder builder){
        biConsumer.accept(Registries.BLOCK.getId(block).withPrefixedPath("blocks/"), builder);
    }
    public void makeOre(BiConsumer<Identifier, LootTable.Builder> biConsumer, Block block, ItemConvertible alternativeDrop){
        makeDrop(biConsumer, block, dropsWithSilkTouch(block, this.applyExplosionDecay(block, ItemEntry.builder(alternativeDrop).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 6.0F))).apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE)))));
    }
    public net.minecraft.loot.LootTable.Builder oreDrops(Block dropWithSilkTouch, Item drop) {
        return dropsWithSilkTouch(dropWithSilkTouch, (net.minecraft.loot.entry.LootPoolEntry.Builder)this.applyExplosionDecay(dropWithSilkTouch, ItemEntry.builder(drop).apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}
