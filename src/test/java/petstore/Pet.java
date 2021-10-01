// 1 - Pacote
package petstore;

// 2 - Biblioteca
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

// 3 - Closse
public class Pet {
    // 3.1 - Atributos
    String url = "https://petstore.swagger.oi/v2/pet"; // endereço da entidade Pet

    // 3.2 - Metodos e Funções
    public String lerJson (String caminhoJson) throws IOException {

        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    // Incluir - Create - Post
    @Test // Identifica o metodo ou função como um teste para o TestNG
    public void incluirPet() throws IOException {
        String jsonBody = lerJson("db/pet1.json");

        // Sintaxe Gherkin
        // Dado - Quando - Então
        // Given - When - Then

        given()//Dado
                .contentType("application/json") // comun em API REST - antigas era "text/xml"
                .log().all()
                .body(jsonBody)
        .when() //Quando
                .post(url)
        .then()//Então
                .log().all()
                .statusCode(200)
        ;

    }

}
