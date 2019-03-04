
public class Item {

	private String theQuery;
	private int sortnum;
	private String retailprice;
	private String category;
	private String filter;
	private String filterbyprice;
	private String filterbycategory;
	public Item(){
		retailprice= " AND 3=3 ";
		filter = " ORDER BY BookID ";
		category = " AND 2=2 ";
		theQuery = "SELECT BookID, BookName,AuthorName, Category, WholesalePrice, RetailPrice, QOH, MinQuant FROM Inventory"
			+ " WHERE 1=1"
			+ retailprice
			+ category
			+ filter;
	}
public String getTheQuery() {
		return theQuery;
	}
	public void setTheQuery(String theQuery) {
		this.theQuery = theQuery;
	}
	public int getSortnum() {
		return sortnum;
	}
	public void setSortnum(int sortnum) {
		this.sortnum = sortnum;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getFilter() {
		return filter;
	}
	public void setFilter(String filter) {
		this.filter = filter;
	}
	public String getRetailprice() {
		return retailprice;
	}
	public void setRetailprice(String retailprice) {
		this.retailprice = retailprice;
	}
	public String getFilterbyprice() {
		return filterbyprice;
	}
	public void setFilterbyprice(String filterbyprice) {
		this.filterbyprice = filterbyprice;
	}
	public String getFilterbycategory() {
		return filterbycategory;
	}
	public void setFilterbycategory(String filterbycategory) {
		this.filterbycategory = filterbycategory;
	}



}
