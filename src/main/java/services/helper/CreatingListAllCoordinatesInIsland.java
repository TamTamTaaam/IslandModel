package services.helper;

import dataAnimals.IslandObject;
import island.Coordinate;
import services.creatingField.CreatingStartingFieldService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreatingListAllCoordinatesInIsland {
    public final List<Coordinate> coordinatesInIsland;
    private final CreatingStartingFieldService creatingStartingFieldService;


    public CreatingListAllCoordinatesInIsland() {
        this.creatingStartingFieldService = new CreatingStartingFieldService();
        this.coordinatesInIsland = getCoordinatesInIsland();
    }
    private List<Coordinate> getCoordinatesInIsland() {
        List<Coordinate> coordinates = new ArrayList<>();
        for (Map.Entry<Coordinate, List<IslandObject>> map : creatingStartingFieldService.ISLAND.entrySet()) {
            coordinates.add(map.getKey());
        }
        return coordinates;
    }
}
