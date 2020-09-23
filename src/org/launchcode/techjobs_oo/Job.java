package org.launchcode.techjobs_oo;

import java.util.Objects;


public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id = nextId;
        nextId++;
    }
    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {
        String sourceString =  "\nID: "+this.id+"\nName: "+this.name+"\nEmployer: "+this.employer+"\nLocation: "
                +this.location+"\nPosition type: "+this.positionType+"\nCore competency: "+this.coreCompetency+"\n";

        // Bonus: In order for the toString() method to be called upon the job, the job must exist as a Job instance.
        // The constructor *necessarily* assigns the instance a unique ID, so, if it exists as a Job instance,
        // it cannot have a null in place of job.id.
        // When " null" is used as a delimiter, the resulting list will have *precisely* 6 elements
        // IF AND ONLY IF all the other fields are null.
        // QED

        // (this seems a bit hacky, but to make it less "hard-coded", I would have to make the fields "public" and/or use
        // "reflection" and getFields() so I could get the length of the field list and assign THAT number to a variable instead,
        // to make the method(s) more resilient to adding more job info fields.
        // Maybe.
        // Meh. It's a bonus question anyway...:)

        String[] notExist = sourceString.split(" null");
        if (notExist.length == 6){
            return "OOPS! This job does not seem to exist.";
        }
        return sourceString.replace(" null", " Data not available");
        //return jobInfo;

    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
