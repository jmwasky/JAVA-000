package com.isaac.easy.mysqldbsample.hikari;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import com.google.common.collect.Maps;
import org.assertj.core.util.Lists;
import org.junit.Ignore;
import org.junit.Test;
import sun.nio.ch.IOUtil;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author think 生成节假日表 手动插入 workday_holiday
 * @date 2020/12/2
 */
@Ignore
public class DateTest {

    @Test
    public void dateTest2() {
        Date end = DateUtil.parse("2020-10-01");
        Date start = DateUtil.parse("2020-10-02");
        System.out.println(DateUtil.between(end, start, DateUnit.DAY));
    }
    @Test
    public void dateTest() throws InterruptedException {

        int startYear = 2021;
        // 节假日 找到国务院节假日网站查询
        List<String> holiday = Lists.newArrayList();
        holiday.add("2021-02-11");
        holiday.add("2021-02-12");
        holiday.add("2021-02-13");
        holiday.add("2021-02-14");
        holiday.add("2021-02-15");
        holiday.add("2021-02-16");
        holiday.add("2021-02-17");
        holiday.add("2021-04-03");
        holiday.add("2021-04-04");
        holiday.add("2021-04-05");
        holiday.add("2021-05-01");
        holiday.add("2021-05-02");
        holiday.add("2021-05-03");
        holiday.add("2021-05-04");
        holiday.add("2021-05-05");
        holiday.add("2021-06-12");
        holiday.add("2021-06-13");
        holiday.add("2021-06-14");
        holiday.add("2021-09-19");
        holiday.add("2021-09-20");
        holiday.add("2021-09-21");
        holiday.add("2021-10-01");
        holiday.add("2021-10-02");
        holiday.add("2021-10-03");
        holiday.add("2021-10-04");
        holiday.add("2021-10-05");
        holiday.add("2021-10-06");
        holiday.add("2021-10-07");
        // 调休上班
        List<String> workDay = Arrays.asList("2020-02-07", "2020-02-20","2020-04-25","2020-05-08",
                "2020-09-18","2020-09-26","2020-10-09");
        Calendar cal =  Calendar.getInstance();
        cal.set(startYear, 1 - 1, 4);
        Calendar cal2022 =  Calendar.getInstance();
        cal2022.set(startYear+2, 1 - 1, 3, 0, 0);

        List<WorkHoliday> workHolidayTableRow = Lists.newArrayList();
        WorkHoliday tempDay = new WorkHoliday();
        while (cal.before(cal2022)) {
            int weekDay = cal.get(Calendar.DAY_OF_WEEK) - 1;
            Date date = DateUtil.date(cal);
            String dateString = DateUtil.format(date, "yyyy-MM-dd");
            //System.out.println("week:"+weekDay);
            //System.out.println(DateUtil.format(date, "yyyy-MM-dd"));
            boolean policyWorkDay = !holiday.contains(dateString) && workDay.contains(weekDay);
            // 判断是工作日 周一到周五
            boolean dateWorkDay = weekDay > 0 && weekDay <= 5 && !holiday.contains(dateString);
            // 周末工作日
            boolean weekenWorkDay = (weekDay == 0 || weekDay == 6) && workDay.contains(weekDay);
            if (dateWorkDay || weekenWorkDay) {
                //System.out.println("工作日："+weekDay +","+dateString);
                if (null == tempDay.getWorkStart()) {
                    tempDay.setWorkStart(dateString);
                }
                if (null != tempDay.getHolidayEnd()) {
                    workHolidayTableRow.add(tempDay);
                    tempDay = new WorkHoliday();
                    tempDay.setWorkStart(dateString);
                }

            } else {
                // 第一次处理节假日
                if (null == tempDay.getHolidayStart()) {
                    tempDay.setHolidayStart(dateString);
                    // 把节假日前一天插入工作结束
                    Calendar yesterday = cal;
                    yesterday.add(Calendar.DATE, -1);
                    String yesterdayString = DateUtil.format(DateUtil.date(yesterday), "yyyy-MM-dd");
                    tempDay.setWorkEnd(yesterdayString);
                } else {
                    // holiday！=null, 后面连续放假
                    tempDay.setHolidayEnd(dateString);
                }
            }

            cal.add(Calendar.DATE, 1);
        }
        List<WorkHoliday> resultList = workHolidayTableRow.stream().map(record ->{
            Date end = DateUtil.parse(record.getHolidayEnd());
            Date start = DateUtil.parse(record.getHolidayStart());
            record.setHolidayNums((DateUtil.between(end, start, DateUnit.DAY)+1)+"");
            return record;
        }).collect(Collectors.toList());
        resultList.stream().forEach(System.out::println);
        FileUtil.writeLines(resultList,
                new File(this.getClass().getResource("").getPath()+"/test.txt"),
                StandardCharsets.UTF_8);
    }
    class WorkHoliday {
        private String workStart;
        private String workEnd;
        private String holidayStart;
        private String holidayEnd;
        private String holidayNums;

        @Override
        public String toString() {
            return workStart +"," + workEnd + "," + holidayStart +
                    "," + holidayEnd + ","+ holidayNums ;
        }

        public String getWorkStart() {
            return workStart;
        }

        public void setWorkStart( String workStart ) {
            this.workStart = workStart;
        }

        public String getWorkEnd() {
            return workEnd;
        }

        public void setWorkEnd( String workEnd ) {
            this.workEnd = workEnd;
        }

        public String getHolidayStart() {
            return holidayStart;
        }

        public void setHolidayStart( String holidayStart ) {
            this.holidayStart = holidayStart;
        }

        public String getHolidayEnd() {
            return holidayEnd;
        }

        public void setHolidayEnd( String holidayEnd ) {
            this.holidayEnd = holidayEnd;
        }

        public String getHolidayNums() {
            return holidayNums;
        }

        public void setHolidayNums( String holidayNums ) {
            this.holidayNums = holidayNums;
        }
    }
}
