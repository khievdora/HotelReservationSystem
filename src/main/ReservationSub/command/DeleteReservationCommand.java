package main.ReservationSub.command;

import main.dbsub.DBFacade;
import main.dbsub.DBService;
import main.model.Reservation;

/**
 * Created by Gize on 4/22/2017.
 */
public class DeleteReservationCommand implements ReservationCommands {
    DBService dbService = new DBFacade();
    Reservation obj;

    public DeleteReservationCommand(Reservation obj) {
        this.obj = obj;
    }

    @Override
    public boolean executeReservationCommands() {
<<<<<<< HEAD
        return imple.deleteReservationById(new Integer(obj.getCode()).toString());
=======
        return dbService.deleteReservationById(obj.getCode()) != 0 ? true : false;
>>>>>>> edb7f986eab27816d9fbb7e236651d41dc19b58f
    }
}
