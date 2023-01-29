package com.misset.rma.service;

import com.misset.rma.utils.RmaEntityMapper;
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

    private static final Long ENTITY_DTO = 1L;
    public boolean canDelete = true;

    public boolean isValidated = false;

    @Mock
    RmaEntityMapper<Integer, Long> entityMapper;

    @Mock
    JpaRepository<Integer, String> repository;

    @Test
    void testGetReturnsEntityFromRepository() {
        // ARRANGE
        RmaServiceImpl rmaService = new RmaServiceImpl();
        when(repository.getReferenceById(ID)).thenReturn(ENTITY);
        when(entityMapper.toDto(ENTITY)).thenReturn(ENTITY_DTO);

        // ACT
        Long entityDto = rmaService.get(ID);

        // ASSERT
        assertEquals(ENTITY_DTO, entityDto);
    }

    @Test
    void testUpdateReturnsUpdatedEntityAfterCallingUpdateOnTheMapper() {
        // ARRANGE
        RmaServiceImpl rmaService = new RmaServiceImpl();
        when(repository.getReferenceById(ID)).thenReturn(ENTITY);
        when(entityMapper.toDto(ENTITY)).thenReturn(ENTITY_DTO);
        when(repository.save(ENTITY)).thenReturn(ENTITY);
        assertFalse(isValidated);

        // ACT
        Long entityDto = rmaService.update(ID, ENTITY_DTO);

        // ASSERT
        assertEquals(ENTITY_DTO, entityDto);
        assertTrue(isValidated);
        verify(entityMapper).update(ENTITY, ENTITY_DTO);
    }

    @Test
    void testAddCreatesAndSavesNewEntity() {
        // ARRANGE
        RmaServiceImpl rmaService = new RmaServiceImpl();
        when(entityMapper.toDto(ENTITY)).thenReturn(ENTITY_DTO);
        when(entityMapper.fromDto(ENTITY_DTO)).thenReturn(ENTITY);
        when(repository.save(ENTITY)).thenReturn(ENTITY);
        assertFalse(isValidated);

        // ACT
        Long entityDto = rmaService.add(ENTITY_DTO);

        // ASSERT
        assertEquals(ENTITY_DTO, entityDto);
        assertTrue(isValidated);
        verify(repository).save(ENTITY);
    }

    @Test
    void testGetAllReturnsAllEntities() {
        // ARRANGE
        RmaServiceImpl rmaService = new RmaServiceImpl();
        when(entityMapper.toDto(ENTITY)).thenReturn(ENTITY_DTO);
        when(repository.findAll()).thenReturn(List.of(ENTITY));

        // ACT
        Collection<Long> entities = rmaService.getAll();

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

    private class RmaServiceImpl extends AbstractRmaService<Integer, Long> {
        protected RmaServiceImpl() {
            super(AbstractRmaServiceTest.this.repository, AbstractRmaServiceTest.this.entityMapper);
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
