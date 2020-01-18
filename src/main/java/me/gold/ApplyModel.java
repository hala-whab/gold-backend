package me.gold;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ApplyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String Online;
    private String sys_tem;
    private String College;
    private String Term;
    private String InstructorUsername;
    private String  DateofBirth;
    private String CountryofBirth;
    private String Email;
    private String PhoneNumber;
    private String gender;
    private String CourseID;
    private String CourseTitle;
    private String Sections;
    private String teachear ;

    public ApplyModel() {
    }

    public ApplyModel(int id, String online, String sys_tem, String college, String term, String instructorUsername, String dateofBirth, String countryofBirth, String email, String phoneNumber, String gender, String courseID, String courseTitle, String sections, String teachear) {
        this.id = id;
        Online = online;
        sys_tem = sys_tem;
        College = college;
        Term = term;
        InstructorUsername = instructorUsername;
        DateofBirth = dateofBirth;
        CountryofBirth = countryofBirth;
        Email = email;
        PhoneNumber = phoneNumber;
        this.gender = gender;
        CourseID = courseID;
        CourseTitle = courseTitle;
        Sections = sections;
        this.teachear = teachear;
    }

    public ApplyModel(String online, String sys_tem, String college, String term, String instructorUsername, String dateofBirth, String countryofBirth, String email, String phoneNumber, String gender, String courseID, String courseTitle, String sections, String teachear) {
        Online = online;
        sys_tem = sys_tem;
        College = college;
        Term = term;
        InstructorUsername = instructorUsername;
        DateofBirth = dateofBirth;
        CountryofBirth = countryofBirth;
        Email = email;
        PhoneNumber = phoneNumber;
        this.gender = gender;
        CourseID = courseID;
        CourseTitle = courseTitle;
        Sections = sections;
        this.teachear = teachear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOnline() {
        return Online;
    }

    public void setOnline(String online) {
        Online = online;
    }

    public String getSys_tem() {
        return sys_tem;
    }

    public void setSys_tem(String sys_tem) {
        sys_tem = sys_tem;
    }

    public String getCollege() {
        return College;
    }

    public void setCollege(String college) {
        College = college;
    }

    public String getTerm() {
        return Term;
    }

    public void setTerm(String term) {
        Term = term;
    }

    public String getInstructorUsername() {
        return InstructorUsername;
    }

    public void setInstructorUsername(String instructorUsername) {
        InstructorUsername = instructorUsername;
    }

    public String getDateofBirth() {
        return DateofBirth;
    }

    public void setDateofBirth(String dateofBirth) {
        DateofBirth = dateofBirth;
    }

    public String getCountryofBirth() {
        return CountryofBirth;
    }

    public void setCountryofBirth(String countryofBirth) {
        CountryofBirth = countryofBirth;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCourseID() {
        return CourseID;
    }

    public void setCourseID(String courseID) {
        CourseID = courseID;
    }

    public String getCourseTitle() {
        return CourseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        CourseTitle = courseTitle;
    }

    public String getSections() {
        return Sections;
    }

    public void setSections(String sections) {
        Sections = sections;
    }

    public String getTeachear() {
        return teachear;
    }

    public void setTeachear(String teachear) {
        this.teachear = teachear;
    }

    @Override
    public String toString() {
        return "ApplyModel{" +
                "id=" + id +
                ", Online='" + Online + '\'' +
                ", sys_tem='" + sys_tem + '\'' +
                ", College='" + College + '\'' +
                ", Term='" + Term + '\'' +
                ", InstructorUsername='" + InstructorUsername + '\'' +
                ", DateofBirth='" + DateofBirth + '\'' +
                ", CountryofBirth='" + CountryofBirth + '\'' +
                ", Email='" + Email + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", CourseID='" + CourseID + '\'' +
                ", CourseTitle='" + CourseTitle + '\'' +
                ", Sections='" + Sections + '\'' +
                ", teachear='" + teachear + '\'' +
                '}';
    }
}
