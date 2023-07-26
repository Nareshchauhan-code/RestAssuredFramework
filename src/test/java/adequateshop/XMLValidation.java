package adequateshop;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
public class XMLValidation {
    @Test
    void getXMLNodes() {

        //base URI with Rest Assured class
        RestAssured.baseURI = "https://run.mocky.io/v3";

        //accept XML CONTENT as String
        String r = given().accept(ContentType.XML).when()

                //GET request
                .get("/c1d5e067-212d-4f63-be0db51751af1654")
                .thenReturn().asString();

        //object of XmlPath class
        XmlPath x = new XmlPath(r);

        //get nodes by traversing node paths
        System.out.println("Author name: " + x.getString("books.book.author"));
        System.out.println("Pages: " + x.getString("books.book.pages"));
    }
}