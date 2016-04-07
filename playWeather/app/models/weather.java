package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.List;

/**
 * Created by tianmaolan on 16/3/29.
 */

@Entity
public class weather extends Model {

    @Id
    public Long id;

    @Constraints.Required
    public String title;

    @OneToOne(mappedBy="weather")

    public static Finder<Long,weather> find = new Finder(Long.class, weather.class);

    public static List<weather> all() {
        return find.all();
    }
}