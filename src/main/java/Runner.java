
import lombok.SneakyThrows;
import services.IslandLife;


public class Runner {
    @SneakyThrows
    public static void main(String[] args)  {
        IslandLife islandLife = new IslandLife();
        islandLife.life();
    }
}
