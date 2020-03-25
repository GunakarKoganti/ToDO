package com.abc.todoapp;

import android.content.Context;

        import java.io.FileInputStream;
        import java.io.FileNotFoundException;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.io.ObjectInputStream;
        import java.io.ObjectOutputStream;
        import java.util.ArrayList;

public class Helper {


    public static final String FILENAME = "info.dat";


    public static void writeData(ArrayList<String> items, Context context){

        try {
            FileOutputStream FOS = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            ObjectOutputStream OOS = new ObjectOutputStream(FOS);
            OOS.writeObject(items);
            OOS.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static ArrayList<String> readData(Context context){
        ArrayList<String> itemsList = null;
        try {
            FileInputStream FIS = context.openFileInput(FILENAME);
            ObjectInputStream OIS = new ObjectInputStream(FIS);
            itemsList = (ArrayList<String>) OIS.readObject();
        } catch (FileNotFoundException e) {

            itemsList = new ArrayList<>();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return itemsList;

    }



}
