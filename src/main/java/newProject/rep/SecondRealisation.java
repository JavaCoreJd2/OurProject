package newProject.rep;

import newProject.entity.Person;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class SecondRealisation implements PersonRep{

    @Override
    public List<Person> findAll() {
        return null;
    }
}
