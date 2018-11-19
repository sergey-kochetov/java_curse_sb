package edu.javacourse.studentorder.dao;

import edu.javacourse.studentorder.domain.CountryArea;
import edu.javacourse.studentorder.domain.PassportOffice;
import edu.javacourse.studentorder.domain.RegisterOffice;
import edu.javacourse.studentorder.domain.Street;
import edu.javacourse.studentorder.exception.DaoException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

public class DictionaryDaoImplTest {

    private static final Logger logger = LoggerFactory.getLogger(DictionaryDaoImplTest.class);

    @BeforeClass
    public static void startUp() throws Exception {
        DBinit.startUp();
    }

    @Test
    public void testSteet() throws DaoException {
        // given
        List<Street> streets = new DictionaryDaoImpl().findStreets("про");

        //when then
        assertEquals(2, streets.size());
        assertEquals("Street{streetCode=2, streetName='Невский проспект'}", streets.get(0).print());
        assertEquals("Street{streetCode=5, streetName='проспект Ветеранов'}", streets.get(1).print());
    }

    @Test
    public void testPassportOffice() throws DaoException {
        // given
        List<PassportOffice> po = new DictionaryDaoImpl().findPassportOffices("010020000000");

        // when then
        assertEquals(2, po.size());
        assertEquals("PassportOffice{" +
                        "officeId=2, " +
                        "officeAreaId='010020000000', " +
                        "officeName='Паспортный стол 1 района 2 города'}",
                po.get(0).print());
        assertEquals("PassportOffice{" +
                        "officeId=3, " +
                        "officeAreaId='010020000000', " +
                        "officeName='Паспортный стол 2 района 2 города'}",
                po.get(1).print());
    }

    @Test
    public void testRegisterOffice() throws DaoException {
        // given
        List<RegisterOffice> ro = new DictionaryDaoImpl().findRegisterOffices("010010000000");

        // when then
        assertEquals(2, ro.size());
        assertEquals("RegisterOffice{officeId=1, " +
                        "officeAreaId='010010000000', " +
                        "officeName='ЗАГС 1 района 1 города'}",
                ro.get(0).print());
        assertEquals("RegisterOffice{officeId=2, " +
                        "officeAreaId='010010000000', " +
                        "officeName='ЗАГС 2 района 1 города'}",
                ro.get(1).print());
    }

    @Test
    public void testArea() throws DaoException {
        // given
        List<CountryArea> ca1 = new DictionaryDaoImpl().findAreas("");

        // when then
        assertEquals(2, ca1.size());
        assertEquals("CountryArea{" +
                "areaId='010000000000', " +
                "areaName='Город'}", ca1.get(0).print());
        assertEquals("CountryArea{" +
                "areaId='020000000000', " +
                "areaName='Край'}", ca1.get(1).print());
    }

    @Test
    public void testArea2() throws DaoException {
        // given
        List<CountryArea> ca2 = new DictionaryDaoImpl().findAreas("020000000000");

        // when then
        assertEquals(2, ca2.size());
    }

    @Test
    public void testArea3() throws DaoException {
        // given
        List<CountryArea> ca3 = new DictionaryDaoImpl().findAreas("020010000000");

        // when then
        assertEquals(2, ca3.size());
    }

    @Test
    public void testArea4() throws DaoException {
        // given
        List<CountryArea> ca4 = new DictionaryDaoImpl().findAreas("020010010000");

        // when then
        assertEquals(2, ca4.size());
    }

}