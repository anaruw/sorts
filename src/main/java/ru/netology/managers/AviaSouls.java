package ru.netology.managers;

import ru.netology.data.Ticket;

import java.util.Arrays;
import java.util.Comparator;

public class AviaSouls {

    private Ticket[] tickets = new Ticket[0];

    private Ticket[] addToArray(Ticket[] current, Ticket ticket) {

        Ticket[] tmp = new Ticket[current.length + 1];

        for (int i = 0; i < current.length; i++) {

            tmp[i] = current[i];
        }
        tmp[current.length] = ticket;
        return tmp;
    }

    public void add(Ticket ticket) {

        tickets = addToArray(tickets, ticket);
    }

    public Ticket[] findAll() {
        return tickets;
    }

    private Ticket[] search(String from, String to) {

        Ticket[] result = new Ticket[0];

        for (Ticket ticket : tickets) {

            if (ticket.getFrom().equals(from) && ticket.getTo().equals(to)) {

                result = addToArray(result, ticket);
            }
        }
        return result;
    }

    public Ticket[] searchAndSortBy(String from, String to) {

        Ticket[] result = search(from, to);

        Arrays.sort(result);
        return result;
    }

    public Ticket[] searchAndSortBy(String from, String to, Comparator<Ticket> comparator, boolean defaultSort) {

        Ticket[] result = (defaultSort) ? searchAndSortBy(from, to) : search(from, to);

        Arrays.sort(result, comparator);
        return result;
    }
}