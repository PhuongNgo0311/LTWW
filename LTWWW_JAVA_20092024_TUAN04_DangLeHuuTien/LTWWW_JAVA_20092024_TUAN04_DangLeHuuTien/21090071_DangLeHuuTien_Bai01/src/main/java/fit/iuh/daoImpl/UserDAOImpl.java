package fit.iuh.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import fit.iuh.dao.UserDAO;
import fit.iuh.models.Gender;
import fit.iuh.models.User;

public class UserDAOImpl implements UserDAO {

	private DataSource datasource;

	public UserDAOImpl(DataSource datasource) {
		this.datasource = datasource;
	}

	@Override
	public List<User> getAllUsers() {
		String sql = "SELECT * FROM user";
		List<User> list = new ArrayList<>();
		try (Connection con = this.datasource.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String email = rs.getString("email");
				String password = rs.getString("password");
				Date birthday = rs.getDate("birthday");
				String genderStr = rs.getString("gender");

				Gender gender = Gender.valueOf(genderStr.toUpperCase());
				list.add(new User(id, firstName, lastName, email, password, birthday, gender));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public User getById(int id) {
		String sql = "SELECT * FROM users WHERE id=?";
		User user = null;
		try (Connection con = this.datasource.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					String firstName = rs.getString("firstName");
					String lastName = rs.getString("lastName");
					String email = rs.getString("email");
					String password = rs.getString("password");
					Date birthday = rs.getDate("birthday");
					String genderStr = rs.getString("gender");
					Gender gender = Gender.valueOf(genderStr.toUpperCase());
					user = new User(id, firstName, lastName, email, password, birthday, gender);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void addUser(User u) {
		String sql = "INSERT INTO users (firstName, lastName, email, password, birthday, gender) VALUES (?,?,?,?,?,?)";
		try (Connection con = this.datasource.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getLastName());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			ps.setDate(5, new java.sql.Date(u.getBirthday().getTime()));
			ps.setString(6, u.getGender().toString());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
