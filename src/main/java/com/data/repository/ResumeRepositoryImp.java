package com.data.repository;

import com.data.connection.ConnectionDB;
import com.data.model.Resume;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ResumeRepositoryImp implements ResumeRepository {
    @Override
    public List<Resume> findAll() {
        Connection conn = null;
        CallableStatement cs = null;
        List<Resume> resumes = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            cs = conn.prepareCall("{call find_all_resume()}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Resume resume = new Resume(
                        rs.getInt("id"),
                        rs.getString("full_name"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        rs.getString("education"),
                        rs.getString("experience"),
                        rs.getString("skills")
                );
                resumes.add(resume);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cs);
        }
        return resumes;
    }

    @Override
    public Resume findById(long id) {
        Connection conn = null;
        CallableStatement cs = null;
        Resume resume = null;
        try {
            conn = ConnectionDB.openConnection();
            cs = conn.prepareCall("{call find_resume_by_id(?)}");
            cs.setLong(1, id);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                resume = new Resume(
                        rs.getInt("id"),
                        rs.getString("full_name"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        rs.getString("education"),
                        rs.getString("experience"),
                        rs.getString("skills")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cs);
        }
        return resume;
    }

    @Override
    public boolean create(Resume resume) {
        Connection conn = null;
        CallableStatement cs = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            cs = conn.prepareCall("{call create_resume(?, ?, ?, ?, ?, ?)}");
            cs.setString(1, resume.getFullName());
            cs.setString(2, resume.getEmail());
            cs.setString(3, resume.getPhoneNumber());
            cs.setString(4, resume.getEducation());
            cs.setString(5, resume.getExperience());
            cs.setString(6, resume.getSkills());
            result = cs.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cs);
        }
        return result;
    }

    @Override
    public boolean update(Resume resume) {
        Connection conn = null;
        CallableStatement cs = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            cs = conn.prepareCall("{call update_resume(?, ?, ?, ?, ?, ?, ?)}");
            cs.setLong(1, resume.getId());
            cs.setString(2, resume.getFullName());
            cs.setString(3, resume.getEmail());
            cs.setString(4, resume.getPhoneNumber());
            cs.setString(5, resume.getEducation());
            cs.setString(6, resume.getExperience());
            cs.setString(7, resume.getSkills());
            result = cs.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cs);
        }
        return result;
    }

    @Override
    public boolean delete(long id) {
        Connection conn = null;
        CallableStatement cs = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            cs = conn.prepareCall("{call delete_resume(?)}");
            cs.setLong(1, id);
            result = cs.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cs);
        }
        return result;
    }
}
