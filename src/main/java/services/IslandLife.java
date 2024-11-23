package services;

import dataAnimals.Animal;
import dataAnimals.IslandObject;
import island.Coordinate;
import services.creatingField.CreatingStartingFieldService;
import services.incessant.GrowingPlantsService;
import services.incessant.StarvationService;
import services.json.WriterFileService;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.IntStream;

import static services.IslandLibrary.ISLAND_PARAMETERS;
import static services.IslandLibrary.MAP_ALL_ANIMALS_IN_PROGRAM;

public class IslandLife {
    private final CheckDataService checkDataService;
    private final StarvationService starvationService;
    private final GrowingPlantsService growingPlantsService;
    private ExecutorService executorService;
    private final CreatingStartingFieldService creatingStartingFieldService;
    public ConcurrentHashMap<Coordinate, List<IslandObject>> island;
    private WriterFileService writerFileService;

    public IslandLife() {
        this.checkDataService = new CheckDataService();
        this.executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        this.creatingStartingFieldService = new CreatingStartingFieldService();
        this.island = creatingStartingFieldService.ISLAND;
        this.starvationService = new StarvationService();
        this.growingPlantsService = new GrowingPlantsService();
        this.writerFileService = new WriterFileService();
    }

    public void life() throws InterruptedException {
        boolean checkedCharacteristics = checkDataService.CheckCharacteristics();
        if(checkedCharacteristics) {
            writerFileService.writeFile(island);
            ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
            scheduledExecutorService.scheduleWithFixedDelay(()-> {
                for (Map.Entry<Coordinate, List<IslandObject>> map : island.entrySet()) {
                    starvationService.starvation(map.getValue());
                    growingPlantsService.growingPlants(map.getValue());
                }
                writerFileService.writeFile(island);
                System.out.println("Состояние острова записано в файл.");
            }, 0, 5, TimeUnit.SECONDS);
            Thread.sleep(60000);
            scheduledExecutorService.shutdown();
            if (!scheduledExecutorService.awaitTermination(60, TimeUnit.SECONDS)) {
                scheduledExecutorService.shutdownNow();
            }
        }

    }
//    public void applyFilter() {
//
//    }
//    public CompletableFuture<Void> processLife() {
//        return CompletableFuture.runAsync(()-> {
//            for (Map.Entry<Coordinate, List<IslandObject>> map : island.entrySet()) {
//                //едят, разможаются, перемещаются
//
//            }
//        }, executorService);
//    }
}
