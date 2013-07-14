/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dineth.algorithm.genetic.main.abst.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.dineth.algorithm.genetic.main.abst.Chromosome;
import org.dineth.algorithm.genetic.main.abst.Population;

/**
 *
 * @author dewmalpc
 */
public abstract class AbstractPopulation<E extends Chromosome, G> extends ArrayList<E> implements Population<E> {

    protected Map<G, Integer> chromosomeSeperator = new HashMap<G, Integer>();
    protected final float elitism;
    protected final float mutation;
    protected final float crossover;

    public AbstractPopulation(float elitism, float mutation, float crossover) {
        super();
        this.elitism = elitism;
        this.mutation = mutation;
        this.crossover = crossover;

    }

    

    @Override
    public boolean addAll(Collection<? extends E> c) {

        chromosomeSeperator.clear();
        for (E e : c) {

            addToSeparator(e);
        }
        final boolean addAll = super.addAll(c);
        sortByfittness();

        return addAll;
    }

    @Override
    public boolean add(E e) {

        addToSeparator(e);
        
        
        final boolean add = super.add(e);


        sortByfittness();

        return add;
    }

    protected abstract void addToSeparator(E e);

    @Override
    public String toString() {
        return "AbstractPopulation{" + "elitism=" + elitism + ", mutation=" + mutation + ", crossover=" + crossover + '}';
    }
    
    
}
