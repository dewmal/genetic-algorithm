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
public interface Population<T extends Chromosome> extends  List<T> {

    /**
     *
     * @return
     */
    public T getBestone();

    /**
     *
     */
    public void sortByfittness();

    /**
     *
     *
     */
    public void selectNextgenaration();

    /**
     *
     * @return
     */
    public Selector<T> getBestSelector();
}
