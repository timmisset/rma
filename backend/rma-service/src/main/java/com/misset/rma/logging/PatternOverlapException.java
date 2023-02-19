package com.misset.rma.logging;

import com.misset.rma.model.availability.Pattern;

import java.util.Collection;

public class PatternOverlapException extends ValidationException {
    public PatternOverlapException(String patternCollectionName, Collection<Pattern> overlappingPatterns) {
        super(
                String.format("Overlapping patterns detected for %s: %s", patternCollectionName, overlappingPatterns)
        );
    }
}
