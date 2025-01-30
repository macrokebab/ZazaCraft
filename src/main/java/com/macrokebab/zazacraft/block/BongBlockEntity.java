package com.macrokebab.zazacraft.block;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BongBlockEntity extends BlockEntity {
    private int zazaCount = 0;
    private static final int MAX_ZAZA = 5;

    public BongBlockEntity(BlockPos pos, BlockState state) {
        super(com.macrokebab.zazacraft.init.ModBlockEntities.BONG.get(), pos, state);
    }

    public boolean addZaza() {
        if (zazaCount < MAX_ZAZA) {
            zazaCount++;
            return true;
        }
        return false;
    }

    public void removeZaza() {
        if (zazaCount > 0) {
            zazaCount--;
        }
    }

    public int getZazaCount() {
        return zazaCount;
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        zazaCount = tag.getInt("ZazaCount");
    }

    @Override
    public void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("ZazaCount", zazaCount);
    }
}