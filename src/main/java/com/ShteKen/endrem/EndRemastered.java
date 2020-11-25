package com.ShteKen.endrem;


import com.ShteKen.endrem.util.RegistryHandler;
import com.ShteKen.endrem.world.gen.OreSpawnHandler;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.FlatGenerationSettings;
import net.minecraft.world.gen.feature.Feature;
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
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.apache.logging.log4j.Level;
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

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addGenericListener(Structure.class, this::onRegisterStructures);

        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        forgeBus.addListener(EventPriority.NORMAL, this::addDimensionalSpacing);

        forgeBus.addListener(EventPriority.HIGH, this::biomeModification);

        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        RegistryHandler.init();

        // Register ourselves for server and other game events we are interested in
      //  MinecraftForge.EVENT_BUS.register(this);
    }

    public void onRegisterStructures(final RegistryEvent.Register<Structure<?>> event) {
        STStructure.registerStructure(event);
        STConfiguredStructures.registerConfiguredStructures();

    }
    public void biomeModification(final BiomeLoadingEvent event) {

        event.getGeneration().getStructures().add(() -> STConfiguredStructures.CONFIGURED_END_CASTLE);
    }

    public void addDimensionalSpacing(final WorldEvent.Load event) {

        if(event.getWorld() instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld)event.getWorld();

            if(serverWorld.getChunkProvider().getChunkGenerator() instanceof FlatChunkGenerator &&
            serverWorld.getDimensionKey().equals(World.OVERWORLD)) {
                return;
            }
            Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkProvider().generator.func_235957_b_().func_236195_a_());
            tempMap.put(STStructure.END_CASTLE, DimensionStructuresSettings.field_236191_b_.get(STStructure.END_CASTLE));
            serverWorld.getChunkProvider().generator.func_235957_b_().field_236193_d_ = tempMap;
        }
    }

    public static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, T entry, String registryKey) {
        entry.setRegistryName(new ResourceLocation(EndRemastered.MOD_ID, registryKey));
        registry.register(entry);
        return entry;
    }



    private void setup(final FMLCommonSetupEvent event) {
        OreSpawnHandler.registerOres();
        }

    public static final ItemGroup TAB = new ItemGroup("endremTab") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.POWERED_CORE.get());

        }



    };

}
