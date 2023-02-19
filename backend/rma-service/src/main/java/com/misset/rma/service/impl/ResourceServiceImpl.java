package com.misset.rma.service.impl;

import com.misset.rma.logging.PatternOverlapException;
import com.misset.rma.model.Resource;
import com.misset.rma.model.availability.Availability;
import com.misset.rma.model.availability.Pattern;
import com.misset.rma.repository.ResourceRepository;
import com.misset.rma.service.ResourceService;
import org.apache.commons.lang3.Range;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;

public class ResourceServiceImpl extends AbstractRmaService<Resource> implements ResourceService {
    public ResourceServiceImpl(ResourceRepository resourceRepository) {
        super(resourceRepository);
    }

    @Override
    protected void canPersist(Resource entityToSave) {
        Availability availability = entityToSave.getAvailability();
        if (availability != null) {
            validateAvailability(availability);
        }
    }

    private void validateAvailability(Availability availability) {
        validateNoPatternOverlap("schema", availability.getSchema());
        validateNoPatternOverlap("overrides", availability.getOverrides());
    }

    private void validateNoPatternOverlap(String patternCollectionName, Collection<Pattern> patterns) {
        List<Pattern> patternList = patterns.stream()
                .filter(pattern -> hasPatternOverlap(pattern, patterns))
                .toList();
        if (!patternList.isEmpty()) {
            throw new PatternOverlapException(patternCollectionName, patternList);
        }
    }

    private boolean hasPatternOverlap(Pattern pattern, Collection<Pattern> patterns) {
        Range<ZonedDateTime> zonedDateTimeRange = pattern.computeRange();
        return patterns.stream()
                .filter(otherPattern -> !otherPattern.equals(pattern))
                .map(Pattern::computeRange)
                .anyMatch(zonedDateTimeRange::isOverlappedBy);
    }

}
