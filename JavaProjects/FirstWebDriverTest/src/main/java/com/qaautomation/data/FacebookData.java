package com.qaautomation.data;

import org.testng.annotations.DataProvider;

/**
 * Created by NewMan on 04.11.2015.
 */
public class FacebookData {

    // Argument for tests : URL and title of Page
    @DataProvider(name= "pages")
    public static Object [][] pages(){
        return new Object[][]{
                {"http://www.facebook.com","Facebook - Log In or Sign Up"},
                {"http://www.google.com", "Google"},
                {"http://www.yahoo.com", "Yahoo"}
        };
    }

    @DataProvider(name= "login")
    public static Object [][] login(){
        return new Object[][]{
                {"andyyarish@gmail.com","Sheva789"},
                {"coolandriy@gmail.com", "Sheva789"},
                {"coolandriy@gmail.com", " "}


        };
    }



}
