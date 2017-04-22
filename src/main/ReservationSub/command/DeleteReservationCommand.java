package main.ReservationSub.command;

import main.dbsub.ReservationImpl;
import main.model.Reservation;

/**
 * Created by Gize on 4/22/2017.
 */
public class DeleteReservationCommand implements ReservationCommands {
    ReservationImpl imple = new ReservationImpl();
    Reservation obj;

    public DeleteReservationCommand(Reservation obj) {
        this.obj = obj;
    }

    @Override
    public boolean executeReservationCommands() {
        return imple.deleteReservationById(new Integer(obj.getCode()).toString());
    }
}
