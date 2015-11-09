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
                {"andyyarish@gmail.comm","Sheva789", "Incorrect Email"},
                {"coolandriy@rambler.ru", "Sheva789", null},
                {"","Sheva789", "Incorrect email or phone number"},


        };
    }



}
