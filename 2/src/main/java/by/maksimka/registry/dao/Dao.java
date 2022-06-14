package by.maksimka.registry.dao;

public interface Dao <T> {
    long create(T object );

    T find(long id );

    T remove(long id);

    T add(long id);

}
