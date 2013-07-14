/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dineth.algorithm.genetic.main.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.dineth.algorithm.genetic.main.abst.Population;
import org.dineth.algorithm.genetic.main.abst.Selector;
import org.dineth.algorithm.genetic.main.abst.impl.AbstractPopulation;

/**
 *
 * @author dewmalpc
 */
public class MaxOnePopulation extends AbstractPopulation<MaxOneChromosome, String> {

    private static final Random rand = new Random(System.currentTimeMillis());
    private final int populationsize;
    private final Selector<MaxOneChromosome> bestSelector;

    public MaxOnePopulation(float elitism, float mutation, float crossover, int size) {
        super(elitism, mutation, crossover);
        this.populationsize = size;


        for (int i = 0; i < this.populationsize; i++) {
            this.add(MaxOneChromosome.randomChromosome());
        }
        
         bestSelector = getBestSelector();
    }

    public void selectNextgenaration() {

       

        List<MaxOneChromosome> nextGen = new ArrayList<MaxOneChromosome>();

        // Copy over a portion of the population unchanged, based on
        // the elitism ratio.
        int idx = Math.round(this.size() * elitism);

        for (int i = 0; i < idx; i++) {

            nextGen.add(this.get(i));

        }


        while (idx < populationsize) {


            if (rand.nextFloat() <= crossover) {


                List<MaxOneChromosome> parents = bestSelector.selectParent(this, rand.nextInt(Math.round(populationsize * (crossover))));




                for (MaxOneChromosome parnet : parents) {
                    List<MaxOneChromosome> childrens = parnet.doCrossover(parents.get(rand.nextInt(parents.size())));



                    for (MaxOneChromosome child : childrens) {

                        if (rand.nextFloat() <= mutation) {
                            nextGen.add(child.doMutate());

                        } else {
                            nextGen.add(child);

                        }

                        idx++;
                    }

                    // Repeat for the second child, if there is room.


                }




            } else { // No crossover, so copy verbatium.
                if (rand.nextFloat() <= mutation) {
                    nextGen.add(this.get(idx));
                } else {
                    nextGen.add(this.get(idx));
                }

                idx++;
            }

        }


        this.removeAll(this);
        this.addAll(nextGen);



    }

    public void sortByfittness() {
        Collections.sort(this);
    }

    public MaxOneChromosome getBestone() {
        return this.get(this.size() - 1);
    }

    protected void addToSeparator(MaxOneChromosome moc) {

        Integer count = chromosomeSeperator.get(moc.getGenes());
        count =
                count == null ? 0 : count++;
        chromosomeSeperator.put(moc.getGenes(),
                count);
       // System.out.println(chromosomeSeperator.size());

    }

    public Selector<MaxOneChromosome> getBestSelector() {
        if (this.size() < 50) {
            System.out.println("Using tournament selection");
            return new TorunamentSelection<MaxOneChromosome>(2);
        } else {

            System.out.println("Using RoulateWeelSelection selection");
            return new RoulettewheelSelection<MaxOneChromosome>();
        }
    }

    @Override
    public String toString() {
       
        return "MaxOnePopulation{" + "populationsize=" + populationsize + ", bestSelector=" + bestSelector.toString() + '}' +super.toString();
    }
    
    
}
