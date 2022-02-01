package models;

import dao.CheckListDAOImpl;
import dao.DAOCheck;
import jakarta.persistence.*;
import org.hibernate.metamodel.mapping.EntityAssociationMapping;

import java.io.Serializable;

//определяет сущность для записи
@Entity
@Table(name = "checklist")
public class CheckList implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "trycount")
    private Integer trycount;

    public CheckList() {}

    public CheckList(Integer trycount) {
        this.id = id;
        this.trycount = trycount;
    }

    public Integer getId() {
        return id;
    }


    public Integer getTrycount() {
        return trycount;
    }


    @Override
    public String toString() {
        return "CheckList{" +
                "id=" + id +
                ", countnumber=" + trycount +
                '}';
    }
}
