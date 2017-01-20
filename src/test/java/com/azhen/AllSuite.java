package com.azhen;

import com.azhen.mapper.MapperSuite;
import com.azhen.service.ServiceSuite;
import com.azhen.controller.WebSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by azhen on 17-1-10.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ MapperSuite.class, ServiceSuite.class, WebSuite.class})
public class AllSuite {
}
