package main.java.adventofcode2018.tag2;

import java.util.List;

public class StringUnterschiedAgent
{
	public String spuereUnterschiedlicheCharacterAuf(List<String> input) 
	{
        for (int i = 0; i < input.size() - 1; i++) 
        {
            for (int j = 1; j < input.size(); j++) 
            {
                int dist = EditDistance.editDistance(input.get(i), input.get(j)); //EditDistance musste ich aus dem Package rauskopieren weil der import nicht ging?!
                if (dist == 1) 
                {
                    return entferneUnterschiedlicheCharacter(input.get(i), input.get(j));
                }
            }
        }
        return "";
    }

    private String entferneUnterschiedlicheCharacter(String folgenderString, String anführenderString) 
    {
        String result = "";
        for (int i = 0; i < anführenderString.length(); i++) 
        {
            if (anführenderString.charAt(i) == folgenderString.charAt(i)) 
            {
                result += anführenderString.charAt(i);
            }
        }
        return result;
    }
}
