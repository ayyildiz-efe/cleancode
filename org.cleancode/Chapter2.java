package org.cleancode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Chapter2 {
    // Meaningful Names

    //__________________ NOT Recommended ___________________
    int d; // elapsed time in days

    //__________________ Recommended usage ___________________
    int elapsedTimeInDays;
    int daysSinceCreation;

    // because d means noting. What is does and Why it is exists

    int[][] theList = new int[0][];
    int[][] gameBoard;
    int STATUS_VALUE_INDEX = 0;
    int FLAGGED_STATUS = 4;

    //__________________ NOT Recommended ___________________

    public List<int[]> getThem() {
        List<int[]> list1 = new ArrayList<int[]>();
        for (int[] x : theList)
            if (x[0] == 4)
                list1.add(x);
        return list1;
    }

//    1) The method name getThem() is not descriptive and does not convey the purpose of the method.
//    2) The variable name list1 is not meaningful. It doesn't explain what the list contains or why it exists.
//    3) The loop variable x is not descriptive. It doesn't clarify what each element in the loop represents.
//    4) The condition x[0] == 4 is not clear. It's hard to understand what value 4 represents in this context.

    //__________________ Recommended usage ___________________

    public List<int[]> getFlaggedCells() {
        List<int[]> flaggedCells = new ArrayList<>();
        for (int[] cell : gameBoard) {
            if (cell[STATUS_VALUE_INDEX] == FLAGGED_STATUS) {
                flaggedCells.add(cell);
            }
        }
        return flaggedCells;
    }

//    1) The method from getThem() to getFlaggedCells() to accurately reflect its purpose.
//    2) Renamed the variable list1 to flaggedCells to clearly indicate what the list contains.
//    3) Changed the loop variable from x to cell to provide a more descriptive name.
//    4) Used constants (STATUS_VALUE_INDEX and FLAGGED_STATUS) instead of magic numbers to clarify the meaning of the comparison.

    //__________________ NOT Recommended ___________________
    int accountList[];

    //__________________ Recommended usage ___________________

    int accountGroup[];
    int accounts[];

    // Do not refer to a grouping of accounts as an accountList unless it’s actually a List, because the word List means something specific to programmers (List data type)..

    //__________________ NOT Recommended ___________________
    public static void copyChars(char a1[], char a2[]) {
        for (int i = 0; i < a1.length; i++) {
            a2[i] = a1[i];
        }
    }
    // a1 and a2 what are these ?
    //__________________ Recommended usage ___________________
    public static void copyCharacters(char[] source, char[] destination) {
        for (int i = 0; i < source.length; i++) {
            destination[i] = source[i];
        }
    }

    //__________________ NOT Recommended ___________________
    class DtaRcrd102 {
        private Date genymdhms;
        private Date modymdhms;
        private final String pszqint = "102";
    }
    //__________________ Recommended usage ___________________
    class Customer {
        private Date generationTimestamp;
        private Date modificationTimestamp;;
        private final String recordId = "102";
    }
    int s;
    int[] t;

    //__________________ NOT Recommended ___________________
    public int calculateTotalRealTaskWeeks(int[] taskEstimates) {
        for (int j = 0; j < 34; j++) {
            s += (t[j] * 4) / 5;
        }
        return s;
    }

    //__________________ Recommended usage ___________________

    public class TaskEstimator {
        private static final int REAL_DAYS_PER_IDEAL_DAY = 4;
        private static final int WORK_DAYS_PER_WEEK = 5;

        public int calculateTotalRealTaskWeeks(int[] taskEstimates) {
            int totalRealTaskWeeks = 0;

            for (int taskIndex = 0; taskIndex < taskEstimates.length; taskIndex++) {
                int realTaskDays = taskEstimates[taskIndex] * REAL_DAYS_PER_IDEAL_DAY;
                int realTaskWeeks = realTaskDays / WORK_DAYS_PER_WEEK;
                totalRealTaskWeeks += realTaskWeeks;
            }
            return totalRealTaskWeeks;
        }
    }

    //__________________ NOT Recommended ___________________
    private String m_dsc; // The textual description
    void setName(String name) {
    this.m_dsc = name; }

    //__________________ Recommended usage ___________________
    String description;
    void setDescription(String description) {
        this.description = description; }

    //__________________ NOT Recommended ___________________

    public interface DatabaseConnection {
        void connect();
    }

    public class DatabaseConnectionImpl implements DatabaseConnection {
        @Override
        public void connect() {
            // Default implementation to connect to a database
        }
    }

    public class MySQLConnectionImpl implements DatabaseConnection {
        @Override
        public void connect() {
            // Implementation for connecting to a MySQL database
        }
    }

    //__________________ Recommended usage ___________________

    public interface DatabaseConnectionTrue {
        void connect();
    }

    public class DefaultDatabaseConnection implements DatabaseConnectionTrue {
        @Override
        public void connect() {
            // Default implementation to connect to a database
        }
    }

    public class MySQLConnection implements DatabaseConnectionTrue {
        @Override
        public void connect() {
            // Implementation for connecting to a MySQL database
        }
    }
}
