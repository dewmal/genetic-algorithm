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
public interface Selector<T extends Chromosome> {

    /**
     *
     * @return selected parents from sutable method
     */
    public List<T> selectParent(Population<T> population,int numOfParents);
}
