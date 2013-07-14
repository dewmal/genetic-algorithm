/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dineth.algorithm.genetic.main.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.dineth.algorithm.genetic.main.abst.impl.AbstractChromosome;

/**
 *
 * @author dewmalpc
 */
public final class MaxOneChromosome extends AbstractChromosome<String, MaxOneChromosome> {

    //Randomizer
    private static final Random rand = new Random();
    //Termination condition
    public static final char[] GOAL = "1111111111111111111111".toCharArray();

    public MaxOneChromosome(String gene) {
        super(gene);
    }

    public List<MaxOneChromosome> doCrossover(MaxOneChromosome mateChromosome) {
        List<MaxOneChromosome> childrens = new ArrayList<MaxOneChromosome>();
        // Convert the genes to arrays to make thing easier.
        char[] arr1 = gene.toCharArray();
        char[] arr2 = mateChromosome.gene.toCharArray();

        // Select a random pivot point for the mating
        int pivot = rand.nextInt(arr1.length);

        // Provide a container for the child gene data
        char[] child1 = new char[gene.length()];
        char[] child2 = new char[gene.length()];

        // Copy the data from each gene to the first child.
        System.arraycopy(arr1, 0, child1, 0, pivot);
        System.arraycopy(arr2, pivot, child1, pivot, (child1.length - pivot));

        // Repeat for the second child, but in reverse order.
        System.arraycopy(arr2, 0, child2, 0, pivot);
        System.arraycopy(arr1, pivot, child2, pivot, (child2.length - pivot));



        childrens.add(new MaxOneChromosome(new String(child1)));
        childrens.add(new MaxOneChromosome(new String(child2)));

        return childrens;


    }

    public int getFitness() {

        //reset fitness

        fitness = 0;

        //recalculate fitness
        for (char c : getGenes().toCharArray()) {

            fitness += Integer.parseInt(c + "");

        }

        return fitness;
    }

    public MaxOneChromosome doMutate() {
        char[] arr = gene.toCharArray();
        int idx = rand.nextInt(arr.length);
        int delta = rand.nextInt(2);
        arr[idx] = (delta + "").toCharArray()[0];

        return new MaxOneChromosome(new String(arr));
    }

    public static MaxOneChromosome randomChromosome() {
        char[] arr = new char[GOAL.length];
        for (int i = 0; i < arr.length; i++) {
            int delta = rand.nextInt(2);
            arr[i] = (delta + "").toCharArray()[0];

        }

        return new MaxOneChromosome(new String(arr));
    }
}
