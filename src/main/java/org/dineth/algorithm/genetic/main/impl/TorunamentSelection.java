/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dineth.algorithm.genetic.main.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.dineth.algorithm.genetic.main.abst.Chromosome;
import org.dineth.algorithm.genetic.main.abst.Population;
import org.dineth.algorithm.genetic.main.abst.Selector;

/**
 *
 * @author dewmalpc
 */
public class TorunamentSelection<T extends Chromosome> implements Selector<T> {

    private final int TOURNAMENT_SIZE;
    private static final Random rand = new Random(System.currentTimeMillis());

    public TorunamentSelection(int TOURNAMENT_SIZE) {
        this.TOURNAMENT_SIZE = TOURNAMENT_SIZE;
    }
    
    

    public List<T> selectParent(Population<T> population, int numOfParents) {

        List<T> parents = new ArrayList<T>();

        // Randomly select two parents via tournament selection.
        for (int i = 0; i < numOfParents; i++) {
            parents.add(population.get(rand.nextInt(population.size())));
            for (int j = 0; j < TOURNAMENT_SIZE; j++) {
                int idx = rand.nextInt(population.size());
                if (population.get(idx).compareTo(parents.get(i)) > 0) {
                    parents.add(population.get(idx));
                }
            }
        }


        return parents;
    }
}
