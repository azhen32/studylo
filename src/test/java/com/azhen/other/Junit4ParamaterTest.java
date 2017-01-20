package com.azhen.other;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class Junit4ParamaterTest {
    private SimpleDateFormat simpleDateFormat;
    private String date;
    private String dateformat;
    private String expectedDate;

    public Junit4ParamaterTest(SimpleDateFormat simpleDateFormat, String date, String dateformat, String expectedDate) {
        this.simpleDateFormat = simpleDateFormat;
        this.date = date;
        this.dateformat = dateformat;
        this.expectedDate = expectedDate;
    }

    //测试数据提供者

    @Parameterized.Parameters
    public static Collection data() {
        String[][] object = {
                {"2011-07-01 00:30:59","yyyyMMdd","20110701"},
                {"2011-07-01 00:30:59","yyyy年MM月dd日","2011年07月01日"},
                {"2011-07-01 00:30:59","HH时mm分ss秒","00时30分59秒"},
        };
        return Arrays.asList(object);
    }

    @Test
    public void testSimpleDateFormat() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = sdf.parse(this.date);
        simpleDateFormat = new SimpleDateFormat(this.dateformat);
        String result = simpleDateFormat.format(d);
        assertEquals(this.expectedDate,result);
    }
}
