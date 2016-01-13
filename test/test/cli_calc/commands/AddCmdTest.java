package test.cli_calc.commands;

import cli_calc.CalcResult;
import cli_calc.commands.AddCmd;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * test the add command which adds a list of integers passed to it
 */
public class AddCmdTest {

    @Test(expected = IllegalArgumentException.class)
    public void testAddZero() throws Exception {
        AddCmd a = new AddCmd(new ArrayList<>());
        CalcResult r = a.calculate();
        assertEquals(0, r.getRes(), .0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddOne() throws Exception {
        List<Double> in = new ArrayList<>();
        in.add(1.0);
        AddCmd a = new AddCmd(in);
        assertEquals(1, a.calculate().getRes(), .0001);
    }

    @Test
    public void testAddTwoArgs() throws Exception {
        List<Double> in = new ArrayList<>();
        double first = 54.0;
        double second = 62.3;
        in.add(first);
        in.add(second);
        AddCmd a = new AddCmd(in);
        CalcResult r = a.calculate();
        assertEquals(first + second, r.getRes(), .0001);
    }

    @Test
    public void testAddNRandomArgs() throws Exception {
        List<Double> in = new ArrayList<>();
        Random r = new Random();
        long nTenToTwenty = Math.round(r.nextDouble() * (20 - 10) + 10);
        double sum = 0;
        for (long i = 0; i < nTenToTwenty; ++i) {
            double nextDoub = r.nextDouble() * 100;
            sum += nextDoub;
            in.add(nextDoub);
        }

        AddCmd a = new AddCmd(in);

        assertEquals(sum, a.calculate().getRes(), .0001);
    }
}