package com.project.crystalball.exception;

import com.project.crystalball.exception.NoSuchItemFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NoSuchItemFoundExceptionTest {

    @Test
    public void testNoSuchItemFoundException() {
        NoSuchItemFoundException exception = new NoSuchItemFoundException("Item not found");

        assertEquals("Item not found", exception.getMessage());
    }
}

