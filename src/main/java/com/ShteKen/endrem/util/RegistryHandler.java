package com.ShteKen.endrem.util;

import com.ShteKen.endrem.EndRemastered;
import com.ShteKen.endrem.STConfiguredStructures;
import com.ShteKen.endrem.STStructures;
import com.ShteKen.endrem.blocks.*;
import com.ShteKen.endrem.items.ItemBase;
import com.ShteKen.endrem.world.structures.EndCastle;
import com.ShteKen.endrem.world.structures.EndCastlePieces;
import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.world.gen.feature.DecoratedFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;
import org.apache.commons.compress.archivers.zip.UnsupportedZipFeatureException;

public class RegistryHandler {

    //where every blocks and items are registered and might register the biomes here later

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EndRemastered.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EndRemastered.MOD_ID);
    public static final DeferredRegister<Structure<?>> STRUCTURE_FEATURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, EndRemastered.MOD_ID);

    public static void init() {

        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        STRUCTURE_FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
   // public static final RegistryObject<Item> END_CASTLE = STRUCTURE_FEATURES.register("end_castle", STStructures<Structure<?>>::new);

    //Item
    public static final RegistryObject<Item> OLD_PEARL = ITEMS.register("old_pearl", ItemBase::new);
    public static final RegistryObject<Item> ROGUE_PEARL = ITEMS.register("rogue_pearl", ItemBase::new);
    public static final RegistryObject<Item> NETHER_PEARL = ITEMS.register("nether_pearl", ItemBase::new);
    public static final RegistryObject<Item> COLD_PEARL = ITEMS.register("cold_pearl", ItemBase::new);
    public static final RegistryObject<Item> CORRUPTED_PEARL = ITEMS.register("corrupted_pearl", ItemBase::new);
    public static final RegistryObject<Item> MAGICAL_PEARL = ITEMS.register("magical_pearl", ItemBase::new);
    public static final RegistryObject<Item> BLACK_PEARL = ITEMS.register("black_pearl", ItemBase::new);
    public static final RegistryObject<Item> LOST_PEARL = ITEMS.register("lost_pearl", ItemBase::new);
    public static final RegistryObject<Item> WITHER_PEARL = ITEMS.register("wither_pearl", ItemBase::new);
    public static final RegistryObject<Item> END_CRYSTAL_PEARL = ITEMS.register("end_crystal_pearl", ItemBase::new);
    public static final RegistryObject<Item> GUARDIAN_PEARL = ITEMS.register("guardian_pearl", ItemBase::new);
    public static final RegistryObject<Item> END_CRYSTAL_FRAGMENT = ITEMS.register("end_crystal_fragment", ItemBase::new);

    public static final RegistryObject<Item> CORE = ITEMS.register("core", ItemBase::new);
    public static final RegistryObject<Item> POWERED_CORE = ITEMS.register("powered_core", ItemBase::new);



    //Block
    public static final RegistryObject<Block> END_CREATOR = BLOCKS.register("end_creator", EndCreator::new);
    public static final RegistryObject<Block> END_CREATOR_ACTIVATED = BLOCKS.register("end_creator_activated", EndCreatorActivated::new);

    public static final RegistryObject<Block> OLD_FRAME = BLOCKS.register("old_frame", FrameClass::new);
    public static final RegistryObject<Block> ROGUE_FRAME = BLOCKS.register("rogue_frame", FrameClass::new);
    public static final RegistryObject<Block> NETHER_FRAME = BLOCKS.register("nether_frame", FrameClass::new);
    public static final RegistryObject<Block> COLD_FRAME = BLOCKS.register("cold_frame", FrameClass::new);
    public static final RegistryObject<Block> CORRUPTED_FRAME = BLOCKS.register("corrupted_frame", FrameClass::new);
    public static final RegistryObject<Block> MAGICAL_FRAME = BLOCKS.register("magical_frame", FrameClass::new);
    public static final RegistryObject<Block> BLACK_FRAME = BLOCKS.register("black_frame", FrameClass::new);
    public static final RegistryObject<Block> LOST_FRAME = BLOCKS.register("lost_frame", FrameClass::new);
    public static final RegistryObject<Block> WITHER_FRAME = BLOCKS.register("wither_frame", FrameClass::new);
    public static final RegistryObject<Block> END_CRYSTAL_FRAME = BLOCKS.register("end_crystal_frame", FrameClass::new);
    public static final RegistryObject<Block> GUARDIAN_FRAME = BLOCKS.register("guardian_frame", FrameClass::new);
    public static final RegistryObject<Block> EMPTY_FRAME = BLOCKS.register("empty_frame", EmptyFrame::new);

    public static final RegistryObject<Block> END_CRYSTAL_ORE = BLOCKS.register("end_crystal_ore", () -> new OreBlockBase(Block.Properties.from(Blocks.ANCIENT_DEBRIS)));

    //Block Item

    public static final RegistryObject<Item> END_CREATOR_ITEM = ITEMS.register("end_creator", () -> new BlockItem(END_CREATOR.get(), new Item.Properties().group(EndRemastered.TAB)));
    public static final RegistryObject<Item> END_CREATOR_ACTIVATED_ITEM = ITEMS.register("end_creator_activated", () -> new BlockItem(END_CREATOR_ACTIVATED.get(), new Item.Properties().group(EndRemastered.TAB)));
    public static final RegistryObject<Item> EMPTY_FRAME_ITEM = ITEMS.register("empty_frame", () -> new BlockItem(EMPTY_FRAME.get(), new Item.Properties().group(EndRemastered.TAB)));

    public static final RegistryObject<Item> OLD_FRAME_ITEM = ITEMS.register("old_frame", () -> new BlockItem(OLD_FRAME.get(), new Item.Properties().group(EndRemastered.TAB)));
    public static final RegistryObject<Item> ROGUE_FRAME_ITEM = ITEMS.register("rogue_frame", () -> new BlockItem(ROGUE_FRAME.get(), new Item.Properties().group(EndRemastered.TAB)));
    public static final RegistryObject<Item> NETHER_FRAME_ITEM = ITEMS.register("nether_frame", () -> new BlockItem(NETHER_FRAME.get(), new Item.Properties().group(EndRemastered.TAB)));
    public static final RegistryObject<Item> COLD_FRAME_ITEM = ITEMS.register("cold_frame", () -> new BlockItem(COLD_FRAME.get(), new Item.Properties().group(EndRemastered.TAB)));
    public static final RegistryObject<Item> CORRUPTED_FRAME_ITEM = ITEMS.register("corrupted_frame", () -> new BlockItem(CORRUPTED_FRAME.get(), new Item.Properties().group(EndRemastered.TAB)));
    public static final RegistryObject<Item> MAGICAL_FRAME_ITEM = ITEMS.register("magical_frame", () -> new BlockItem(MAGICAL_FRAME.get(), new Item.Properties().group(EndRemastered.TAB)));
    public static final RegistryObject<Item> BLACK_FRAME_ITEM = ITEMS.register("black_frame", () -> new BlockItem(BLACK_FRAME.get(), new Item.Properties().group(EndRemastered.TAB)));
    public static final RegistryObject<Item> LOST_FRAME_ITEM = ITEMS.register("lost_frame", () -> new BlockItem(LOST_FRAME.get(), new Item.Properties().group(EndRemastered.TAB)));
    public static final RegistryObject<Item> WITHER_FRAME_ITEM = ITEMS.register("wither_frame", () -> new BlockItem(WITHER_FRAME.get(), new Item.Properties().group(EndRemastered.TAB)));
    public static final RegistryObject<Item> END_CRYSTAL_FRAME_ITEM = ITEMS.register("end_crystal_frame", () -> new BlockItem(END_CRYSTAL_FRAME.get(), new Item.Properties().group(EndRemastered.TAB)));
    public static final RegistryObject<Item> GUARDIAN_FRAME_ITEM = ITEMS.register("guardian_frame", () -> new BlockItem(GUARDIAN_FRAME.get(), new Item.Properties().group(EndRemastered.TAB)));

    public static final RegistryObject<Item> END_CRYSTAL_ORE_ITEM = ITEMS.register("end_crystal_ore", () -> new BlockItem(END_CRYSTAL_ORE.get(), new Item.Properties().group(EndRemastered.TAB)));

    //Biomes

}
