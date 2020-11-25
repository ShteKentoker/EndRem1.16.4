package com.ShteKen.endrem.util;

import com.ShteKen.endrem.EndRemastered;
import com.ShteKen.endrem.blocks.*;
import com.ShteKen.endrem.items.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class RegistryHandler {

    //where every blocks and items are registered and might register the biomes here later

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EndRemastered.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EndRemastered.MOD_ID);
   // public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, EndRemastered.MOD_ID);

    public static void init() {

        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

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
    public static final RegistryObject<Item> END_CRYSTAL = ITEMS.register("end_crystal", ItemBase::new);

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

    public static final RegistryObject<Block> END_CRYSTAL_BLOCK = BLOCKS.register("end_crystal_block", () -> new OreBlockBase(Block.Properties.from(Blocks.ANCIENT_DEBRIS)));

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

    public static final RegistryObject<Item> END_CRYSTAL_BLOCK_ITEM = ITEMS.register("end_crystal_block", () -> new BlockItem(END_CRYSTAL_BLOCK.get(), new Item.Properties().group(EndRemastered.TAB)));

    //Biomes

   // public static final RegistryObject<Biome> END_LAND = BIOMES.register("end_land", EndLandBiome::new);


}
