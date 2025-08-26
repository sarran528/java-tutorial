import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySql {

    // CREATE
    public void insertStudent(String name, int age) {
        String sql = "INSERT INTO students (name, age) VALUES (?, ?)";
        try (Connection con = TestJar.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.executeUpdate();
            System.out.println("✅ Inserted student: " + name);
        } catch (Exception e) {
            System.out.println("❌ Insert failed:");
            e.printStackTrace();
        }
    }

    // READ
    public void readStudents() {
        String sql = "SELECT * FROM students";
        try (Connection con = TestJar.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("📋 Students:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " +
                        rs.getString("name") + " (" +
                        rs.getInt("age") + ")");
            }
        } catch (Exception e) {
            System.out.println("❌ Read failed:");
            e.printStackTrace();
        }
    }

    // UPDATE
    public void updateStudent(int id, int newAge) {
        String sql = "UPDATE students SET age = ? WHERE id = ?";
        try (Connection con = TestJar.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, newAge);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Updated student ID " + id);
            } else {
                System.out.println("⚠️ No student found with ID " + id);
            }
        } catch (Exception e) {
            System.out.println("❌ Update failed:");
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection con = TestJar.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Deleted student ID " + id);
            } else {
                System.out.println("⚠️ No student found with ID " + id);
            }
        } catch (Exception e) {
            System.out.println("❌ Delete failed:");
            e.printStackTrace();
        }
    }

    // MAIN TEST
    public static void main(String[] args) {
        MySql dao = new MySql();

//        dao.insertStudent("David", 23);
//        dao.insertStudent("Alice", 21);

        dao.readStudents();

//        dao.updateStudent(1, 30);
//
//        dao.deleteStudent(2);
//
//        dao.readStudents();
    }
}
