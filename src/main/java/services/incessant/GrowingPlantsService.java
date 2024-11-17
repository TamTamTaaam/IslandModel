package services.incessant;

import dataAnimals.IslandObject;
import dataAnimals.Plant;

import java.util.List;

import static services.AnimalLibrary.PLANT;
public class GrowingPlantsService {
    public void growingPlants(List<IslandObject> island) {
        island.add(new Plant(PLANT.getWeight(), PLANT.getMaxAmount()));
    }
}
