package by.epamtc.task_1;

import by.epamtc.task_1.exception.NullStringException;
import by.epamtc.task_1.exception.WrongFileException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StringInputService {
    public static String readTextFromStdin(){
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    public static String readTextFromFile(String filename) throws WrongFileException, NullStringException {
        if(filename == null)
            throw new NullStringException("Filename must not be null!");


        File file = new File(filename);

        try(Scanner scanner = new Scanner(file)){
            return scanner.nextLine();
        } catch (FileNotFoundException e){
            throw new WrongFileException("Can't read file");
        }
    }
}
