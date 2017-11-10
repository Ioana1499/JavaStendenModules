package com.jorisrietveld.containercompany.model;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 10-11-2017 09:33
 * License: GPLv3 - General Public License version 3
 */
public interface Repository<T extends Storable>
{
    /**
     * Gets new unique id.
     *
     * @return the new unique id
     */
    int getNewUniqueId();

    /**
     * Add an new entity to the repository.
     *
     * @param entity the new model
     */
    void add( T entity );

    /**
     * Replace an entity in the repository.
     *
     * @param entity the new model
     */
    void replace( T entity );

    /**
     * Gets an entity by id.
     *
     * @param id the id
     * @return the entity
     */
    T getById( int id );

    /**
     * Gets entities where.
     *
     * @param condition the condition the entity must match.
     * @return the entity
     */
    List<T> getWhere( Predicate<T> condition );

    /**
     * Gets one entity where.
     *
     * @param condition the condition
     * @return the one where
     */
    T getOneWhere( Predicate<T> condition );

    /**
     * Has model where boolean.
     *
     * @param condition the condition
     * @return the boolean
     */
    boolean hasEntityWhere( Predicate<T> condition );

    /**
     * Gets all entities.
     *
     * @return An list containing all entities.
     */
    List<T> getAll();
}
