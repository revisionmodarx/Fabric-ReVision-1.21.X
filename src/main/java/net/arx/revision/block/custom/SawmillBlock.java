package net.arx.revision.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.StonecutterBlock; // we extend StonecutterBlock for built-in behavior
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import net.arx.revision.screen.ModScreenHandlers;
import net.arx.revision.screen.SawmillScreenHandler;

public class SawmillBlock extends StonecutterBlock {
    private static final Text TITLE = Text.translatable("container.revision.sawmill");

    public SawmillBlock(Settings settings) {
        super(settings);
    }


    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.SUCCESS;
        } else {
            player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
            player.incrementStat(Stats.INTERACT_WITH_STONECUTTER); // reuse stonecutter stat
            return ActionResult.CONSUME;
        }
    }

    @Override
    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state,
                                                                World world,
                                                                BlockPos pos) {
        return new SimpleNamedScreenHandlerFactory(
                (syncId, inventory, player) -> new SawmillScreenHandler(syncId, inventory),
                TITLE
        );
    }
}
