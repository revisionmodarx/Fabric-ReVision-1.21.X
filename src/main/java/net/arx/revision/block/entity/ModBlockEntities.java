package net.arx.revision.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.arx.revision.ReVision;
import net.arx.revision.block.ModBlocks;
import net.arx.revision.block.entity.custom.SawmillBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {

    public static final BlockEntityType<SawmillBlockEntity> GROWTH_CHAMBER_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(ReVision.MOD_ID, "sawmill_be"),
                    FabricBlockEntityTypeBuilder.create(SawmillBlockEntity::new, ModBlocks.SAWMILL).build(null));


    public static void registerBlockEntities() {
        ReVision.LOGGER.info("Registering Block Entities for " + ReVision.MOD_ID);
    }
}