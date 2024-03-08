package readers.property;

import readers.csv.CsvReader;

import javax.imageio.stream.ImageInputStreamImpl;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    Properties prop  = new Properties();
    String file;

    public static PropertyReader read(){
        return read("config");
    }

    public static PropertyReader read(String fileName){
        return new PropertyReader(fileName);
    }

    public PropertyReader(String fileName){
        try{
            file = "src/test/resources/datafiles/property/"+fileName+".properties";
            FileReader fileReader = new FileReader(file);
            prop.load(fileReader);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public String get(String key){
        return prop.getProperty(key);
    }


}
