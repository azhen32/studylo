package com.azhen.other;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by azhen on 17-1-19.
 */
public class spyTest2 {
    public static void main(String[] args) {
        List spy = spy(new LinkedList());
//Impossible: real method is called so spy.get(0) throws IndexOutOfBoundsException (the list is yet empty)
       // when(spy.get(0)).thenReturn("foo");
//You have to use doReturn() for stubbing
        doReturn("foo").when(spy).get(0);
        System.out.println(spy.get(0));
    }
}
