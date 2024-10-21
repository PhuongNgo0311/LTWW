package fit.iuh.dao;

import java.util.List;

import fit.iuh.models.TinTuc;

public interface NewsDAO {
	public List<TinTuc> findAll();
	public TinTuc getById(int id);
	public void addNews(TinTuc n);
	public void remove(TinTuc n);
	public void clearAll();
}
