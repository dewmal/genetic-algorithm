/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dineth.algorithm.genetic.main.abst;

import java.util.List;

/**
 *
 * @author dewmalpc
 */
public interface Crossover<E extends Chromosome> {
    
    
    /**
     * Crossover with 
     * 
     * @param chromosome
     * @return 
     */
    public List<E> doCrossover(E mateChromosome);
}
