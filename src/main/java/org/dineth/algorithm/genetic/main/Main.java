/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dineth.algorithm.genetic.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import org.dineth.algorithm.genetic.main.abst.Chromosome;
import org.dineth.algorithm.genetic.main.impl.MaxOneChromosome;
import org.dineth.algorithm.genetic.main.impl.MaxOnePopulation;

/**
 *
 * @author dewmalpc
 */
public class Main {

    private static MaxOnePopulation MOP;
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {



        for (int k = 0; k < 50; k++) {



            // The size of the simulation population
            final int populationSize = RANDOM.nextInt(2000
                    );

            // The maximum number of generations for the simulation.
            final int maxGenerations = 16384;

            // The probability of crossover for any member of the population,
            // where 0.0 <= crossoverRatio <= 1.0
            final float crossoverRatio = RANDOM.nextInt(50) / 100f;

            // The portion of the population that will be retained without change
            // between evolutions, where 0.0 <= elitismRatio < 1.0
            final float elitismRatio = RANDOM.nextInt(20) / 100f;

            // The probability of mutation for any member of the population,
            // where 0.0 <= mutationRatio <= 1.0
            final float mutationRatio = RANDOM.nextInt(40) / 100f;

            // Get the current run time.  Not very accurate, but useful for
            // some simple reporting.
            long startTime = System.currentTimeMillis();




            MOP = new MaxOnePopulation(elitismRatio, mutationRatio, crossoverRatio, populationSize);

            System.out.println(MOP.toString());


            int i = 0;
            Chromosome best = MOP.getBestone();

            while ((i++ <= maxGenerations) && (best.getFitness() != MaxOneChromosome.GOAL.length)) {
                //  System.out.println("Generation " + i + ": " + best.getGenes() + " Fittness " + best.getFitness());
                MOP.selectNextgenaration();
                best = MOP.getBestone();
            }

            // Get the end time for the simulation.
            long endTime = System.currentTimeMillis();

            // Print out some information to the console.
            System.out.println("Generation " + i + ": " + best.getGenes() + "Fittness " + best.getFitness());
            System.out.println("Total execution time: " + (endTime - startTime)
                    + "ms");




            BufferedWriter writer = null;
            try {
                //create a temporary file

                File logFile = new File("result.txt");


                writer = new BufferedWriter(new FileWriter(logFile, true));
                writer.newLine();
                writer.write(populationSize + "\t" + elitismRatio + "\t" + crossoverRatio + "\t" + mutationRatio + "\t" + (endTime - startTime) + "ms" + "\t" + i + "\t" + best.getFitness() + "\t");
                writer.flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    // Close the writer regardless of what happens...
                    writer.close();
                } catch (Exception e) {
                }
            }

        }
    }
}
