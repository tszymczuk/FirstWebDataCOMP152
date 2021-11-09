package bsu.comp152;

import java.util.ArrayList;

public class UniversityDataType {

    //Identifying what each piece of the website is
    String alpha_two_code;
    ArrayList<String> web_pages;
    String name;
    String country;
    ArrayList<String> domains;

    //Creating a toString to display the data nicely
    @Override
    public String toString(){
        return name + " is in " + country + " you can find it on the web here: " + web_pages;
    }
}
