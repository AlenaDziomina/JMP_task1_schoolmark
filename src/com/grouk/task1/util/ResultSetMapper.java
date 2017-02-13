package com.grouk.task1.util;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Alena on 12.02.2017.
 */
public interface ResultSetMapper<T> {
    T map(ResultSet rs) throws SQLException;
}
