package org.folio.rest.utils;

import org.folio.rest.jaxrs.model.PgPieces;

public class EmailTransaction {
    public String email;
    public String itemName;
    public String returnDay;
    public String returnTime;
    public String pdf;
    public PgTransaction<PgPieces> tx;

    public EmailTransaction(String email, String itemName, String returnDay, String returnTime, String pdf,
            PgTransaction<PgPieces> tx) {
        this.email = email;
        this.itemName = itemName;
        this.returnDay = returnDay;
        this.returnTime = returnTime;
        this.pdf = pdf;
        this.tx = tx;
    }
}
