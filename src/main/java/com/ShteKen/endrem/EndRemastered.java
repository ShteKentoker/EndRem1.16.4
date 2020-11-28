package com.ShteKen.endrem;


import com.ShteKen.endrem.util.RegistryHandler;
import com.ShteKen.endrem.world.gen.OreSpawnHandler;
import com.ShteKen.endrem.world.structures.EndCastle;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;


// The value here should match an entry in the META-INF/mods.toml file
@Mod("endrem")
public class EndRemastered {
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "endrem";

    public EndRemastered() {

        // Register the setup method for modloading
       // FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        RegistryHandler.init();
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
//////////////////////////////////////////////////////////////////////////////////////

        // For registering and other initialization stuff.
//        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
//        modEventBus.addGenericListener(Structure.class, this::onRegisterStructures);


        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        STStructures.DEFERRED_REGISTRY_STRUCTURE.register(modEventBus);
        modEventBus.addListener(this::setup);

        // For events that happen after initialization. This is probably going to be use a lot.
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        forgeBus.addListener(EventPriority.NORMAL, this::addDimensionalSpacing);

        // The comments for BiomeLoadingEvent and StructureSpawnListGatherEvent says to do HIGH for additions.
        forgeBus.addListener(EventPriority.HIGH, this::biomeModification);
    }
    public void onRegisterStructures(final RegistryEvent.Register<Structure<?>> event) {

    }

    public void biomeModification(final BiomeLoadingEvent event) {
        // Add structure to all biomes

        event.getGeneration().getStructures().add(() -> STConfiguredStructures.CONFIGURED_END_CASTLE);
    }

    public void addDimensionalSpacing(final WorldEvent.Load event) {
        if(event.getWorld() instanceof ServerWorld){
            ServerWorld serverWorld = (ServerWorld)event.getWorld();

            // Prevent spawning our structure in Vanilla's superflat world

            if(serverWorld.getChunkProvider().getChunkGenerator() instanceof FlatChunkGenerator &&
                    serverWorld.getDimensionKey().equals(World.OVERWORLD)){
                return;
            }

            Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkProvider().generator.func_235957_b_().func_236195_a_());
            tempMap.put(STStructures.END_CASTLE.get(), DimensionStructuresSettings.field_236191_b_.get(STStructures.END_CASTLE));
            serverWorld.getChunkProvider().generator.func_235957_b_().field_236193_d_ = tempMap;

        }
    }

    public static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, T entry, String registryKey) {
        entry.setRegistryName(new ResourceLocation(EndRemastered.MOD_ID, registryKey));
        registry.register(entry);
        return entry;
    }

    /////////////////////////////////////////////////////////////////////////////////////

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            STStructures.setupStructures();
            STStructures.registerAllPieces();
            STConfiguredStructures.registerConfiguredStructures();
            STStructures.init();
        });

        OreSpawnHandler.registerOres();
    }

    public static final ItemGroup TAB = new ItemGroup("endremTab") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.POWERED_CORE.get());

        }



    };

}
