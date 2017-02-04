package com.azhen.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by azhen on 17-2-4.
 */
public class StringUtil {
    public static List<String> toList(String ids) {
        List<String> myList = new ArrayList<String>(Arrays.asList(ids.split(",")));
        return myList;
    }
}
