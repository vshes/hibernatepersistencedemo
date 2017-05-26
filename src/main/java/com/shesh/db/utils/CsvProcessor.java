package com.shesh.db.utils;

import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

/**
 * Created by shesh on 5/23/17.
 */
public  final class CsvProcessor {

    public static CellProcessor[] getProcessors() {

        final CellProcessor[] processors = new CellProcessor[] {
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new NotNull()
        };

        return processors;
    }
}
