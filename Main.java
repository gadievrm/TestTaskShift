package TestTask;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// class FileProcessor{
//     FileReader reader = null;

//     FileProcessor(String Path) {
//         try {
//             this.reader = new FileReader(Path);
//         } catch (FileNotFoundException e) {
//             // TODO Auto-generated catch block
//             System.out.println(e);
//         }
//     }
    
// }

/*TODO:
    в идеале надо не записывать все в один массив да и не хранить содержимое файлов целиков в памяти
    нужно все обрабатывать сходу например просто создать массив в него вкладывать все выходные данные сразу при обработке входного файла
    и потом в конечной итерации для конкретного входного файла записывать что лежит в массиве (хотя по факту это ваще строка должна быть)
    внутрь выходного файла
*/
public class Main {
    public static  void  main(String[] args) throws IOException{
        FileReader fReader = null;

        //так как можно определить сколько аргументов вписано в кмд то можно в самой программе узнать
        //размер массивов для хранения путей файлов, для хранения содержимого файлов и тд и тп 
        //поэтому можно пока что обойтись переменными с заранее известными путями +
        //массивами с фиксированной пока что длинной)
        String in1Path = "TestTask/Input/in1.txt";
        String in2Path = "TestTask/Input/in2.txt";
        String[] filePathArray = {in1Path, in2Path};//массив с путями файлов

        String[] wholeInput = new String[2];//массив с содержимым файлов 
        int iterNum = 0;
        //запись файлов в массив
        for (String string : filePathArray) {
            
            int tempCode = 0;
            System.out.println(iterNum);
            String tempString = "";
            try {
                fReader = new FileReader(string);
                
                while ((tempCode = fReader.read()) != -1){
                    // System.out.println(tempCode);
                    tempString += (char) tempCode; 

                }

            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            wholeInput[iterNum] = tempString;
            iterNum++;
        }

        System.out.println(wholeInput[0]);

        fReader.close();
    }
}

