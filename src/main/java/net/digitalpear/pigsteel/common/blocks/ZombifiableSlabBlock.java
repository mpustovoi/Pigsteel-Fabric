package net.digitalpear.pigsteel.common.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.OxidizableSlabBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class ZombifiableSlabBlock extends OxidizableSlabBlock {
    public ZombifiableSlabBlock(OxidationLevel oxidationLevel, Settings settings) {
        super(oxidationLevel, settings);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random)  {
        if (!world.isClient)
        if (world.getDimension().bedWorks()) {
            this.tickDegradation(state, world, pos, random);
        }
    }
}
