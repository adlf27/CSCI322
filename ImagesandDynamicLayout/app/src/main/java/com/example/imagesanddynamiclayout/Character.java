/*
class that holds the characters description and
charactes id.
Constructor and two getter methods
 */

package com.example.imagesanddynamiclayout;

public class Character
{
    private static String characterDescription;
    private static int characterID;
    //character constructor

    public Character(String characterDescription, int characterID)
    {
        this.characterDescription = characterDescription;
        this.characterID = characterID;

    }
//method to ge the character description
    public static String getCharacterDescription()
    {
        return characterDescription;
    }

    public void setCharacterDescription(String characterDescription)
    {
        this.characterDescription = characterDescription;
    }
//method to get the characted Id
    public static int getCharacterID()
    {
        return characterID;
    }

    public void setCharacterID(int characterID)
    {
        this.characterID = characterID;
    }
}
