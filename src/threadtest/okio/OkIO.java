package threadtest.okio;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;

import okio.BufferedSource;
import okio.Okio;
import okio.Source;

public class OkIO {
    public static void main(String[]args) {
        File file = new File("C:/Users/temp/Desktop/unity.txt");
        if (!file.exists()){
           System.out.println("文件不存在");
            return;
        }
        Source source=null;
        BufferedSource bufferedSource=null;
        try {
            source=Okio.source(file);
            bufferedSource=Okio.buffer(source);
            String str=bufferedSource.readString(Charset.forName("utf-8"));
            System.out.println(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
