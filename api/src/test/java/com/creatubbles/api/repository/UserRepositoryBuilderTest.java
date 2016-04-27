package com.creatubbles.api.repository;

import com.creatubbles.api.model.AuthToken;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Janek on 18.02.2016.
 */
@RunWith(RobolectricTestRunner.class)
public class UserRepositoryBuilderTest {

    private UserRepositoryBuilder target;

    @Before
    public void setUp() {
        target = new UserRepositoryBuilder();
    }

    @Test
    public void testIsNullWhenPassedNullParameters() {
        UserRepository repository = target.build();
        assertNull(repository);
    }

    @Test
    public void testIsNotNullWhenPassedCorrectParameters() {
        target.setAuthToken(new AuthToken("testToken", "testTokenType", new Long("3")));
        UserRepository repository = target.build();
        assertNotNull(repository);
    }
}
