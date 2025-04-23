package org.example.tda.colas;

import org.example.model.WaitingListEntry;


// representa una cola de WaitingListEntry
public interface IColaWaitingList {
    void InicializarCola(); // pre: no aplica.
    void Acolar(WaitingListEntry entry); // pre: cola inicializada.
    void Desacolar(); // pre: cola inicializada y no vac�a.
    boolean ColaVacia(); // pre: cola inicializada.
    WaitingListEntry Primero(); // cola inicializada y no vac�a.
}
