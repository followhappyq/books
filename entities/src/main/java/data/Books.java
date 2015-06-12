package data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by HappyQ on 12.06.2015.
 */
@Entity
@Table(name = "T_BOOKS",schema = "", catalog = "books")
public class Books extends CustomEntity implements Serializable {

    @Basic
    @Column(name = "F_NAME")
    private String name;

    @Basic
    @Column(name = "F_AUTHOR")
    private String author;

    @Basic
    @Column(name = "F_YEAR")
    private String year;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Books books = (Books) o;

        if (author != null ? !author.equals(books.author) : books.author != null) return false;
        if (name != null ? !name.equals(books.name) : books.name != null) return false;
        if (year != null ? !year.equals(books.year) : books.year != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }
}
