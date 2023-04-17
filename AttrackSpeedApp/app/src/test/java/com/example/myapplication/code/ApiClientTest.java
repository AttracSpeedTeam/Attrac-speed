package com.example.myapplication.code;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ApiClientTest {

    @Test
    public void testRecupererDonneesAttraction() throws IOException {

        //Recuperation de données
        String nom_attraction = "Pirates of the Caribbean";
        String expectedResponse = "[\"45\",\"09:30\",\"23:00\",\"1\"]";

        //Appel de la fonction
        String actualResponse = ApiClient.RecupererDonneesAttraction(nom_attraction);

        //Test comparaison
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testRecupererEmplacement() throws IOException {

        //Recuperation de données
        String nom_attraction = "Pirates of the Caribbean";
        String expectedResponse = "48.87350796980345, 2.773361923733266";

        //Appel de la fonction
        String actualResponse = ApiClient.RecupererEmplacement(nom_attraction);

        //Test comparaison
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testRecupererListeAttraction() throws IOException {

        //Recuperation de données
        List<String> expectedAttractionsList = Arrays.asList("[\"Pirates of the Caribbean\"]");

        //Appel de la fonction
        List<String> attractionsList = ApiClient.RecupererListeAttraction();

        //Test comparaison
        assertEquals(expectedAttractionsList, attractionsList);
    }
}

