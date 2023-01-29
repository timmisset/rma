package com.misset.rma.utils;

import org.junit.jupiter.api.Test;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RmaGUIDTest {

    @Test
    void testGenerateGUIDGeneratesURLSafeToken() {
        String s = RmaGUID.generateGUID();
        String decode = URLDecoder.decode(s, StandardCharsets.UTF_8);
        assertEquals(decode, s);
    }

    @Test
    void testGenerateGUIDGeneratesUniqueToken() {
        Set<String> tokens = new HashSet<>();
        int numberOfTokens = 100;
        for (int i = 0; i < numberOfTokens; i++) {
            tokens.add(RmaGUID.generateGUID());
        }
        assertEquals(numberOfTokens, tokens.size());
    }
}
