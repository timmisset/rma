package com.misset.rma.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class RmaGUID {

    private RmaGUID() {
        // private constructor
    }

    public static String generateGUID() {
        UUID randomUUID = UUID.randomUUID();
        String dateStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"));
        return dateStamp + "_" + randomUUID;
    }

}
