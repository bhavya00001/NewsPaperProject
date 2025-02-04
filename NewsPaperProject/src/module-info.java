module NewsPaperProject{
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.controls;
	requires javafx.base;
	requires java.sql;
	opens application to javafx.graphics, javafx.fxml;
	opens PaperMaster to javafx.graphics, javafx.fxml;
	opens hawkerOrganiserrrr to javafx.graphics, javafx.fxml;
	opens customerOrganiser to javafx.graphics, javafx.fxml;
	opens billGenerator to javafx.graphics, javafx.fxml;
	opens billCollector to javafx.graphics, javafx.fxml;
	opens HawkerTable to javafx.graphics, javafx.fxml,javafx.base;
	opens customerDashBoard to javafx.graphics, javafx.fxml,javafx.base;
	opens adminLogin to javafx.graphics, javafx.fxml;
	opens adminDesk to javafx.graphics, javafx.fxml;
	opens BillStatus to javafx.graphics, javafx.fxml;

}


