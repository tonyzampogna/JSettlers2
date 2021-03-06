/**
 * Java Settlers - An online multiplayer version of the game Settlers of Catan
 * This file Copyright (C) 2020 Jeremy D Monin <jeremy@nand.net>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * The maintainer of this program can be reached at jsettlers@nand.net
 **/
package soctest.i18n;

import org.junit.Test;
import static org.junit.Assert.*;

import soc.util.I18n;

/**
 * Tests for I18N - Some tests for {@link I18n} class methods.
 *
 * @since 2.3.00
 * @author Jeremy D Monin &lt;jeremy@nand.net&gt;
 */
public class TestI18N
{

    private void bytesToHumanUnits_testOne(final long bytes, final String expected)
    {
        assertEquals(expected, I18n.bytesToHumanUnits(bytes));
    }

    /**
     * Test {@link I18n#bytesToHumanUnits(long).
     */
    @Test
    public void testBytesToHumanUnits()
    {
        final int BYTES_1_MB = 1024 * 1024;
        final long BYTES_1_GB = BYTES_1_MB * 1024;

        bytesToHumanUnits_testOne(0, "0.00 MB");
        bytesToHumanUnits_testOne(5237, "0.00499 MB");  // just slightly below 0.00500 MB
        bytesToHumanUnits_testOne(5242, "0.00500 MB");

        bytesToHumanUnits_testOne((long) (2.10 * BYTES_1_MB), "2.10 MB");
        bytesToHumanUnits_testOne((long) (2.10 * BYTES_1_GB), "2.10 GB");
        bytesToHumanUnits_testOne((long) (3.15 * BYTES_1_MB), "3.15 MB");
        bytesToHumanUnits_testOne((long) (3.15 * BYTES_1_GB), "3.15 GB");

        bytesToHumanUnits_testOne((long) (23.7 * BYTES_1_MB), "23.7 MB");
        bytesToHumanUnits_testOne((long) (23.7 * BYTES_1_GB), "23.7 GB");

        bytesToHumanUnits_testOne((long) (100.49 * BYTES_1_MB), "100 MB");
        bytesToHumanUnits_testOne((long) (100.51 * BYTES_1_MB), "101 MB");

        bytesToHumanUnits_testOne((long) (123 * BYTES_1_MB), "123 MB");
        bytesToHumanUnits_testOne((long) (999 * BYTES_1_MB), "999 MB");
        bytesToHumanUnits_testOne((long) (1023 * BYTES_1_MB), "1023 MB");

        bytesToHumanUnits_testOne((long) (0.998 * BYTES_1_MB), "0.998 MB");
        bytesToHumanUnits_testOne((long) (1.001 * BYTES_1_MB), "1.00 MB");
        bytesToHumanUnits_testOne((long) (1.006 * BYTES_1_MB), "1.01 MB");

        bytesToHumanUnits_testOne(BYTES_1_MB, "1.00 MB");
        bytesToHumanUnits_testOne(BYTES_1_GB, "1.00 GB");
        bytesToHumanUnits_testOne(2 * BYTES_1_MB, "2.00 MB");
        bytesToHumanUnits_testOne(2 * BYTES_1_GB, "2.00 GB");
        bytesToHumanUnits_testOne(10 * BYTES_1_MB, "10.0 MB");
        bytesToHumanUnits_testOne(10 * BYTES_1_GB, "10.0 GB");
        bytesToHumanUnits_testOne(12 * BYTES_1_MB, "12.0 MB");
        bytesToHumanUnits_testOne(12 * BYTES_1_GB, "12.0 GB");

        bytesToHumanUnits_testOne((long) (1234.4 * BYTES_1_GB), "1234 GB");
        bytesToHumanUnits_testOne(123456 * BYTES_1_GB, "123456 GB");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testBytesToHumanUnits_badInput()
    {
        bytesToHumanUnits_testOne(-1, "unused");  // any negative should throw exception
    }

    public static void main(String[] args)
    {
        org.junit.runner.JUnitCore.main("soctest.i18n.TestI18N");
    }

}
