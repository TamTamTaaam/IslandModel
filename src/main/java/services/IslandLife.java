package services;

import dataAnimals.Animal;
import dataAnimals.IslandObject;
import island.Coordinate;
import lombok.SneakyThrows;
import services.creatingField.CreatingStartingFieldService;
import services.forLife.LifeAnimalService;
import services.helper.ChoiceAnimalService;
import services.incessant.GrowingPlantsService;
import services.helper.SelectionOnlyAnimalsService;
import services.incessant.StarvationService;
import services.json.WriterFileService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

import static services.IslandLibrary.ISLAND_PARAMETERS;

public class IslandLife {
    private final CheckDataService checkDataService;
    private final StarvationService starvationService;
    private final GrowingPlantsService growingPlantsService;
    public ConcurrentHashMap<Coordinate, List<IslandObject>> ISLAND;
    private final WriterFileService writerFileService;

    public IslandLife() {
        this.checkDataService = new CheckDataService();
        this.ISLAND = new CreatingStartingFieldService().ISLAND;
        this.starvationService = new StarvationService();
        this.growingPlantsService = new GrowingPlantsService();
        this.writerFileService = new WriterFileService();
    }

    @SneakyThrows
    public void life() {
        boolean checkedCharacteristics = checkDataService.CheckCharacteristics();
        if (checkedCharacteristics) {
            ScheduledExecutorService executorForPeriodicActions = Executors.newScheduledThreadPool(1);
            executorForPeriodicActions.scheduleWithFixedDelay(() -> {
                try {
                    periodicActions();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, 0, ISLAND_PARAMETERS.getTactTime(), TimeUnit.SECONDS);

            ExecutorService executorForLifeAnimals = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()-1);
            executorForLifeAnimals.execute(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    forLifeActions();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt(); // Восстанавливаем статус прерывания
                    }
                }
            });

            Thread.sleep(50000);
            executorForPeriodicActions.shutdown();
            executorForLifeAnimals.shutdownNow();

            if (!executorForPeriodicActions.awaitTermination(60, TimeUnit.SECONDS)) {
                executorForPeriodicActions.shutdownNow();
            }
            if (!executorForLifeAnimals.awaitTermination(60, TimeUnit.SECONDS)) {
                executorForLifeAnimals.shutdownNow();
            }
        }

    }

    private void periodicActions() throws InterruptedException {
        writerFileService.writeFile(ISLAND);
        for (Map.Entry<Coordinate, List<IslandObject>> map : ISLAND.entrySet()) {
            starvationService.starvation(map.getValue());
            growingPlantsService.growingPlants(map.getValue());
        }
        writerFileService.writeFile(ISLAND);
        System.out.println("Состояние острова записано в файл.");
    }

    private void forLifeActions() {
        ChoiceAnimalService choiceAnimalService = new ChoiceAnimalService();
        SelectionOnlyAnimalsService selectionOnlyAnimalsService = new SelectionOnlyAnimalsService();
        for (Map.Entry<Coordinate, List<IslandObject>> map : ISLAND.entrySet()) {
            List<Animal> animals = selectionOnlyAnimalsService.selectionAnimals(map.getValue());
            if (!animals.isEmpty()) {
                Animal animal = choiceAnimalService.choiceAnimal(animals);
                LifeAnimalService lifeAnimalService = new LifeAnimalService();
                lifeAnimalService.lifeAnimals(map.getValue(), animal, map.getKey());
            }
        }
    }
}



