package services;

import dataAnimals.Animal;
import dataAnimals.IslandObject;
import island.Coordinate;
import services.creatingField.CreatingStartingFieldService;
import services.forLife.LifeAnimalService;
import services.incessant.ChoiceAnimalService;
import services.incessant.GrowingPlantsService;
import services.incessant.SelectionOnlyAnimalsService;
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
    private ExecutorService executorService; //хз
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
           periodicActions();
           forLifeActions();
           lifeProcess();
        }

    }

    private void periodicActions() throws InterruptedException {
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
        Thread.sleep(50000);
        scheduledExecutorService.shutdown();
        if (!scheduledExecutorService.awaitTermination(60, TimeUnit.SECONDS)) {
            scheduledExecutorService.shutdownNow();
        }
    }
    private void forLifeActions() {

    }
    public CompletableFuture<Void> lifeProcess() {
        ChoiceAnimalService choiceAnimalService = new ChoiceAnimalService();
        SelectionOnlyAnimalsService selectionOnlyAnimalsService = new SelectionOnlyAnimalsService();

        return CompletableFuture.runAsync(() ->{
            for (Map.Entry<Coordinate, List<IslandObject>> map : island.entrySet()) {
                Coordinate before = map.getKey();
                Animal animal = choiceAnimalService.choiceAnimal(selectionOnlyAnimalsService.selectionAnimals(map.getValue()));
                LifeAnimalService lifeAnimalService = new LifeAnimalService();
                lifeAnimalService.lifeAnimals(map.getValue(), animal, map.getKey());
                //animal eat< repro< перемещаем
                // Coordinate after = animals.getNewCoordinate
                Coordinate after = new Coordinate(3,4);
                boolean add = island.get(after).add(animal);
                if(add==true) {
                    island.get(before).remove(animal);
                    System.out.println("Животное");
                }
            }
        });

    }
}
