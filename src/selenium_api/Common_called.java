package selenium_api;

public class Common_called {
	Common common1 = new Common();
	// ====================================================================================================
	public void A2() {
		common1.A1();
		String url = "url path";
		common1.open_page(url);
	}
	// End Sub Functions
}