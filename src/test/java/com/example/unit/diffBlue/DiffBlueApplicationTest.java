package com.example.unit.diffBlue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class DiffBlueApplicationTest {
    /**
     * Method under test: {@link DiffBlueApplication#run(String[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRun() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.unit.diffBlue.DiffBlueApplication.run(DiffBlueApplication.java:30)
        //   See https://diff.blue/R013 to resolve this issue.

        (new DiffBlueApplication()).run("Args");
    }
}

