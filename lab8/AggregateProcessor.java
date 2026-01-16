import java.util.List;

public class AggregateProcessor {
    @DataProcessor
    public List<String> aggregate(List<String> data) {
        return List.of("COUNT = " + data.size());
    }
}
