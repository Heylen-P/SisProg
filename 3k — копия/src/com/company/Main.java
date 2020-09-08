package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        String str = new String();
        ArrayList<String> wrd = new ArrayList<String>();

        try(FileReader reader = new FileReader("Fitzgerald Francis. The Great Gatsby - BooksCafe.Net.txt"))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){
                if(Character.isLetter((char)c)){
                    str += String.valueOf((char)c);
                }
                else{
                    wrd.add(str);
                    str = "";
                }

            }
            if (str.length() > 0)
                wrd.add(str);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        System.out.println(wrd);

        ArrayList<String> stt = new ArrayList<String>();
        for (int i = 0; i < wrd.size(); i++){
             char[] Arr = wrd.get(i).toCharArray();
            for ( int j = 1; j < Arr.length; j++){
                if(Arr[j] != 'a' && Arr[j] != 'o'&& Arr[j] != 'i' && Arr[j] != 'e' && Arr[j] != 'u') {
                    if ((Arr[j] == Arr[j - 1]) && (!stt.contains(wrd.get(i)))) {
                        stt.add(wrd.get(i));
                        System.out.println(wrd.get(i));
                        break;
                    }
                }
            }
        }
    }
}
