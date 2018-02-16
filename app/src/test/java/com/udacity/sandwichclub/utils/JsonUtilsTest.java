package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JsonUtilsTest {

    private static final String json = "{  \n" +
            "   \"name\":{  \n" +
            "      \"mainName\":\"Ham and cheese sandwich\",\n" +
            "      \"alsoKnownAs\":[  \n" +
            "\n" +
            "      ]\n" +
            "   },\n" +
            "   \"placeOfOrigin\":\"\",\n" +
            "   \"description\":\"A ham and cheese sandwich is a common type of sandwich. It is made by putting cheese and sliced ham between two slices of bread. The bread is sometimes buttered and/or toasted. Vegetables like lettuce, tomato, onion or pickle slices can also be included. Various kinds of mustard and mayonnaise are also common.\",\n" +
            "   \"image\":\"https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Grilled_ham_and_cheese_014.JPG/800px-Grilled_ham_and_cheese_014.JPG\",\n" +
            "   \"ingredients\":[  \n" +
            "      \"Sliced bread\",\n" +
            "      \"Cheese\",\n" +
            "      \"Ham\"\n" +
            "   ]\n" +
            "}";

    @Before
    public void setUp() {
    }

    @Test
    public void parseSandwichJson() throws Exception {
        Sandwich actual = JsonUtils.parseSandwichJson(json);
        String expectedDescription = "A ham and cheese sandwich is a common type of sandwich. " +
                "It is made by putting cheese and sliced ham between two slices of bread. " +
                "The bread is sometimes buttered and/or toasted. Vegetables like lettuce, " +
                "tomato, onion or pickle slices can also be included. Various kinds of mustard " +
                "and mayonnaise are also common.";
        String expectedImage = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/" +
                "Grilled_ham_and_cheese_014.JPG/800px-Grilled_ham_and_cheese_014.JPG";

        assertNotNull(actual);
        assertEquals("Ham and cheese sandwich", actual.getMainName());
        assertEquals(0, actual.getAlsoKnownAs().size());
        assertEquals("", actual.getPlaceOfOrigin());
        assertEquals(expectedDescription, actual.getDescription());
        assertEquals(expectedImage, actual.getImage());
        assertEquals("Sliced bread", actual.getIngredients().get(0));
        assertEquals("Cheese", actual.getIngredients().get(1));
        assertEquals("Ham", actual.getIngredients().get(2));
    }

}