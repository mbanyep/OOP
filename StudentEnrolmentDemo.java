ublic class StudentEnrolmentDemo {
    public static void main(String[] args) {
        Course computerNetworks = new Course("Computer Networks");
        Course dataStructures = new Course("Data Structures & Algorithms");
        Course entrepreneurship = new Course("Entrepreneurship Development");

        computerNetworks.registerStudents(40);
        dataStructures.registerStudents(35);
        entrepreneurship.registerStudents(25);

        int computerNetworksPresent = 36;
        int dataStructuresPresent = 30;
        int entrepreneurshipPresent = 22;

        System.out.println("Individual course statistics");
        computerNetworks.displayStatistics(computerNetworksPresent, 34);
        dataStructures.displayStatistics(dataStructuresPresent, 27);
        entrepreneurship.displayStatistics(entrepreneurshipPresent, 20);

        int totalPresent = computerNetworksPresent + dataStructuresPresent
                + entrepreneurshipPresent;
        double universityAttendancePercentage =
                totalPresent / (double) Course.getUniversityTotalStudents() * 100;

        System.out.println("\nUniversity-wide statistics");
        System.out.println("Total students registered: " + Course.getUniversityTotalStudents());
        System.out.printf("Overall attendance: %.2f%%%n", universityAttendancePercentage);
    }
}

class Course {
    private final String courseName;
    private int enrolledStudents;
    private static int universityTotalStudents;

    Course(String courseName) {
        this.courseName = courseName;
    }

    void registerStudents(int numberOfStudents) {
        if (numberOfStudents < 0) {
            throw new IllegalArgumentException("Number of students cannot be negative.");
        }

        enrolledStudents += numberOfStudents;
        universityTotalStudents += numberOfStudents;
    }

    double calculateAttendancePercentage(int studentsPresent) {
        if (studentsPresent < 0 || studentsPresent > enrolledStudents) {
            throw new IllegalArgumentException("Attendance must be between 0 and enrolment.");
        }

        double attendancePercentage = studentsPresent / (double) enrolledStudents * 100;
        return attendancePercentage;
    }

    double calculatePassPercentage(int studentsPassed) {
        if (studentsPassed < 0 || studentsPassed > enrolledStudents) {
            throw new IllegalArgumentException("Pass count must be between 0 and enrolment.");
        }

        double passPercentage = studentsPassed / (double) enrolledStudents * 100;
        return passPercentage;
    }

    void displayStatistics(int studentsPresent, int studentsPassed) {
        System.out.println("\nCourse: " + courseName);
        System.out.println("Students registered: " + enrolledStudents);
        System.out.printf("Attendance: %.2f%%%n", calculateAttendancePercentage(studentsPresent));
        System.out.printf("Pass rate: %.2f%%%n", calculatePassPercentage(studentsPassed));
    }

    static int getUniversityTotalStudents() {
        return universityTotalStudents;
    }
}
