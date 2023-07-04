package Utils;

import com.aspose.cells.*;

public class HtmlReportGenerator {
    public static void convertJsonToHtml() throws Exception {
        Workbook workbook = new Workbook("report/cucumber-report/cucumber.json");
        workbook.save("reportHtml/report.html");
    }
}
