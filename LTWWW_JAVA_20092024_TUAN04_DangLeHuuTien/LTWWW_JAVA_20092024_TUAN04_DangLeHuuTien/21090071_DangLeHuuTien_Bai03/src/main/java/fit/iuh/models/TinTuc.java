package fit.iuh.models;

public class TinTuc {
	private int maTT;
	private String tieuDe;
	private String noiDungTT;
	private String lienKet;
	private String maDM;

	public TinTuc() {
		super();
	}

	public TinTuc(int maTT, String tieuDe, String noiDungTT, String lienKet, String maDM) {
		super();
		this.maTT = maTT;
		this.tieuDe = tieuDe;
		this.noiDungTT = noiDungTT;
		this.lienKet = lienKet;
		this.maDM = maDM;
	}

	public int getMaTT() {
		return maTT;
	}

	public void setMaTT(int maTT) {
		this.maTT = maTT;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getNoiDungTT() {
		return noiDungTT;
	}

	public void setNoiDungTT(String noiDungTT) {
		this.noiDungTT = noiDungTT;
	}

	public String getLienKet() {
		return lienKet;
	}

	public void setLienKet(String lienKet) {
		this.lienKet = lienKet;
	}

	public String getMaDM() {
		return maDM;
	}

	public void setMaDM(String maDM) {
		this.maDM = maDM;
	}

}
