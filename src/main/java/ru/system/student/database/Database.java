package ru.system.student.database;

import ru.system.student.model.Faculty;
import ru.system.student.model.Passport;
import ru.system.student.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {

    public final static Map<Passport, Student> STUDENTS = new HashMap<>();

    public final static List<Faculty> FACULTIES =
            List.of(new Faculty("Математический", "+78279067969", "math@mail.ru"),
                    new Faculty("Физический", "+78279067889", "fiz@mail.ru"),
                    new Faculty("Экономический", "+78279034969", "eco@mail.ru"));
 }
