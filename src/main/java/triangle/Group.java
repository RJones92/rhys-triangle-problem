package triangle;

import java.util.Map;

public interface Group<T> {

    Map<String, T> getGroup();

    void addObjectToGroup(String objectName, T t);
}
