package multitreading;

import au.com.bytecode.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class FileWriterMultiThred {

    String[] fileStores;
    String csvFileTarget;
    List<String[]> listPreWrite;
    int cores = Runtime.getRuntime().availableProcessors();

    ExecutorService executorService = newFixedThreadPool(cores * 2);
    CSVWriter csvWriter;


    public FileWriterMultiThred(String[] fileStores, String csvFileTarget) {
        this.fileStores = fileStores;
        this.csvFileTarget = csvFileTarget;
    }

    public void write() throws IOException {

        Arrays.stream(fileStores).map(fileName -> {
            try {
                return (apply(fileName));
            } catch (ExecutionException e) {
                e.printStackTrace();
                return null;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        }).forEach(x -> {
            if (x != null) {
                listPreWrite.addAll(x);
            }
        });
        Map<String, Integer> map = new HashMap<String, Integer>();
        try {
            csvWriter = new CSVWriter(new FileWriter(this.csvFileTarget));
            listPreWrite.stream()
                    .sorted((o1, o2) -> o2[4].compareTo(o1[4]))
                    .forEach(x -> {
                        if (map.size() > 999) {return;}
                        if (map.containsKey(x[0]) || map.get(x[0]) < 20) {
                            map.put(x[0], map.get(x[0]) + 1);
                            csvWriter.writeNext(x);
                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (csvWriter != null) {
                csvWriter.close();
            }
        }
    }

    private List<String[]> apply(String fileName) throws ExecutionException, InterruptedException {
        return executorService.submit(new FileReaderThread(fileName)).get();
    }
}
