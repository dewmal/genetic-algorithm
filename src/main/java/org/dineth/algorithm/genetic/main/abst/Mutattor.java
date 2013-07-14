/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dineth.algorithm.genetic.main.abst;

/**
 *
 * @author dewmalpc
 */
public interface Mutattor<E extends Chromosome>{
    
    
    public E doMutate();
}
