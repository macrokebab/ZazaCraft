package com.macrokebab.zazacraft.block.entity;


import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
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
    public void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        zazaCount = tag.getInt("ZazaCount");
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putInt("ZazaCount", zazaCount);
    }
}