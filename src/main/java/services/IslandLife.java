package services;

import dataAnimals.Animal;
import dataAnimals.IslandObject;
import island.Coordinate;
import services.creatingField.CreatingStartingFieldService;
import services.incessant.GrowingPlantsService;
import services.incessant.StarvationService;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static services.IslandLibrary.MAP_ALL_ANIMALS_IN_PROGRAM;

public class IslandLife {
    private final CheckDataService checkDataService;
    private final StarvationService starvationService;
    private final GrowingPlantsService growingPlantsService;

    public IslandLife() {
        this.checkDataService = new CheckDataService();
        this.starvationService = new StarvationService();
        this.growingPlantsService = new GrowingPlantsService();
    }

    public void life() {
        boolean checkedCharacteristics = checkDataService.CheckCharacteristics();
        if(checkedCharacteristics) {
            CreatingStartingFieldService creatingStartingFieldService = new CreatingStartingFieldService();
            ConcurrentHashMap<Coordinate, List<IslandObject>> island = creatingStartingFieldService.ISLAND;
            for (Map.Entry<Coordinate, List<IslandObject>> map : island.entrySet()) {
                starvationService.starvation(map.getValue());
                growingPlantsService.growingPlants(map.getValue());
            }

        }
    }
}
