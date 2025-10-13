package com.example.bleblebleblublubl;

import java.util.ArrayList;

public class PlanetaController {

    PlanetaDAO planetaDAO;

    public PlanetaController(){
        planetaDAO = new PlanetaDAO();
    }
    public void addPlaneta (Planeta planeta){

    }

    public ArrayList<Planeta> getPlaneta(){
        return planetaDAO.getPlanetas();
    }

    public ArrayList<String> getNomePlaneta(){
        ArrayList<String> nomes = new ArrayList<String>();
        for (Planeta planeta : planetaDAO.getPlanetas()){
            nomes.add(planeta.nome);
        }
        return nomes;
    }
}
