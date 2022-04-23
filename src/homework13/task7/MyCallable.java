package homework13.task7;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<List<File>> {
    private final String[] words =
            {"привет ", "я ", "робот ", "компьютер ", "слон ", "кот ", "ноутбук ", "человек ", "пицца ", "сок "};

    @Override
    public List<File> call() throws Exception {
        List<File> fileList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            File file = new File("./src/homework13/task7/file_" + Thread.currentThread().getName() + "_" + i);
            FileWriter fileWriter = new FileWriter("./src/homework13/task7/file_" + Thread.currentThread().getName() + "_" + i);
            for (int n = 0; n < 10; n++) {
                fileWriter.write(words[(int) (Math.random() * 10)]);
            }
            System.out.println(Thread.currentThread().getName() + ": выполняется создание фаила : " + file.getName());
            fileList.add(file);
            fileWriter.close();
        }
        Thread.sleep((int) (Math.random() * 3 + 1) * 1000);
        return fileList;
    }
}
