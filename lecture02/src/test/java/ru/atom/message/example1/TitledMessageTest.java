package ru.atom.message.example1;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by sergey on 2/27/17.
 */
public class TitledMessageTest {

    @Test
    public void instance() throws Exception {
        TitledMessage message = new TitledMessage();

        assertThat(message, is(instanceOf(Message.class)));
        assertTrue(message instanceof Message);
    }
}