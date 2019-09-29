package multitreading;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.concurrent.Callable;

public class FileReaderThread implements Callable<List<String[]>> {

    String fileName;
    CSVReader csvReader;

    public FileReaderThread(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<String[]> call() throws Exception {
        try {
            csvReader = new CSVReader(new FileReader(this.fileName), ',');
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return csvReader.readAll();
    }
}
