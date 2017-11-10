package com.jorisrietveld.containercompany.model;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 15-10-2017 19:47
 * License: GPLv3 - General Public License version 3
 *
 * This class is the base model for all models that store entities.
 * @param <T> the model type parameter
 */
public abstract class NonPersistingRepository<T extends Storable> implements Repository<T>
{
    /**
     * The repository containing entities.
     */
    protected List<T> repository;

    /**
     * Instantiates a new Storage model.
     *
     * @param modelList the model list
     */
    protected NonPersistingRepository( List<T> modelList )
    {
        this.repository = modelList;
    }

    /**
     * Gets new unique id.
     *
     * @return the new unique id
     */
    public int getNewUniqueId()
    {
        return repository.stream().mapToInt( T::getId ).max()
                .orElse( 0 ) + 1; // Get highest id +1
    }

    /**
     * Add an new entity to the repository.
     *
     * @param entity the new model
     */
    public void add( T entity )
    {
        repository.stream().filter( e -> e.getId() == entity.getId() ).findFirst() // Find object with same id
                .ifPresent( model -> { // If so throw exception.
                    throw new IllegalArgumentException( String.format(
                            "Cannot add a new %1$s model to the %1$s repository because the id already exists.",
                            model.getClass().getSimpleName()
                    ) );
                } );

        repository.add( entity );
    }

    /**
     * Replace an entity in the repository.
     *
     * @param entity the new model
     */
    public void replace( T entity )
    {
        int storageIndex = this.repository.indexOf( this.getById( entity.getId() ) );
        repository.set( storageIndex, entity );
    }

    /**
     * Gets an entity by id.
     *
     * @param id the id
     * @return the entity
     */
    public T getById( int id )
    {
        return repository.stream().filter( item -> item.getId() == id ).findFirst()
                .orElseThrow( () -> new NoSuchElementException( String.format( "No model found with an id of:%d", id ) ) );
    }

    /**
     * Gets entities where.
     *
     * @param condition the condition the entity must match.
     * @return the entity
     */
    public List<T> getWhere( Predicate<T> condition )
    {
        return repository.stream().filter( condition ).collect( Collectors.toList() );
    }

    /**
     * Gets one entity where.
     *
     * @param condition the condition
     * @return the one where
     */
    public T getOneWhere( Predicate<T> condition )
    {
        return repository.stream().filter( condition ).findFirst().orElseGet( null );
    }

    /**
     * Has model where boolean.
     *
     * @param condition the condition
     * @return the boolean
     */
    public boolean hasEntityWhere( Predicate<T> condition )
    {
        return repository.stream().anyMatch( condition );
    }

    /**
     * Gets all entities.
     *
     * @return An list containing all entities.
     */
    public List<T> getAll()
    {
        return repository;
    }
}
