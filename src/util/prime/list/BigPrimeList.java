package util.prime.list;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import net.lingala.zip4j.ZipFile;
import org.apache.commons.lang3.StringUtils;

public class BigPrimeList {

    private static BigPrimeList bigPrimeListSingleton = null;
    private List<Integer> list;

    public List<Integer> getList(){
        return list;
    }

    public static BigPrimeList getInstance(){
        if(bigPrimeListSingleton == null){
            bigPrimeListSingleton =  new BigPrimeList();
        }
        return  bigPrimeListSingleton;
    }

    private BigPrimeList(){
        load();
    }

    private void load(){
        System.out.println("Start Loading.....");

        try{

            File tempDir = Files.createTempDirectory("tempDir").toFile();
            String resourcePath = BigPrimeList.class.getResource("data/master.zip.001").getFile();

            try(ZipFile zipFile = new ZipFile(resourcePath)){

                zipFile.extractAll(tempDir.getPath());

                Arrays.stream(tempDir.listFiles()).filter(e -> e.getName().contains("master")).findFirst().ifPresent(masterFile -> {
                    list = readFromFile(masterFile);
                    masterFile.deleteOnExit();
                });

                tempDir.deleteOnExit();
            }

        }catch (IOException e){
            System.out.println(e);
        }

        System.out.println("Done with loading :-)");
    }

    private List<Integer> readFromFile(File masterFile) {

        List<Integer> list = new ArrayList<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(masterFile))){
            while (bufferedReader.ready()){
                list.addAll(Arrays.stream(bufferedReader.readLine().split(";")).filter(StringUtils::isNotBlank).map(Integer::valueOf).collect(Collectors.toList()));
            }
        }catch(IOException e){
            System.out.println(e);
        }

        return list;
    }
}
