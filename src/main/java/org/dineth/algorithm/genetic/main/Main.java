/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dineth.algorithm.genetic.main;

import org.dineth.algorithm.genetic.main.abst.Chromosome;
import org.dineth.algorithm.genetic.main.impl.MaxOneChromosome;
import org.dineth.algorithm.genetic.main.impl.MaxOnePopulation;

/**
 *
 * @author dewmalpc
 */
public class Main {

    private static MaxOnePopulation MOP;

    public static void main(String[] args) {

        // The size of the simulation population
        final int populationSize = 1000;

        // The maximum number of generations for the simulation.
        final int maxGenerations = 16384;

        // The probability of crossover for any member of the population,
        // where 0.0 <= crossoverRatio <= 1.0
        final float crossoverRatio = 0.95f;

        // The portion of the population that will be retained without change
        // between evolutions, where 0.0 <= elitismRatio < 1.0
        final float elitismRatio = 0.05f;

        // The probability of mutation for any member of the population,
        // where 0.0 <= mutationRatio <= 1.0
        final float mutationRatio = 0.5f;

        // Get the current run time.  Not very accurate, but useful for
        // some simple reporting.
        long startTime = System.currentTimeMillis();

        MOP = new MaxOnePopulation(elitismRatio, mutationRatio, crossoverRatio, populationSize);

        System.out.println(MOP.toString());


        int i = 0;
        Chromosome best = MOP.getBestone();

        while ((i++ <= maxGenerations) && (best.getFitness() != MaxOneChromosome.GOAL.length)) {
            System.out.println("Generation " + i + ": " + best.getGenes() + " Fittness " + best.getFitness());
            MOP.selectNextgenaration();
            best = MOP.getBestone();
        }

        // Get the end time for the simulation.
        long endTime = System.currentTimeMillis();

        // Print out some information to the console.
        System.out.println("Generation " + i + ": " + best.getGenes() + "Fittness " + best.getFitness());
        System.out.println("Total execution time: " + (endTime - startTime)
                + "ms");
    }
}
