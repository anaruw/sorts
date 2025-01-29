package ru.netology.managers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.comparators.TicketTimeComparator;
import ru.netology.data.Ticket;

public class AviaSoulsTest {

    String from = "Москва";
    String to = "Казань";
    int timeFrom1 = 1;
    int timeFrom2 = 2;
    int timeFrom3 = 5;
    int timeFrom4 = 10;
    int timeFrom5 = 16;

    Ticket testItem1 = new Ticket(
            from,
            to,
            3_300,
            timeFrom1,
            timeFrom1 + 1
    );
    Ticket testItem2 = new Ticket(
            from,
            to,
            2_700,
            timeFrom2,
            timeFrom2 + 1
    );
    Ticket testItem3 = new Ticket(
            from,
            to,
            2_100,
            timeFrom3,
            timeFrom3 + 2
    );
    Ticket testItem4 = new Ticket(
            from,
            to,
            3_300,
            timeFrom4,
            timeFrom4 + 1
    );
    Ticket testItem5 = new Ticket(
            from,
            to,
            3_300,
            timeFrom5,
            timeFrom5 + 2
    );

    @Test
    public void ticketDefaultCompareTest() {

        AviaSouls manager = new AviaSouls();

        {
            manager.add(testItem1);
            manager.add(testItem2);
            manager.add(testItem3);
            manager.add(testItem4);
            manager.add(testItem5);
        }
        Ticket[] expected = {testItem3, testItem2, testItem1, testItem4, testItem5};
        Ticket[] actual = manager.searchAndSortBy(from, to);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ticketTimeCompareTest() {

        AviaSouls manager = new AviaSouls();
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        boolean defaultSort = false;
        {
            manager.add(testItem1);
            manager.add(testItem2);
            manager.add(testItem3);
            manager.add(testItem4);
            manager.add(testItem5);
        }
        Ticket[] expected = {testItem1, testItem2, testItem4, testItem3, testItem5};
        Ticket[] actual = manager.searchAndSortBy(from, to, timeComparator, defaultSort);

        Assertions.assertArrayEquals(expected, actual);
    }

    //--------------------------------------------------------------------------------------------
    @Test
    public void ticketTimeAndPriceCompareTest() {

        AviaSouls manager = new AviaSouls();
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        boolean defaultSort = true;
        {
            manager.add(testItem1);
            manager.add(testItem2);
            manager.add(testItem3);
            manager.add(testItem4);
            manager.add(testItem5);
        }
        Ticket[] expected = {testItem2, testItem1, testItem4, testItem3, testItem5};
        Ticket[] actual = manager.searchAndSortBy(from, to, timeComparator, defaultSort);

        Assertions.assertArrayEquals(expected, actual);
    }
}