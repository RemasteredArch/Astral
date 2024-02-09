package dev.jaxydog.content.block;

import dev.jaxydog.content.block.custom.DyeableAmethystBlock;
import dev.jaxydog.content.block.custom.DyeableAmethystClusterBlock;
import dev.jaxydog.content.block.custom.DyeableAmethystClusterBlock.Variant;
import dev.jaxydog.content.block.custom.RandomizerBlock;
import dev.jaxydog.register.ContentRegistrar;
import dev.jaxydog.utility.DyeableMap;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.block.Blocks;

/** Contains definitions for all custom blocks */
public final class CustomBlocks extends ContentRegistrar {

    public static final DyeableMap<DyeableAmethystBlock> DYEABLE_AMETHYST_BLOCKS = new DyeableMap<>("amethyst_block",
        (rawId, color) -> new DyeableAmethystBlock(rawId, Settings.copy(Blocks.AMETHYST_BLOCK), color)
    );
    public static final DyeableMap<DyeableAmethystClusterBlock> DYEABLE_AMETHYST_CLUSTERS = new DyeableMap<>("amethyst_cluster",
        (rawId, color) -> {
            final Settings settings = Settings.copy(Blocks.AMETHYST_CLUSTER).mapColor(color);

            return new DyeableAmethystClusterBlock(rawId, settings, color, Variant.CLUSTER);
        }
    );
    public static final DyeableMap<DyeableAmethystClusterBlock> DYEABLE_LARGE_AMETHYST_BUDS = new DyeableMap<>("large_amethyst_bud",
        (rawId, color) -> {
            final Settings settings = Settings.copy(Blocks.LARGE_AMETHYST_BUD).mapColor(color);

            return new DyeableAmethystClusterBlock(rawId, settings, color, Variant.LARGE_BUD);
        }
    );
    public static final DyeableMap<DyeableAmethystClusterBlock> DYEABLE_MEDIUM_AMETHYST_BUDS = new DyeableMap<>("medium_amethyst_bud",
        (rawId, color) -> {
            final Settings settings = Settings.copy(Blocks.MEDIUM_AMETHYST_BUD).mapColor(color);

            return new DyeableAmethystClusterBlock(rawId, settings, color, Variant.MEDIUM_BUD);
        }
    );
    public static final DyeableMap<DyeableAmethystClusterBlock> DYEABLE_SMALL_AMETHYST_BUDS = new DyeableMap<>("small_amethyst_bud",
        (rawId, color) -> {
            final Settings settings = Settings.copy(Blocks.SMALL_AMETHYST_BUD).mapColor(color);

            return new DyeableAmethystClusterBlock(rawId, settings, color, Variant.SMALL_BUD);
        }
    );

    public static final RandomizerBlock RANDOMIZER = new RandomizerBlock("randomizer",
        Settings.copy(Blocks.IRON_BLOCK)
    );

}
