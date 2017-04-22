package main.ReservationSub.command;

import main.dbsub.ReservationImpl;
import main.model.Reservation;

/**
 * Created by Gize on 4/22/2017.
 */
public class SaveReservationCommand implements ReservationCommands {
    ReservationImpl imple= new ReservationImpl();
    Reservation obj;

    public SaveReservationCommand(Reservation reservation) {
        this.obj=reservation;
    }

    @Override
    public boolean executeReservationCommands() {
      return   imple.saveReservation(obj);
    }
}
