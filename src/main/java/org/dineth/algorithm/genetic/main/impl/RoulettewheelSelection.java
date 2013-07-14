/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dineth.algorithm.genetic.main.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.dineth.algorithm.genetic.main.abst.Chromosome;
import org.dineth.algorithm.genetic.main.abst.Population;
import org.dineth.algorithm.genetic.main.abst.Selector;

/**
 *
 * @author dewmalpc
 */
public class RoulettewheelSelection<T extends Chromosome> implements Selector<T> {

    private static final Random rand = new Random(System.currentTimeMillis());

    public List<T> selectParent(Population<T> population, int numOfParent) {
        List<T> list = new ArrayList<T>();
        List<T> selectedOnes = new ArrayList<T>();

        int maxSelect = 360;
        int totalfittness = 0;
        int nextParent = 0;
        for (int i = nextParent; i < maxSelect;) {
            int parentid = rand.nextInt(population.size());
            final T selectedParent = population.get(parentid);
            final int fitness = selectedParent.getFitness();

            totalfittness += fitness;

            nextParent = totalfittness;



            while (i < nextParent) {
                selectedOnes.add(selectedParent);
                i++;
            }


           
        }




        while (list.size() < numOfParent) {

            int selectionID = 0;

            selectionID = rand.nextInt(360);
            final T selection = selectedOnes.get(selectionID);



            if (selection != null) {
                list.add(selection);
            }


        }


        return list;
    }
}
