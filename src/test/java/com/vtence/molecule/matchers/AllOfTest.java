package com.vtence.molecule.matchers;

import com.vtence.molecule.Matcher;
import org.junit.Test;

import static com.vtence.molecule.matchers.StartingWith.startingWith;
import static org.hamcrest.MatcherAssert.assertThat;

public class AllOfTest {

    @SuppressWarnings("unchecked") @Test public void
    evaluatesToLogicalConjunctionOfMultipleMatchers() {
        Matcher<String> allOf = AllOf.allOf(startingWith("one"), startingWith("one two"), startingWith("one two three"));

        assertThat("no match but all matchers match", allOf.matches("one two three"));
        assertThat("match but one matcher does not match", !allOf.matches("one two two"));
    }

    @SuppressWarnings("unchecked") @Test public void
    supportsMatchingOnSuperType() {
        Matcher<String> allOf = AllOf.allOf(startingWith("good"), new Anything<Object>());

        assertThat("match", allOf.matches("good"));
    }
}
