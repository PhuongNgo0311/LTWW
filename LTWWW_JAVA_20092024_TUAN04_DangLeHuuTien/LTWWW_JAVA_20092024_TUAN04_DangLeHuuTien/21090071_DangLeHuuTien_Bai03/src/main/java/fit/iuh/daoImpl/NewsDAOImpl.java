package fit.iuh.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import fit.iuh.dao.NewsDAO;
import fit.iuh.models.TinTuc;

public class NewsDAOImpl implements NewsDAO {
	private DataSource datasource;

	public NewsDAOImpl(DataSource datasource) {
		this.datasource = datasource;
	}

	@Override
	public List<TinTuc> findAll() {
		String sql = "SELECT * FROM news";
		List<TinTuc> list = new ArrayList<TinTuc>();
		try (Connection con = this.datasource.getConnection();
				PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				int id = rs.getInt("maTT");
				String tieuDe = rs.getString("tieuDe");
				String noiDung = rs.getString("noiDungTT");
				String lienKet = rs.getString("lienKet");
				String maDM = rs.getString("maDM");
				list.add(new TinTuc(id, tieuDe, noiDung, lienKet, maDM));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public TinTuc getById(int id) {
		String sql = "SELECT * FROM news WHERE maTT=?";
		TinTuc n = null;
		try (Connection con = this.datasource.getConnection();
				PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					String tieuDe = rs.getString("tieuDe");
					String noiDung = rs.getString("noiDungTT");
					String lienKet = rs.getString("lienKet");
					String maDM = rs.getString("maDM");
					n = new TinTuc(id, tieuDe, noiDung, lienKet, maDM);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public void addNews(TinTuc n) {
		String sql = "INSERT INTO news(tieuDe, noiDungTT, lienKet, maDM) VALUES(?,?,?,?)";
		try (Connection con = this.datasource.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, n.getTieuDe());
			ps.setString(2, n.getNoiDungTT());
			ps.setString(3, n.getLienKet());
			ps.setString(4, n.getMaDM());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(TinTuc n) {
		String sql = "DELETE FROM news WHERE maTT=?";
		try (Connection con = this.datasource.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, n.getMaTT());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void clearAll() {
		String sql = "DELETE FROM news";
		try (Connection con = this.datasource.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
