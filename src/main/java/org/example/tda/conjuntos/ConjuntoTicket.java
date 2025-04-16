package org.example.tda.conjuntos;

import org.example.model.Ticket;

public class ConjuntoTicket implements IConjuntoTicket {
    private class Nodo {
        Ticket info;
        Nodo sig;
    }

    private Nodo c;

    public void InicializarConjunto() {
        c = null;
    }

    public Ticket Elegir() {
        if (c != null)
            return c.info;
        return null;
    }

    public void Sacar(int ticketID) {
        if (c != null) {
            if (c.info.getTicketID() == ticketID) {
                c = c.sig;
            } else {
                Nodo aux = c;
                while (aux.sig != null && aux.sig.info.getTicketID() != ticketID)
                    aux = aux.sig;
                if (aux.sig != null) {
                    aux.sig = aux.sig.sig;
                }
            }
        }
    }

    public void Agregar(Ticket ticket) {
        if (!this.Pertenece(ticket.getTicketID())) {
            Nodo nuevo = new Nodo();
            nuevo.info = ticket;
            nuevo.sig = c;
            c = nuevo;
        }
    }

    public boolean Pertenece(int ticketID) {
        Nodo aux = c;
        while (aux != null && aux.info.getTicketID() != ticketID)
            aux = aux.sig;
        return (aux != null);
    }

    public boolean ConjuntoVacio() {
        return (c == null);
    }

}
