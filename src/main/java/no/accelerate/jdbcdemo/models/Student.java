package no.accelerate.jdbcdemo.models;

/**
 * Value object (Record) to represent the student table from the database.
 * Its immutable and has no identity (different from identifier - id).
 */
public record Student(int id, String name, int professorId) {
}
