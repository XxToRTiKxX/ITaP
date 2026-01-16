import java.io.*;
import java.lang.reflect.Method;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;

public class DataManager {
    private List<String> data = new ArrayList<>();
    private final List<Method> processors = new ArrayList<>();
    private final List<Object> processorObjects = new ArrayList<>();
    public void registerDataProcessor(Object processor) {
        for (Method method : processor.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(DataProcessor.class)) {
                processors.add(method);
                processorObjects.add(processor);
            }
        }
    }
    public void loadData(String source) throws IOException {
        data = Files.readAllLines(Paths.get(source));
    }
    @SuppressWarnings("unchecked")
    public void processData() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (int i = 0; i < processors.size(); i++) {
            Method method = processors.get(i);
            Object obj = processorObjects.get(i);
            Future<List<String>> future = executor.submit(() ->
                (List<String>) method.invoke(obj, data)
            );
            data = future.get();
        }
        executor.shutdown();
    }
    public void saveData(String destination) throws IOException {
        Files.write(Paths.get(destination), data);
    }
}
