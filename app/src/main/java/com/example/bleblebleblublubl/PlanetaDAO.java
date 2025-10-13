package com.example.bleblebleblublubl;

import java.util.ArrayList;

public class PlanetaDAO {

    ArrayList<Planeta> arrayListPlaneta;

    public PlanetaDAO(){
        arrayListPlaneta= new ArrayList<Planeta>();
        arrayListPlaneta.add(new Planeta("Mercurio", R.drawable.mercury));
        arrayListPlaneta.add(new Planeta("Venus", R.drawable.venus));
        arrayListPlaneta.add(new Planeta("Terra", R.drawable.earth));
        arrayListPlaneta.add(new Planeta("Marte", R.drawable.mars));
        arrayListPlaneta.add(new Planeta("Jupiter", R.drawable.jupter));
        arrayListPlaneta.add(new Planeta("Saturno", R.drawable.saturn));
        arrayListPlaneta.add(new Planeta("Urano", R.drawable.uranus));
        arrayListPlaneta.add(new Planeta("Netuno", R.drawable.neptune));
    }

    public ArrayList<Planeta> getPlanetas(){
        return arrayListPlaneta;
    }
}
