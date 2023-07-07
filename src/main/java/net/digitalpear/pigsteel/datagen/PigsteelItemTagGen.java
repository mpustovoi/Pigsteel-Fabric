package net.digitalpear.pigsteel.datagen;

import net.digitalpear.pigsteel.register.PigsteelBlocks;
import net.digitalpear.pigsteel.register.PigsteelItems;
import net.digitalpear.pigsteel.register.tags.PigsteelItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class PigsteelItemTagGen extends FabricTagProvider<Item> {

    /**
     * Constructs a new {@link FabricTagProvider} with the default computed path.
     *
     * <p>Common implementations of this class are provided.
     *
     * @param output           the {@link FabricDataOutput} instance
     * @param registriesFuture the backing registry for the tag type
     */
    public PigsteelItemTagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, Registries.ITEM.getKey(), registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(PigsteelItemTags.PIGSTEEL_ORES)
                .add(PigsteelBlocks.PORKSLAG.asItem());

        getOrCreateTagBuilder(ItemTags.BEACON_PAYMENT_ITEMS).add(PigsteelItems.PIGSTEEL_INGOT);
        getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS).add(PigsteelItems.PIGSTEEL_INGOT);

        getOrCreateTagBuilder(PigsteelItemTags.C_IRON_INGOTS)
                .add(PigsteelItems.PIGSTEEL_INGOT);

        getOrCreateTagBuilder(PigsteelItemTags.C_IRON_BLOCKS)
                .add(PigsteelBlocks.PIGSTEEL_BLOCK.asItem());

        getOrCreateTagBuilder(PigsteelItemTags.C_ORES)
                .forceAddTag(PigsteelItemTags.PIGSTEEL_ORES);

    }
}
