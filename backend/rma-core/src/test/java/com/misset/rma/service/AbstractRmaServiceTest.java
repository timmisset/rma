package com.misset.rma.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AbstractRmaServiceTest {
    private static final String ID = "ID1";
    private static final Integer ENTITY = 1;

    public boolean canDelete = true;

    public boolean isValidated = false;

    @Mock
    JpaRepository<Integer, String> repository;

    @Test
    void testGetReturnsEntityFromRepository() {
        // ARRANGE
        RmaServiceImpl rmaService = new RmaServiceImpl();
        when(repository.getReferenceById(ID)).thenReturn(ENTITY);

        // ACT
        Integer entityDto = rmaService.get(ID);

        // ASSERT
        assertEquals(ENTITY, entityDto);
    }

    @Test
    void testUpdateReturnsUpdatedEntity() {
        // ARRANGE
        RmaServiceImpl rmaService = new RmaServiceImpl();
        when(repository.save(ENTITY)).thenReturn(ENTITY);
        assertFalse(isValidated);

        // ACT
        Integer entityDto = rmaService.update(ID, ENTITY);

        // ASSERT
        assertEquals(ENTITY, entityDto);
        assertTrue(isValidated);
    }

    @Test
    void testAddCreatesAndSavesNewEntity() {
        // ARRANGE
        RmaServiceImpl rmaService = new RmaServiceImpl();
        when(repository.save(ENTITY)).thenReturn(ENTITY);
        assertFalse(isValidated);

        // ACT
        Integer entityDto = rmaService.add(ENTITY);

        // ASSERT
        assertEquals(ENTITY, entityDto);
        assertTrue(isValidated);
        verify(repository).save(ENTITY);
    }

    @Test
    void testGetAllReturnsAllEntities() {
        // ARRANGE
        RmaServiceImpl rmaService = new RmaServiceImpl();
        when(repository.findAll()).thenReturn(List.of(ENTITY));

        // ACT
        Collection<Integer> entities = rmaService.getAll();

        // ASSERT
        assertEquals(1, entities.size());
    }

    @Test
    void testRemoveAllRemovesAllEntities() {
        // ARRANGE
        RmaServiceImpl rmaService = Mockito.spy(new RmaServiceImpl());
        when(repository.findAll()).thenReturn(List.of(ENTITY));

        // ACT
        rmaService.removeAll();

        // ASSERT
        verify(repository).delete(ENTITY);
    }

    @Test
    void testRemoveAllSkipsEntitiesThatShouldNotBeDeleted() {
        // ARRANGE
        RmaServiceImpl rmaService = Mockito.spy(new RmaServiceImpl());
        when(repository.findAll()).thenReturn(List.of(ENTITY));
        canDelete = false;

        // ACT
        rmaService.removeAll();

        // ASSERT
        verify(repository, never()).delete(ENTITY);
    }

    private class RmaServiceImpl extends AbstractRmaService<Integer> {
        protected RmaServiceImpl() {
            super(AbstractRmaServiceTest.this.repository);
        }

        @Override
        void validate(Integer entityToSave) {
            isValidated = true;
        }

        @Override
        boolean canDelete(Integer entityToDelete) {
            return canDelete;
        }
    }
}
