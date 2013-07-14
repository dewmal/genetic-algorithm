/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dineth.algorithm.genetic.main.abst;

/**
 *
 * @author dewmalpc
 */
public interface Chromosome<T> extends Comparable<Chromosome> {

    public int getFitness();

    public T getGenes();
}
