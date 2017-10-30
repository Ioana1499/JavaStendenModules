import static containercompany.ContainerModel.ContainerType;
import static org.junit.jupiter.api.Assertions.*;

import containercompany.Container;
import containercompany.ContainerModel;
import org.junit.jupiter.api.Test;

 /**
  * Author: Joris Rietveld <jorisrietveld@gmail.com>
  * Created: 30-10-2017 18:28
  * License: GPLv3 - General Public License version 3
  *
  * Test suit for the container model.
  * It it also tests all the container entity classes and the super class StorageModel are behaving properly.
  */
class ContainerModelTest
{
    /**
     * Test the initiation of the container model.
     */
    @Test
    void testInit()
    {
        ContainerModel model = new ContainerModel();
        ContainerModel emptyModel = new ContainerModel( true );

        assertFalse( model.getAll().isEmpty() );
        assertTrue( emptyModel.getAll().isEmpty() );
    }

    /**
     * Test adding a few containers and check if they are stored properly.
     */
    @Test
    void testAddContainer()
    {
        ContainerModel model = new ContainerModel();
        ContainerModel emptyModel = new ContainerModel( true);

        Container newContainer = model.addContainer( ContainerType.FLAT_RACK );
        Container newContainer2 = model.addContainer( ContainerType.NORMAL );

        Container newContainer3 = emptyModel.addContainer( ContainerType.FLAT_RACK );
        Container newContainer4 = emptyModel.addContainer( ContainerType.HALF_HEIGHT );

        assertSame( model.getById( newContainer.getId() ), newContainer );
        assertSame( model.getById( newContainer2.getId() ), newContainer2 );
        assertSame( emptyModel.getById( newContainer3.getId() ), newContainer3 );
        assertSame( emptyModel.getById( newContainer4.getId() ), newContainer4 );

        assertNotSame( model.getById( newContainer.getId() ), newContainer2 );
        assertNotSame( model.getById( newContainer2.getId() ), newContainer );
        assertNotSame( emptyModel.getById( newContainer3.getId() ), newContainer4 );
        assertNotSame( emptyModel.getById( newContainer4.getId() ), newContainer3 );
    }

    /**
     * Test if the average volume calculation is correct.
     */
    @Test
    void testAverageContainerVolume()
    {
        ContainerModel model = new ContainerModel( true );
        Container containerNormal = model.addContainer( ContainerType.NORMAL );
        Container containerHalfHeight = model.addContainer( ContainerType.HALF_HEIGHT );

        double average = (containerNormal.getVolume() + containerHalfHeight.getVolume()) / 2;

        assertEquals( average, model.getAverageContainerVolume() );

    }
}
