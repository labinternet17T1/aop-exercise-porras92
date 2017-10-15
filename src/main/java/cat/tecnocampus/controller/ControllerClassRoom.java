package cat.tecnocampus.controller;

import cat.tecnocampus.persintence.ClassroomDAO;
import org.springframework.stereotype.Service;
import cat.tecnocampus.domain.Classroom;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
@Service("controllers")
public class ControllerClassRoom {
    private final ClassroomDAO classroomDAO;

    public ControllerClassRoom(ClassroomDAO classroomDAO) {
        this.classroomDAO = classroomDAO;
    }

    public Classroom createClassroom(String name, int capacity, String orientation, boolean plugs) {
        Classroom classroom = new Classroom.ClassroomBuilder()
                .capacity(capacity)
                .name(name)
                .orientation(orientation)
                .plugs(plugs)
                .build();
        insert(classroom);
        return classroom;
    }

    @Transactional
    public int insert(Classroom classroom) {
        return classroomDAO.insert(classroom);
    }

    @Transactional
    public int[] insertBatch(List<Classroom> classrooms) {
        return classroomDAO.insertBatch(classrooms);
    }


    public List<Classroom> findAll() {
        return classroomDAO.findAll();
    }

    public List<Classroom> findCapacityLowerThan(int capacity) {
        return classroomDAO.findCapacityLowerThan(capacity);
    }

    public List<Classroom> findCapacityLargerThan(int capacity) {
        return classroomDAO.findCapacityLargerThan(capacity);
    }

    public List<Classroom> findWithPlugs() {
        return classroomDAO.findWithPlugs();
    }
    public List<Classroom> findWithNoPlugs() {
        return classroomDAO.findWithNoPlugs();
    }
}