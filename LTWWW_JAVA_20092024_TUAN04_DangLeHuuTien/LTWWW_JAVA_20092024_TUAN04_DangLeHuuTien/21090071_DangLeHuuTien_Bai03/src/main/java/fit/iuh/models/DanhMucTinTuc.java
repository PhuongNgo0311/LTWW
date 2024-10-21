package fit.iuh.models;

import java.util.ArrayList;
import java.util.List;

public class DanhMucTinTuc {
	private List<TinTuc> news = new ArrayList<>();
	
	public List<TinTuc> getNews() {
		return news;
	}
	
	public void addNews(TinTuc newsItem) {
        news.add(newsItem);
    }
	
	public void removeNew(TinTuc newsItem) {
        news.removeIf(existingNews -> existingNews.getMaTT() == newsItem.getMaTT());
    }

}
