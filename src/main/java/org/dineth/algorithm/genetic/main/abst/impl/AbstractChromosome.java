/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dineth.algorithm.genetic.main.abst.impl;

import org.dineth.algorithm.genetic.main.abst.Chromosome;
import org.dineth.algorithm.genetic.main.abst.Crossover;
import org.dineth.algorithm.genetic.main.abst.Mutattor;

/**
 *
 * @author dewmalpc
 */
public abstract class AbstractChromosome<T, E extends Chromosome> implements Chromosome<T>, Crossover<E>, Mutattor<E> {

    protected int fitness;
    protected final T gene;

    public AbstractChromosome(T gene) {
        this.gene = gene;
        fitness=getFitness();
    }

    public T getGenes() {
        return gene;
    }

    public int compareTo(Chromosome c) {
        if (getFitness() < c.getFitness()) {
            return -1;
        } else if (getFitness() > c.getFitness()) {
            return 1;
        }

        return 0;
    }

    @Override
    public String toString() {
        return "AbstractChromosome{" + "fitness=" + getFitness() + ", gene=" + gene + '}';
    }

      /**
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Chromosome)) {
            return false;
        }

        Chromosome c = (Chromosome) o;
        return (gene.equals(c.getGenes()) && fitness == c.getFitness());
    }

    /**
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {
        return new StringBuilder().append(gene).append(fitness)
                .toString().hashCode();
    }
}
