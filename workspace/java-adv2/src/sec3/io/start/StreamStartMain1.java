package sec3.io.start;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamStartMain1  {
    public static void main(String[] args) throws IOException {
        File file = new File("temp");

        if(!file.exists()){
            file.mkdir();
        }

        FileOutputStream fos = new FileOutputStream("temp/hello.dat");
        fos.write(65);
        fos.write(66);
        fos.write(67);
        fos.close();

        FileInputStream fis = new FileInputStream("temp/hello.dat");

        int data;
        while((data = fis.read()) != -1){
            System.out.println(data);
        }
        fis.close();

    }
}
